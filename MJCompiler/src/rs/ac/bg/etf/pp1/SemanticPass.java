package rs.ac.bg.etf.pp1;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.HashSet;

import org.apache.log4j.Logger;

import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;

public class SemanticPass extends VisitorAdaptor {

	boolean errorDetected = false;

	Logger log = Logger.getLogger(getClass());
	
	int nVars;

	private Obj thisProgram;

	private Struct currentType;
	
	private Struct boolType = Tab.find("bool").getType();

	private boolean mainHappened = false;

	private Obj currMethod;

	private Struct currRecord;
	
	private HashSet<String> methodLabels;

	private HashSet<String> methodCalledLabels;

	private boolean returnHappened;

	private int doWhileCnt = 0;

	private List<Struct> currActPars;
	
	private Stack<List<Struct>> stackActPars = new Stack<List<Struct>>();

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
		nVars = Tab.currentScope().getnVars();
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
		methodName.obj = currMethod;
		Tab.openScope();
		methodLabels = new HashSet<String>();
		methodCalledLabels = new HashSet<String>();
	}
	
	@Override
	public void visit(MethodRetVoid methodRetVoid) {
		currentType = Tab.noType;
	}
	
	@Override
	public void visit(MethodRetType methodRetType) {
//		methodRetType.obj = currMethod;
	}
	
	@Override
	public void visit(MethDeclParams methDeclParams) {
		Tab.chainLocalSymbols(currMethod);
		Tab.closeScope();
		if (!methodLabels.containsAll(methodCalledLabels)) report_error("(MethDeclParams) Some labels are undefined!", methDeclParams);
		if (!returnHappened && currMethod.getType() != Tab.noType) report_error("(MethDeclParams) Method '" + currMethod.getName() + "' has no return", methDeclParams);
		returnHappened = false;
		currMethod = null;
		methodLabels = null;
		methodCalledLabels = null;
	}
	
	@Override
	public void visit(MethDeclNoParams methDeclNoParams) {
		Tab.chainLocalSymbols(currMethod);
		Tab.closeScope();
		if (!methodLabels.containsAll(methodCalledLabels)) report_error("(MethDeclNoParams) Some labels are undefined!", methDeclNoParams);
		if (!returnHappened && currMethod.getType() != Tab.noType) report_error("(MethDeclParams) Method '" + currMethod.getName() + "' has no return", methDeclNoParams);
		returnHappened = false;
		currMethod = null;
		methodLabels = null;
		methodCalledLabels = null;
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
		factorWithActPars.struct = Tab.noType;
		if (factorWithActPars.getDesignator().obj.getKind() != Obj.Meth) report_error("Method '" + factorWithActPars.getDesignator().obj.getName() + "' not found", factorWithActPars);
		else {
			currActPars = stackActPars.pop();
			List<Struct> paramsList = new ArrayList<>();
			for (Obj tmp : factorWithActPars.getDesignator().obj.getLocalSymbols()) {
				if (/*tmp.getFpPos() == 1 &&*/ tmp.getKind() == Obj.Var && tmp.getLevel() == 1) paramsList.add(tmp.getType());
			}
			report_info("currActPars: " + currActPars.size() , factorWithActPars);
			report_info("paramsList: " + paramsList.size() , factorWithActPars);
			if (paramsList.size() < currActPars.size()) report_error("(FactorWithActPars) Method '" + factorWithActPars.getDesignator().obj.getName() + "' has more arguments than expected", factorWithActPars);
			else if (paramsList.size() > currActPars.size()) report_error("(FactorWithActPars) Method '" + factorWithActPars.getDesignator().obj.getName() + "' has missing arguments", factorWithActPars);
			else {
				for (int i = 0; i < paramsList.size(); i++) {
					if (!currActPars.get(i).assignableTo(paramsList.get(i))) {
						report_error("(FactorWithActPars) Method '" + factorWithActPars.getDesignator().obj.getName() + "' arguments are incompatible", factorWithActPars);
						break;
					}
				}
				factorWithActPars.struct = factorWithActPars.getDesignator().obj.getType(); //PROSLO SVE PROVERE
			}
		}
	}
	
	@Override
	public void visit(FactorWithoutActPars factorWithoutActPars) {
		factorWithoutActPars.struct = Tab.noType;
		if (factorWithoutActPars.getDesignator().obj.getKind() != Obj.Meth) report_error("Method '" + factorWithoutActPars.getDesignator().obj.getName() + "' not found", factorWithoutActPars);
		else {
			List<Struct> paramsList = new ArrayList<>();
			for (Obj tmp : factorWithoutActPars.getDesignator().obj.getLocalSymbols()) {
				if (tmp.getFpPos() == 1 && tmp.getKind() == Obj.Var && tmp.getLevel() == 1) paramsList.add(tmp.getType());
			}
			if (paramsList.size() > 0) report_error("(DesStmFunc) Method '" + factorWithoutActPars.getDesignator().obj.getName() + "' is missing arguments", factorWithoutActPars);
			else factorWithoutActPars.struct = factorWithoutActPars.getDesignator().obj.getType(); //PROSLO SVE PROVERE
		}
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
		if (designatorArrName.getParent() instanceof DesigMoreDotArr || designatorArrName.getParent() instanceof DesigMoreDotArrList) return;
		designatorArrName.obj = Tab.find(designatorArrName.getI1());
//		report_info(designatorArrName.obj.getName(), designatorArrName);
		if (designatorArrName.obj == Tab.noObj) report_error("(DesignatorArrName) Array '" + designatorArrName.getI1() + "' not defined,", designatorArrName);
		else if (designatorArrName.obj.getType().getKind() != Obj.Var && designatorArrName.obj.getType().getKind() != Struct.Array) {
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
//		currRecord = null;
	}
	
	@Override
	public void visit(DesignatorArrWithMore designatorArrWithMore) {
		designatorArrWithMore.obj = designatorArrWithMore.getDesignatorMore().obj;
//		currRecord = null;
	}
	
	@Override
	public void visit(DesignatorWithMoreName designatorWithMoreName) {
		designatorWithMoreName.obj = Tab.find(designatorWithMoreName.getI1());
		currRecord = designatorWithMoreName.obj.getType();
		if (designatorWithMoreName.obj == Tab.noObj) report_error("(DesignatorWithMoreName) Record '" + designatorWithMoreName.getI1() + "' not defined,", designatorWithMoreName);
		else if (designatorWithMoreName.obj.getType().getKind() != Struct.Class && designatorWithMoreName.obj.getType().getKind() != Obj.Var) {
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
					if (tmp.getType().getKind() == Struct.Array) {
						if (tmp.getType().getElemType().getKind() == Struct.Class)
							currRecord = tmp.getType().getElemType();
					} 
					else if (tmp.getType().getKind() == Struct.Class) 
						currRecord = tmp.getType();
					found = true;
					break;
				}
			}
			if (!found) {
				desigMoreDot.obj = Tab.noObj;
				report_error("(DesigMoreDot) Variable '" + desigMoreDot.getI1() + "' not found in the record", desigMoreDot);
			}
		}
