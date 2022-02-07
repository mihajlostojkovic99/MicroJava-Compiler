package rs.ac.bg.etf.pp1;
import org.apache.log4j.Logger;

import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;

public class SemanticPass extends VisitorAdaptor {

	boolean errorDetected = false;

	Logger log = Logger.getLogger(getClass());

	private Obj thisProgram;

	private Struct currentType;
	
	private Struct boolType = Tab.find("bool").getType();

	private boolean mainHappened = false;

	private Obj currMethod;

	public void report_error(String message, SyntaxNode info) {
		errorDetected = true;
		StringBuilder msg = new StringBuilder(message);
		int line = (info == null) ? 0: info.getLine();
		if (line != 0)
			msg.append (" in line ").append(line).append(".");
		log.error(msg.toString());
	}

	public void report_info(String message, SyntaxNode info) {
		StringBuilder msg = new StringBuilder(message); 
		int line = (info == null) ? 0: info.getLine();
		if (line != 0)
			msg.append (" in line ").append(line).append(".");
		log.info(msg.toString());
	}
	
	@Override
	public void visit(ProgramName programName) {
		thisProgram = Tab.insert(Obj.Prog, programName.getI1(), Tab.noType);
		Tab.openScope();
	}
	
	@Override
	public void visit(Program program) {		
		Tab.chainLocalSymbols(thisProgram);
		Tab.closeScope();
		
		if (!mainHappened)
			report_error("void main() method is not defined", program);
	}
	
	/*--------------------------------------------------------------------------------------------------------------------------------------------------------------*/
	/* ----------------------------------------------------------------- GLOBAL_CONST_DECLARATIONS ---------------------------------------------------------------- */
	/*--------------------------------------------------------------------------------------------------------------------------------------------------------------*/
	
	@Override
	public void visit(ConstDeclBool constDeclBool) {
		Obj tmp = Tab.find(constDeclBool.getI1());
		if (tmp != Tab.noObj) {
			report_error("Multiple definitions of constant '" + constDeclBool.getI1() + "'", constDeclBool);
		}
		else {
			if (boolType.assignableTo(currentType)) {
				tmp = Tab.insert(Obj.Con, constDeclBool.getI1(), currentType);
				tmp.setAdr(constDeclBool.getB2());
			}
			else {
				report_error("Forbidden assignment for '" + constDeclBool.getI1() + "'", constDeclBool);
			}
		}
	}
	
	@Override
	public void visit(ConstDeclChar constDeclChar) {
		Obj tmp = Tab.find(constDeclChar.getI1());
		if (tmp != Tab.noObj) {
			report_error("Multiple definitions of constant '" + constDeclChar.getI1() + "'", constDeclChar);
		}
		else {
			if (Tab.charType.assignableTo(currentType)) {
				tmp = Tab.insert(Obj.Con, constDeclChar.getI1(), currentType);
				tmp.setAdr(constDeclChar.getC2());
			}
			else {
				report_error("Forbidden assignment for '" + constDeclChar.getI1() + "'", constDeclChar);
			}	
		}
	}
	
	@Override
	public void visit(ConstDeclNumber constDeclNumber) {
		Obj tmp = Tab.find(constDeclNumber.getI1());
		if (tmp != Tab.noObj) {
			report_error("Multiple definitions of constant '" + constDeclNumber.getI1() + "'", constDeclNumber);
		}
		else {
			if (Tab.intType.assignableTo(currentType)) {
				tmp = Tab.insert(Obj.Con, constDeclNumber.getI1(), currentType);
				tmp.setAdr(constDeclNumber.getN2());
			}
			else {
				report_error("Forbidden assignment for '" + constDeclNumber.getI1() + "'", constDeclNumber);
			}
		}
	}
	
	/*--------------------------------------------------------------------------------------------------------------------------------------------------------------*/
	/* ------------------------------------------------------------------- GLOBAL_VAR_DECLARATIONS ---------------------------------------------------------------- */
	/*--------------------------------------------------------------------------------------------------------------------------------------------------------------*/
	
