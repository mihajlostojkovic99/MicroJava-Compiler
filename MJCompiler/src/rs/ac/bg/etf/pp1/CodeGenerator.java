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
	
	@Override
	public void visit(PrintSingleStatement printSingleStatement) {
		// print
		Code.loadConst(0);
		if (!printSingleStatement.getExpr().struct.equals(Tab.charType)) Code.put(Code.print);
		else Code.put(Code.bprint);
	}
	
	@Override
	public void visit(ThereIsMoreExpr thereIsMoreExpr) {
		// exit
		if (thereIsMoreExpr.getAddop() instanceof Plus) Code.put(Code.add);
		else Code.put(Code.sub);
	}
	
	@Override
	public void visit(MulTerms mulTerms) {
		// exit
		if (mulTerms.getMulop() instanceof Multiply) Code.put(Code.mul);
		else if (mulTerms.getMulop() instanceof Divide) Code.put(Code.div);
		else Code.put(Code.rem);
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
	public void visit(DesignatorArrName designatorArrName) {
		// load
		if (designatorArrName.getParent() instanceof DesignatorArr) Code.load(designatorArrName.obj);
	}
	
	@Override
	public void visit(DesStmAssign desStmAssign) {
		// store
		Code.store(desStmAssign.getDesignator().obj);
	}
	
	@Override
	public void visit(FactorWrapper factorWrapper) {
		// neg
		if (factorWrapper.getUnary() instanceof UnaryNegative) Code.put(Code.neg);
	}
	
	@Override
	public void visit(NewFactorWithPars newFactorWithPars) {
		// newarray
		Code.put(Code.newarray);
		if (newFactorWithPars.getType().struct.equals(Tab.charType)) Code.put(0);
		else Code.put(1);
	}
}