//		currRecord = null;
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
					desigMoreDotArr.getDesignatorArrName().obj = tmp;
					if (tmp.getType().getElemType().getKind() == Struct.Class) 
						currRecord = tmp.getType().getElemType(); // ????
					found = true;
					break;
				}
			}
			if (!found) {
				desigMoreDotArr.obj = Tab.noObj;
				report_error("(DesigMoreDot) Variable '" + desigMoreDotArr.getDesignatorArrName().getI1() + "' not found in the record", desigMoreDotArr);
			}
		}
//		currRecord = null;
	}
	
	@Override
	public void visit(DesigMoreDotList desigMoreDotList) {
		if (desigMoreDotList.getDesignatorMore().obj.getType() == Tab.noType) desigMoreDotList.obj = Tab.noObj;
		else {
			boolean found = false;
			for (Obj tmp : currRecord.getMembers()) {
				if (tmp.getName().equals(desigMoreDotList.getI2())) {
					if (tmp.getType().getKind() == Struct.Array) {
						if (tmp.getType().getElemType().getKind() == Struct.Class)
							currRecord = tmp.getType().getElemType();
					} 
					else if (tmp.getType().getKind() == Struct.Class) 
						currRecord = tmp.getType();
//					currRecord = (desigMoreDotList.obj = tmp).getType();
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
					desigMoreDotArrList.obj = new Obj(Obj.Elem, tmp.getName() + "[$]", tmp.getType().getElemType());
					desigMoreDotArrList.getDesignatorArrName().obj = tmp;
					if (tmp.getType().getElemType().getKind() == Struct.Class)
						currRecord = tmp.getType().getElemType();
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
	
	/* -------------------------------------------------------------------- VISIT_TERM ---------------------------------------------------------------------- */
	
	@Override
	public void visit(SingleTerm singleTerm) {
		singleTerm.struct = singleTerm.getFactorWrapper().struct;
	}
	
	@Override
	public void visit(MulTerms mulTerms) {
		mulTerms.struct = mulTerms.getTerm().struct;
		
		if (!mulTerms.getFactorWrapper().struct.equals(Tab.intType) || !mulTerms.getTerm().struct.equals(Tab.intType)) {
			mulTerms.struct = Tab.noType;
			report_error("(MulTerms) Multiplication of non-int values detected", mulTerms);
		}
	}
	
	/* -------------------------------------------------------------------- VISIT_EXPR ---------------------------------------------------------------------- */
	
	@Override
	public void visit(Expr expr) { //Expr ::= (Expr) Term ExprMore
		expr.struct = expr.getTerm().struct;
		if (expr.getExprMore() instanceof ThereIsMoreExpr && (!expr.getExprMore().struct.equals(Tab.intType) || !expr.getTerm().struct.equals(Tab.intType))) {
			expr.struct = Tab.noType;
			if (!expr.getExprMore().struct.equals(Tab.noType) && !expr.getTerm().struct.equals(Tab.noType))
				report_error("(Expr) Sum of non-int values detected", expr);
		}
	}
	
	@Override
	public void visit(ThereIsMoreExpr thereIsMoreExpr) { 
		thereIsMoreExpr.struct = thereIsMoreExpr.getTerm().struct;
		if (thereIsMoreExpr.getExprMore() instanceof ThereIsMoreExpr && (!thereIsMoreExpr.getExprMore().struct.equals(Tab.intType) || !thereIsMoreExpr.getTerm().struct.equals(Tab.intType))) {
			thereIsMoreExpr.struct = Tab.noType;
			if (!thereIsMoreExpr.getExprMore().struct.equals(Tab.noType) && !thereIsMoreExpr.getTerm().struct.equals(Tab.noType))
				report_error("(ThereIsMoreExpr) Sum of non-int values detected", thereIsMoreExpr);
		}
	}
	
	/* ------------------------------------------------------------------- VISIT_DESIG_STM --------------------------------------------------------------------- */
	
	@Override
	public void visit(AssignWrap assignWrap) {
		assignWrap.struct = assignWrap.getExpr().struct;
	}
	
	@Override
	public void visit(DesStmAssign desStmAssign) {
		if (desStmAssign.getDesignator().obj.getKind() != Obj.Var && desStmAssign.getDesignator().obj.getKind() != Obj.Elem && desStmAssign.getDesignator().obj.getKind() != Obj.Fld) 
			report_error("(DesStmAssign) Left hand variable is of wrong type", desStmAssign);
		else if (!desStmAssign.getAssignWrapper().struct.assignableTo(desStmAssign.getDesignator().obj.getType()))
			report_error("(DesStmAssign) Error with assignement to variable '" + desStmAssign.getDesignator().obj.getName() + "'", desStmAssign); 
	}
	
	@Override
	public void visit(ActParsHelp actParsHelp) {
		stackActPars.push(new ArrayList<>());
	}
	
	@Override
	public void visit(SingleActPar singleActPar) {
		stackActPars.peek().add(singleActPar.getExpr().struct);
	}
	
	@Override
	public void visit(MulActPars mulActPars) {
		stackActPars.peek().add(mulActPars.getExpr().struct);
	}
	
	@Override
	public void visit(DesStmFuncParams desStmFuncParams) {
		currActPars = stackActPars.pop();
		if (desStmFuncParams.getDesignator().obj.getKind() != Obj.Meth) report_error("(DesStmFuncParams) Method '" + desStmFuncParams.getDesignator().obj.getName() + "' not found", desStmFuncParams);
		else {
			List<Struct> paramsList = new ArrayList<>();
			for (Obj tmp : desStmFuncParams.getDesignator().obj.getLocalSymbols()) {
				if (tmp.getFpPos() == 1 && tmp.getKind() == Obj.Var && tmp.getLevel() == 1) paramsList.add(tmp.getType());
			}
			
			if (paramsList.size() < currActPars.size()) report_error("(DesStmFuncParams) Method '" + desStmFuncParams.getDesignator().obj.getName() + "' has more arguments than expected", desStmFuncParams);
			else if (paramsList.size() > currActPars.size()) report_error("(DesStmFuncParams) Method '" + desStmFuncParams.getDesignator().obj.getName() + "' has missing arguments", desStmFuncParams);
			else {
				for (int i = 0; i < paramsList.size(); i++) {
					if (!currActPars.get(i).assignableTo(paramsList.get(i))) {
						report_error("(DesStmFuncParams) Method '" + desStmFuncParams.getDesignator().obj.getName() + "' arguments are incompatible", desStmFuncParams);
						break;
					}
				}
			}
		}
	}
	
	@Override
	public void visit(DesStmFunc desStmFunc) {
		if (desStmFunc.getDesignator().obj.getKind() != Obj.Meth) report_error("(DesStmFunc) Method '" + desStmFunc.getDesignator().obj.getName() + "' not found", desStmFunc);
		else {
			List<Struct> paramsList = new ArrayList<>();
			for (Obj tmp : desStmFunc.getDesignator().obj.getLocalSymbols()) {
				if (tmp.getFpPos() == 1 && tmp.getKind() == Obj.Var && tmp.getLevel() == 1) paramsList.add(tmp.getType());
			}
			if (paramsList.size() > 0) report_error("(DesStmFunc) Method '" + desStmFunc.getDesignator().obj.getName() + "' is missing arguments", desStmFunc);
		}
	}
	
	@Override
	public void visit(DesStmInc desStmInc) {
		if ((desStmInc.getDesignator().obj.getKind() != Obj.Var && desStmInc.getDesignator().obj.getKind() != Obj.Elem && desStmInc.getDesignator().obj.getKind() != Obj.Fld) 
				|| !desStmInc.getDesignator().obj.getType().equals(Tab.intType)) 
			report_error("(DesStmInc) Left hand variable, '" + desStmInc.getDesignator().obj.getName() + "', of increment is of wrong type", desStmInc);
	}
	
	@Override
	public void visit(DesStmDec desStmDec) {
		if ((desStmDec.getDesignator().obj.getKind() != Obj.Var && desStmDec.getDesignator().obj.getKind() != Obj.Elem && desStmDec.getDesignator().obj.getKind() != Obj.Fld) 
				|| !desStmDec.getDesignator().obj.getType().equals(Tab.intType)) 
			report_error("(DesStmInc) Left hand variable, '" + desStmDec.getDesignator().obj.getName() + "', of decrement is of wrong type", desStmDec);
	}
	
	/* ----------------------------------------------------------------- VISIT_SING_STATEMENT ------------------------------------------------------------------- */
	
	@Override
	public void visit(DoWhileSingleStatement doWhileSingleStatement) {
		doWhileCnt--;
	}
	
	@Override
	public void visit(DoWhileHelp doWhileHelp) {
		doWhileCnt++;
	}
	
	@Override
	public void visit(BreakSingleStatement breakSingleStatement) {
		if (doWhileCnt  == 0) report_error("(BreakSingleStatement) Break was called outside of do-while", breakSingleStatement);
	}
	
	@Override
	public void visit(ContinueSingleStatement continueSingleStatement) {
		if (doWhileCnt  == 0) report_error("(ContinueSingleStatement) Continue was called outside of do-while", continueSingleStatement);
	}
	
	@Override
	public void visit(Label label) {
		if (!methodLabels.add(label.getI1())) report_error("Multiple label definitions for label '" + label.getI1() + "'", label);
	}
	
	@Override
	public void visit(GotoSingleStatement gotoSingleStatement) {
		methodCalledLabels.add(gotoSingleStatement.getI1());
	}
	
	@Override
	public void visit(ReadSingleStatement readSingleStatement) {
		if ((readSingleStatement.getDesignator().obj.getKind() != Obj.Var && readSingleStatement.getDesignator().obj.getKind() != Obj.Elem && readSingleStatement.getDesignator().obj.getKind() != Obj.Fld) 
				|| (!readSingleStatement.getDesignator().obj.getType().equals(Tab.intType)) && !readSingleStatement.getDesignator().obj.getType().equals(Tab.charType)
				&& !readSingleStatement.getDesignator().obj.getType().equals(boolType))
			report_error("(ReadSingleStatement) Read variable, '" + readSingleStatement.getDesignator().obj.getName() + "', is of wrong type", readSingleStatement);
	}
	
	@Override
	public void visit(PrintNumberSingleStatement printNumberSingleStatement) {
		if (!printNumberSingleStatement.getExpr().struct.equals(Tab.intType) && !printNumberSingleStatement.getExpr().struct.equals(Tab.charType)
				&& !printNumberSingleStatement.getExpr().struct.equals(boolType))
			report_error("(PrintNumberSingleStatement) Incorrect expr in print in method '" + currMethod.getName() + "'", printNumberSingleStatement);
	}
	
	@Override
	public void visit(PrintSingleStatement printSingleStatement) {
		if (!printSingleStatement.getExpr().struct.equals(Tab.intType) && !printSingleStatement.getExpr().struct.equals(Tab.charType)
				&& !printSingleStatement.getExpr().struct.equals(boolType))
			report_error("(PrintSingleStatement) Incorrect expr in print in method '" + currMethod.getName() + "'", printSingleStatement);
	}
	
	@Override
	public void visit(ReturnExprSingleStatement returnExprSingleStatement) {
		returnHappened = true;
		if (!currMethod.getType().equals(returnExprSingleStatement.getExpr().struct)) report_error("Wrong type in return for method '" + currMethod.getName() + "'", returnExprSingleStatement);
	}
	
	/* ----------------------------------------------------------------- VISIT_CONDITIONALS -------------------------------------------------------------------- */
	
	@Override
	public void visit(CondFactExpr condFactExpr) {
		condFactExpr.struct = condFactExpr.getExpr().struct;
		if (!condFactExpr.getExpr().struct.equals(boolType)) {
			condFactExpr.struct = Tab.noType;
			report_error("(CondFactExpr) Conditional factor is not boolean", condFactExpr);
		}
	}
	
	@Override
	public void visit(CondFactRelop condFactRelop) {
		condFactRelop.struct = Tab.noType;
		if (condFactRelop.getExpr().struct.compatibleWith(condFactRelop.getExpr1().struct)) {
			if ((condFactRelop.getExpr().struct.isRefType() || condFactRelop.getExpr1().struct.isRefType()) && 
					(!(condFactRelop.getRelop() instanceof Equals) && !(condFactRelop.getRelop() instanceof NotEqual)))
				report_error("Arrays or records in conditions can only be used with == or !=", condFactRelop);
			else
			condFactRelop.struct = boolType;
			
		}
		else report_error("(CondFactRelop) Incompatible expressions in conditional factor", condFactRelop);
	}
	
	@Override
	public void visit(SingleCondTerm singleCondTerm) {
		singleCondTerm.struct = singleCondTerm.getCondFact().struct;
	}
	
	@Override
	public void visit(MulCondTerm mulCondTerm) {
		if (mulCondTerm.getCondFact().struct == Tab.noType || mulCondTerm.getCondTerm().struct == Tab.noType) mulCondTerm.struct = Tab.noType;
		else mulCondTerm.struct = mulCondTerm.getCondFact().struct;
	}
	
	@Override
	public void visit(SingleCondition singleCondition) {
		singleCondition.struct = singleCondition.getCondTerm().struct;
		if (singleCondition.struct == Tab.noType) report_error("Error in condition, look above for details", singleCondition);
	}
	
	@Override
	public void visit(MultipleCondition multipleCondition) {
		if (multipleCondition.getCondTerm().struct == Tab.noType || multipleCondition.getCondition().struct == Tab.noType) multipleCondition.struct = Tab.noType;
		else multipleCondition.struct = multipleCondition.getCondTerm().struct;
		if (multipleCondition.struct == Tab.noType) report_error("Error in condition, look above for details", multipleCondition);
	}
	
	@Override
	public void visit(Type type) {
		Obj typeObj = Tab.find(type.getI1());
		if (typeObj == Tab.noObj) {
			report_error("Type '" + type.getI1() + "' is not defined", type);
			currentType = Tab.noType;
			type.struct = currentType;
			return;
		}
		
		if (typeObj.getKind() != Obj.Type) {
			report_error("Unallowed type '" + type.getI1() + "'", type);
			return;
		}
		
		currentType = typeObj.getType();
		type.struct = currentType;
	}
	
	public boolean passed() {
		return !errorDetected;
	}
	
}

