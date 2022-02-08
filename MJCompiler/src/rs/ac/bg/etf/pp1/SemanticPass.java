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

	private Struct currRecord;

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
		if (currMethod == null && currRecord == null) tmp = Tab.find(normalVarDecl.getI1());
		else tmp = Tab.currentScope().findSymbol(normalVarDecl.getI1());
		
		if (tmp == Tab.noObj || tmp == null) {
			tmp = Tab.insert(currRecord == null ? Obj.Var : Obj.Fld, normalVarDecl.getI1(), currentType);
			if (currRecord != null) tmp.setLevel(2);
		}
		else {
			report_error("Multiple definitions of variable '" + normalVarDecl.getI1() + "'", normalVarDecl);
		}
	}
	
	@Override
	public void visit(ArrayVarDecl arrayVarDecl) {
		Obj tmp = null;
		if (currMethod == null && currRecord == null) tmp = Tab.find(arrayVarDecl.getI1());
		else tmp = Tab.currentScope().findSymbol(arrayVarDecl.getI1());
		
		if (tmp == Tab.noObj || tmp == null) {
			tmp = Tab.insert(currRecord == null ? Obj.Var : Obj.Fld, arrayVarDecl.getI1(), new Struct(Struct.Array, currentType));
			if (currRecord != null) tmp.setLevel(2);
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
	
	/*--------------------------------------------------------------------------------------------------------------------------------------------------------------*/
	/* ----------------------------------------------------------------------- RECORD_DECLARATIONS ---------------------------------------------------------------- */
	/*--------------------------------------------------------------------------------------------------------------------------------------------------------------*/
	
	@Override
	public void visit(RecordDeclName recordDeclName) {
		Obj tmp = Tab.find(recordDeclName.getI1());
		if (tmp != Tab.noObj) {
			report_error("Multiple definitions of record '" + recordDeclName.getI1() + "'", recordDeclName);
		}
		else {
			currRecord = new Struct(Struct.Class);
			tmp = Tab.insert(Obj.Type, recordDeclName.getI1(), currRecord);
			Tab.openScope();
		}
	}
	
	@Override
	public void visit(RecordDecl recordDecl) {
		Tab.chainLocalSymbols(currRecord);
		Tab.closeScope();
		currRecord = null;
	}
	
	/*--------------------------------------------------------------------------------------------------------------------------------------------------------------*/
	/* -------------------------------------------------------------------- CONTEXT_CONDITIONS -------------------------------------------------------------------- */
	/*--------------------------------------------------------------------------------------------------------------------------------------------------------------*/
	
	/* ---------------------------------------------------------------------- VISIT_FACTOR ------------------------------------------------------------------------ */
	@Override
	public void visit(Char character) {
		character.struct = Tab.charType;
	}
	
	@Override
	public void visit(Num num) {
		num.struct = Tab.intType;
	}
	
	@Override
	public void visit(Bool b) {
		b.struct = boolType;
	}
	
	@Override
	public void visit(NormalFactor normalFactor) {
		normalFactor.struct = normalFactor.getDesignator().obj.getType();
	}
	
	@Override
	public void visit(FactorWithActPars factorWithActPars) {
		factorWithActPars.struct = factorWithActPars.getDesignator().obj.getType();
	}
	
	@Override
	public void visit(NewFactor newFactor) {
		newFactor.struct = new Struct(Struct.Class, currentType.getMembersTable());
	}
	
	@Override
	public void visit(NewFactorWithPars newFactorWithPars) {
		if (!newFactorWithPars.getExpr().struct.equals(Tab.intType)) {
			report_error("(NewFactorWithPars) Trying to make an array with a non-int length", newFactorWithPars);
			newFactorWithPars.struct = Tab.noType;
		}
		else newFactorWithPars.struct = new Struct(Struct.Array, currentType);
	}
	
	@Override
	public void visit(FactorWithExpr factorWithExpr) {
		factorWithExpr.struct = factorWithExpr.getExpr().struct;
	}
	
	@Override
	public void visit(FactorWrapper factorWrapper) {
		if (factorWrapper.getUnary() instanceof UnaryNegative && !factorWrapper.getFactor().struct.equals(Tab.intType)) {
			report_error("Negating a non-int parameter", factorWrapper);
			factorWrapper.struct = Tab.noType;
		}
		else factorWrapper.struct = factorWrapper.getFactor().struct;
	}
	
	/* -------------------------------------------------------------------- VISIT_DESIGNATOR ---------------------------------------------------------------------- */
	@Override
	public void visit(DesignatorSimple designatorSimple) {
		designatorSimple.obj = Tab.find(designatorSimple.getI1());
		if (designatorSimple.obj == Tab.noObj) report_error("(designatorSimple) Variable '" + designatorSimple.getI1() + "' not defined,", designatorSimple);
		else if (designatorSimple.obj.getKind() != Obj.Var && designatorSimple.obj.getKind() != Obj.Con && designatorSimple.obj.getKind() != Obj.Meth) {
			report_error("(designatorSimple) Forbidden use of variable '" + designatorSimple.getI1() + "'", designatorSimple);
			designatorSimple.obj = Tab.noObj;
		}
	}
	
	@Override
	public void visit(DesignatorArrName designatorArrName) {
		designatorArrName.obj = Tab.find(designatorArrName.getI1());
		if (designatorArrName.obj == Tab.noObj) report_error("(DesignatorArrName) Array '" + designatorArrName.getI1() + "' not defined,", designatorArrName);
		else if (designatorArrName.obj.getKind() != Obj.Var || designatorArrName.obj.getType().getKind() != Struct.Array) {
			report_error("(DesignatorArrName) Variable '" + designatorArrName.getI1() + "' is probably not an array", designatorArrName);
			designatorArrName.obj = Tab.noObj;
			currRecord = Tab.noType;
		}
	}
	
	@Override
	public void visit(DesignatorArr designatorArr) {
		designatorArr.obj = designatorArr.getDesignatorArrName().obj;
		if (!designatorArr.getExpr().struct.equals(Tab.intType)) {
			report_error("Array can only be addresed with int", designatorArr);
			designatorArr.obj = Tab.noObj;
			currRecord = Tab.noType;
		}
		else if (designatorArr.obj != Tab.noObj) {
			designatorArr.obj = new Obj(Obj.Elem, designatorArr.getDesignatorArrName().getI1() + "[$]", designatorArr.obj.getType().getElemType());
		}
	}
	
	@Override
	public void visit(DesignatorWithMore designatorWithMore) {
		designatorWithMore.obj = designatorWithMore.getDesignatorMore().obj;
	}
	
	@Override
	public void visit(DesignatorWithMoreName designatorWithMoreName) {
		designatorWithMoreName.obj = Tab.find(designatorWithMoreName.getI1());
		currRecord = designatorWithMoreName.obj.getType();
		if (designatorWithMoreName.obj == Tab.noObj) report_error("(DesignatorWithMoreName) Record '" + designatorWithMoreName.getI1() + "' not defined,", designatorWithMoreName);
		else if (designatorWithMoreName.obj.getKind() != Struct.Class || designatorWithMoreName.obj.getType().getKind() != Obj.Var) {
			report_error("(DesignatorWithMoreName) Variable '" + designatorWithMoreName.getI1() + "' is probably not a record", designatorWithMoreName);
			designatorWithMoreName.obj = Tab.noObj;
			currRecord = Tab.noType;
		}
	}
	
	@Override
	public void visit(DesignatorMoreElem designatorMoreElem) {
		designatorMoreElem.obj = designatorMoreElem.getDesignatorArrName().obj;
		currRecord = Tab.noType;
		if (!designatorMoreElem.getExpr().struct.equals(Tab.intType)) {
			report_error("Array can only be addresed with int", designatorMoreElem);
			designatorMoreElem.obj = Tab.noObj;
			currRecord = Tab.noType;
		}
		else if (designatorMoreElem.obj != Tab.noObj) {
			designatorMoreElem.obj = new Obj(Obj.Elem, designatorMoreElem.getDesignatorArrName().getI1() + "[$]", designatorMoreElem.obj.getType().getElemType());
			currRecord = designatorMoreElem.obj.getType();
			
			if (designatorMoreElem.obj.getType().getKind() != Struct.Class) {
				report_error("(DesignatorMoreElem) Variable in '" + designatorMoreElem.getDesignatorArrName() + "' is probably not a record", designatorMoreElem);
				designatorMoreElem.obj = Tab.noObj;
				currRecord = Tab.noType;
			}
		}
	}
	
	@Override
	public void visit(DesigMoreDot desigMoreDot) {
		if (currRecord == Tab.noType) desigMoreDot.obj = Tab.noObj;
		else {
			boolean found = false;
			for (Obj tmp : currRecord.getMembers()) {
				if (tmp.getName().equals(desigMoreDot.getI1())) {
					desigMoreDot.obj = tmp;
					found = true;
					break;
				}
			}
			if (!found) {
				desigMoreDot.obj = Tab.noObj;
				report_error("(DesigMoreDot) Variable '" + desigMoreDot.getI1() + "' not found in the record", desigMoreDot);
			}
		}
		currRecord = null;
	}
	
	@Override
	public void visit(DesigMoreDotArr desigMoreDotArr) {
		if (currRecord == Tab.noType) desigMoreDotArr.obj = Tab.noObj;
		else if (!desigMoreDotArr.getExpr().struct.equals(Tab.intType)) {
			report_error("(DesigMoreDotArr) Array can only be addresed with int", desigMoreDotArr);
			desigMoreDotArr.obj = Tab.noObj;
		}
		else {
			boolean found = false;
			for (Obj tmp : currRecord.getMembers()) {
				if (tmp.getName().equals(desigMoreDotArr.getDesignatorArrName().getI1()) && tmp.getType().getKind() == Struct.Array) {
					desigMoreDotArr.obj = new Obj(Obj.Elem, tmp.getName() + "[$]", tmp.getType().getElemType());
					found = true;
					break;
				}
			}
			if (!found) {
				desigMoreDotArr.obj = Tab.noObj;
				report_error("(DesigMoreDot) Variable '" + desigMoreDotArr.getDesignatorArrName().getI1() + "' not found in the record", desigMoreDotArr);
			}
		}
		currRecord = null;
	}
	
	@Override
	public void visit(DesigMoreDotList desigMoreDotList) {
		if (desigMoreDotList.getDesignatorMore().obj.getType() == Tab.noType) desigMoreDotList.obj = Tab.noObj;
		else {
			boolean found = false;
			for (Obj tmp : currRecord.getMembers()) {
				if (tmp.getName().equals(desigMoreDotList.getI2())) {
					desigMoreDotList.obj = tmp;
					found = true;
					break;
				}
			}
			if (!found) {
				desigMoreDotList.obj = Tab.noObj;
				report_error("(DesigMoreDotList) Variable '" + desigMoreDotList.getI2() + "' not found in the record", desigMoreDotList);
			}
		}
	}
	
	@Override
	public void visit(DesigMoreDotArrList desigMoreDotArrList) {
		if (desigMoreDotArrList.getDesignatorMore().obj.getType() == Tab.noType) desigMoreDotArrList.obj = Tab.noObj;
		else if (!desigMoreDotArrList.getExpr().struct.equals(Tab.intType)) {
			report_error("(DesigMoreDotList) Array can only be addresed with int", desigMoreDotArrList);
			desigMoreDotArrList.obj = Tab.noObj;
		}
		else {
			boolean found = false;
			for (Obj tmp : currRecord.getMembers()) {
				if (tmp.getName().equals(desigMoreDotArrList.getDesignatorArrName().getI1()) && tmp.getType().getKind() == Struct.Array) {
					desigMoreDotArrList.obj = new Obj(Obj.Elem, tmp.getName() + "[$]", tmp.getType().getElemType());;
					found = true;
					break;
				}
			}
			if (!found) {
				desigMoreDotArrList.obj = Tab.noObj;
				report_error("(DesigMoreDotList) Variable '" + desigMoreDotArrList.getDesignatorArrName().getI1() + "' not found in the record", desigMoreDotArrList);
			}
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