	@Override
	public void visit(NormalVarDecl normalVarDecl) {
		Obj tmp = null;
		if (currMethod == null) tmp = Tab.find(normalVarDecl.getI1());
		else tmp = Tab.currentScope().findSymbol(normalVarDecl.getI1());
		
		if (tmp == Tab.noObj || tmp == null) {
			tmp = Tab.insert(Obj.Var, normalVarDecl.getI1(), currentType);
		}
		else {
			report_error("Multiple definitions of variable '" + normalVarDecl.getI1() + "'", normalVarDecl);
		}
	}
	
	@Override
	public void visit(ArrayVarDecl arrayVarDecl) {
		Obj tmp = null;
		if (currMethod == null) tmp = Tab.find(arrayVarDecl.getI1());
		else tmp = Tab.currentScope().findSymbol(arrayVarDecl.getI1());
		
		if (tmp == Tab.noObj || tmp == null) {
			tmp = Tab.insert(Obj.Var, arrayVarDecl.getI1(), new Struct(Struct.Array, currentType));
		}
		else {
			report_error("Multiple definitions of variable '" + arrayVarDecl.getI1() + "'", arrayVarDecl);
		}
	}
	
	/*--------------------------------------------------------------------------------------------------------------------------------------------------------------*/
	/* ----------------------------------------------------------------------- METHOD_DECLARATIONS ---------------------------------------------------------------- */
	/*--------------------------------------------------------------------------------------------------------------------------------------------------------------*/
	
	@Override
	public void visit(MethodName methodName) {
		if (methodName.getI1().equalsIgnoreCase("main") && currentType == Tab.noType) mainHappened  = true;
		currMethod = Tab.insert(Obj.Meth, methodName.getI1(), currentType);
		Tab.openScope();
	}
	
	@Override
	public void visit(MethodRetVoid methodRetVoid) {
		currentType = Tab.noType;
	}
	
	@Override
	public void visit(MethDeclParams methDeclParams) {
		Tab.chainLocalSymbols(currMethod);
		Tab.closeScope();
		currMethod = null;
	}
	
	@Override
	public void visit(MethDeclNoParams methDeclNoParams) {
		Tab.chainLocalSymbols(currMethod);
		Tab.closeScope();
		currMethod = null;
	}
	
	@Override
	public void visit(FormalParameter formalParameter) {
		Obj tmp = null;
		if (currMethod == null) report_error("No current method for formal parameters. Error in class singleFormPars", formalParameter);
		else tmp = Tab.currentScope().findSymbol(formalParameter.getI2());
		
		if (currMethod.getName().equalsIgnoreCase("main") && currMethod.getType() == Tab.noType) 
			report_error("Formal parameters in void main() are forbidden", formalParameter);
		
		if (tmp == Tab.noObj || tmp == null) {
			tmp = Tab.insert(Obj.Var, formalParameter.getI2(), currentType);
			currMethod.setLevel(currMethod.getLevel() + 1);
			tmp.setFpPos(1);
		}
		else {
			report_error("Multiple definitions of formal parameter '" + formalParameter.getI2() + "'", formalParameter);
		}
	}
	
	@Override
	public void visit(FormalParameterArray formalParameterArray) {
		Obj tmp = null;
		if (currMethod == null) report_error("No current method for formal parameters. Error in class singleFormPars", formalParameterArray);
		else tmp = Tab.currentScope().findSymbol(formalParameterArray.getI2());
		
		if (currMethod.getName().equalsIgnoreCase("main")) report_error("Formal parameters in void main() are forbidden", formalParameterArray);
		
		if (tmp == Tab.noObj || tmp == null) {
			tmp = Tab.insert(Obj.Var, formalParameterArray.getI2(), new Struct(Struct.Array, currentType));
			currMethod.setLevel(currMethod.getLevel() + 1);
			tmp.setFpPos(1);
		}
		else {
			report_error("Multiple definitions of variable '" + formalParameterArray.getI2() + "'", formalParameterArray);
		}
	}
	
	@Override
	public void visit(Type type) {
		Obj typeObj = Tab.find(type.getI1());
		if (typeObj == Tab.noObj) {
			report_error("Type '" + type.getI1() + "' is not defined", type);
			currentType = Tab.noType;
			return;
		}
		
		if (typeObj.getKind() != Obj.Type) {
			report_error("Unallowed type '" + type.getI1() + "'", type);
			return;
		}
		
		currentType = typeObj.getType();
	}
	
	public boolean passed() {
		return !errorDetected;
	}
	
}

