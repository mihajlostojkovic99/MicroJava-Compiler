package rs.ac.bg.etf.pp1;

import rs.ac.bg.etf.pp1.ast.VisitorAdaptor;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.HashSet;

import org.apache.log4j.Logger;

import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.mj.runtime.Code;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;

public class CodeGenerator extends VisitorAdaptor {

	private int mainPC;
	
	int getMainPc() {
		return mainPC;
	}
	
	@Override
	public void visit(MethodName methodName) {
		// enter b1, b2
		methodName.obj.setAdr(Code.pc);
		if (methodName.getI1().equalsIgnoreCase("main")) mainPC = Code.pc;
		
		Code.put(Code.enter);
		Code.put(methodName.obj.getLevel());
		Code.put(methodName.obj.getLocalSymbols().size());
	}
	
	@Override
	public void visit(MethDeclParams methDeclParams) {
		// exit
		Code.put(Code.exit);
		Code.put(Code.return_);
	}
	
	@Override
	public void visit(MethDeclNoParams methDeclNoParams) {
		// exit
		Code.put(Code.exit);
		Code.put(Code.return_);
	}
	
	/* ---------------------------------------------------------------------- VISIT_FACTOR ------------------------------------------------------------------------ */
	
	@Override
	public void visit(FactorWrapper factorWrapper) {
		// neg
		if (factorWrapper.getUnary() instanceof UnaryNegative) Code.put(Code.neg);
	}
	
	@Override
	public void visit(NormalFactor normalFactor) {
		// load
		Code.load(normalFactor.getDesignator().obj);
	}
	
	@Override
	public void visit(Num num) {
		// load
		Code.loadConst(num.getN1());
	}
	
	@Override
	public void visit(Char character) {
		// load
		Code.loadConst(character.getC1());
	}
	
	@Override
	public void visit(Bool bool) {
		// load
		Code.loadConst(bool.getB1());
	}
	
	@Override
	public void visit(NewFactor newFactor) {
		// new
		Code.put(Code.new_);
		Code.put2(newFactor.getType().struct.getNumberOfFields() * 4);
	}
	
	@Override
	public void visit(NewFactorWithPars newFactorWithPars) {
		// newarray
		Code.put(Code.newarray);
		if (newFactorWithPars.getType().struct.equals(Tab.charType)) Code.put(0);
		else Code.put(1);
	}
	
	/* -------------------------------------------------------------------- VISIT_DESIGNATOR ---------------------------------------------------------------------- */
	
	@Override
	public void visit(DesignatorArrName designatorArrName) {
		// load
//		if (designatorArrName.getParent() instanceof DesignatorArr) Code.load(designatorArrName.obj);
//		else if ((designatorArrName.getParent() instanceof DesigMoreDotArrList) || (designatorArrName.getParent() instanceof DesigMoreDotArr))
//			Code.load(designatorArrName.obj);
		Code.load(designatorArrName.obj);
	}
	
	@Override
	public void visit(DesignatorWithMoreName designatorWithMoreName) {
		// load
		Code.load(designatorWithMoreName.obj);
	}
	
	@Override
	public void visit(DesignatorMoreElem designatorMoreElem) {
		// load
		Code.load(designatorMoreElem.obj);
		
	}
	
	@Override
	public void visit(DesigMoreDot desigMoreDot) {
		// load
		if (desigMoreDot.getParent() instanceof DesigMoreDotList || desigMoreDot.getParent() instanceof DesigMoreDotArrList)
			Code.load(desigMoreDot.obj);
	}
	
	@Override
	public void visit(DesigMoreDotArr desigMoreDotArr) {
		// load
		if (desigMoreDotArr.getParent() instanceof DesigMoreDotList || desigMoreDotArr.getParent() instanceof DesigMoreDotArrList)
			Code.load(desigMoreDotArr.obj);
	}
	
	@Override
	public void visit(DesigMoreDotList desigMoreDotList) {
		// load
		if (desigMoreDotList.getParent() instanceof DesigMoreDotList || desigMoreDotList.getParent() instanceof DesigMoreDotArrList)
			Code.load(desigMoreDotList.obj);
	}
	
	@Override
	public void visit(DesigMoreDotArrList desigMoreDotArrList) {
		// load
		if (desigMoreDotArrList.getParent() instanceof DesigMoreDotList || desigMoreDotArrList.getParent() instanceof DesigMoreDotArrList)
			Code.load(desigMoreDotArrList.obj);
	}
	
	/* -------------------------------------------------------------------- VISIT_TERM ---------------------------------------------------------------------- */
	
	@Override
	public void visit(MulTerms mulTerms) {
		// exit
		if (mulTerms.getMulop() instanceof Multiply) Code.put(Code.mul);
		else if (mulTerms.getMulop() instanceof Divide) Code.put(Code.div);
		else Code.put(Code.rem);
	}
	
	/* -------------------------------------------------------------------- VISIT_EXPR ---------------------------------------------------------------------- */
	
	@Override
	public void visit(ThereIsMoreExpr thereIsMoreExpr) {
		// exit
		if (thereIsMoreExpr.getAddop() instanceof Plus) Code.put(Code.add);
		else Code.put(Code.sub);
	}
	
	/* ------------------------------------------------------------------- VISIT_DESIG_STM --------------------------------------------------------------------- */
	
	@Override
	public void visit(DesStmAssign desStmAssign) {
		// store
		Code.store(desStmAssign.getDesignator().obj);
	}
	
	@Override
	public void visit(DesStmInc desStmInc) {
		// inc
		if (desStmInc.getDesignator().obj.getKind() == Obj.Elem) Code.put(Code.dup2);
		Code.load(desStmInc.getDesignator().obj);
		Code.loadConst(1);
		Code.put(Code.add);
		Code.store(desStmInc.getDesignator().obj);
	}
	
	@Override
	public void visit(DesStmDec desStmDec) {
		// dec
		if (desStmDec.getDesignator().obj.getKind() == Obj.Elem) Code.put(Code.dup2);
		Code.load(desStmDec.getDesignator().obj);
		Code.loadConst(1);
		Code.put(Code.sub);
		Code.store(desStmDec.getDesignator().obj);
	}
	
	/* ----------------------------------------------------------------- VISIT_SING_STATEMENT ------------------------------------------------------------------- */
	
	@Override
	public void visit(ReturnSingleStatement returnSingleStatement) {
		// exit
		Code.put(Code.exit);
		Code.put(Code.return_);
	}
	
	@Override
	public void visit(ReadSingleStatement readSingleStatement) {
		// exit
		if (readSingleStatement.getDesignator().obj.getType().equals(Tab.charType)) Code.put(Code.bread);
		else Code.put(Code.read);
		
		Code.store(readSingleStatement.getDesignator().obj);
	}
	
	@Override
	public void visit(PrintSingleStatement printSingleStatement) {
		// print
		Code.loadConst(0);
		if (!printSingleStatement.getExpr().struct.equals(Tab.charType)) Code.put(Code.print);
		else Code.put(Code.bprint);
	}
	
	@Override
	public void visit(PrintNumberSingleStatement printNumberSingleStatement) {
		// print
		Code.loadConst(printNumberSingleStatement.getN2());
		if (!printNumberSingleStatement.getExpr().struct.equals(Tab.charType)) Code.put(Code.print);
		else Code.put(Code.bprint);
	}
	
	/* ----------------------------------------------------------------- VISIT_CONDITIONALS -------------------------------------------------------------------- */
	
}
