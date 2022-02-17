package rs.ac.bg.etf.pp1;

import rs.ac.bg.etf.pp1.ast.VisitorAdaptor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.HashSet;

import org.apache.log4j.Logger;

import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.mj.runtime.Code;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;

public class CodeGenerator extends VisitorAdaptor {

	public CodeGenerator() {
		
		/********** len **********/
		Obj obj = Tab.find("len");
		obj.setAdr(Code.pc);
		Code.put(Code.enter);
		Code.put(obj.getLevel());
		Code.put(obj.getLocalSymbols().size());
		Code.put(Code.load_n);
		Code.put(Code.arraylength);
		Code.put(Code.exit);
		Code.put(Code.return_);
		
		/********** chr **********/
		obj = Tab.find("chr");
		obj.setAdr(Code.pc);
		Code.put(Code.enter);
		Code.put(obj.getLevel());
		Code.put(obj.getLocalSymbols().size());
		Code.put(Code.load_n);
		Code.put(Code.exit);
		Code.put(Code.return_);
		
		/********** ord **********/
		obj = Tab.find("ord");
		obj.setAdr(Code.pc);
		Code.put(Code.enter);
		Code.put(obj.getLevel());
		Code.put(obj.getLocalSymbols().size());
		Code.put(Code.load_n);
		Code.put(Code.exit);
		Code.put(Code.return_);
	}
	
	private int mainPC;
	
	private Map<String, Integer> labelAdrs = new HashMap<>();
	private Map<String, List<Integer>> patchAdrs = new HashMap<>();
	private List<Integer> skipCondFact = new ArrayList<>();
	private List<Integer> skipCondition = new ArrayList<>();
	private Stack<Integer> skipThen = new Stack<>();
	private Stack<Integer> skipElse = new Stack<>();
	private Stack<Integer> doWhileStart = new Stack<>();

	private Stack<Integer> breakLevelStack = new Stack<>();
	private Stack<Integer> breakAdrStack = new Stack<>();
	
	private Stack<Integer> continueLevelStack = new Stack<>();
	private Stack<Integer> continueAdrStack = new Stack<>();
	
	private int doWhileLevel = 0;
	
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
	public void visit(FactorWithActPars factorWithActPars) {
		// call
		int adr = factorWithActPars.getDesignator().obj.getAdr() - Code.pc;
		Code.put(Code.call);
		Code.put2(adr);
	}
	
	@Override
	public void visit(FactorWithoutActPars factorWithoutActPars) {
		// call
		int adr = factorWithoutActPars.getDesignator().obj.getAdr() - Code.pc;
		Code.put(Code.call);
		Code.put2(adr);
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
	public void visit(DesStmFuncParams desStmFuncParams) {
		// call
		int adr = desStmFuncParams.getDesignator().obj.getAdr() - Code.pc;
		Code.put(Code.call);
		Code.put2(adr);
		if (!desStmFuncParams.getDesignator().obj.getType().equals(Tab.noType)) Code.put(Code.pop);
		
	}
	
	@Override
	public void visit(DesStmFunc desStmFunc) {
		// call
		int adr = desStmFunc.getDesignator().obj.getAdr() - Code.pc;
		Code.put(Code.call);
		Code.put2(adr);
		if (!desStmFunc.getDesignator().obj.getType().equals(Tab.noType)) Code.put(Code.pop);
	}
	
	@Override
	public void visit(DesStmInc desStmInc) {
		// inc
		if (desStmInc.getDesignator().obj.getKind() == Obj.Elem) Code.put(Code.dup2);
		if (desStmInc.getDesignator().obj.getKind() == Obj.Fld) Code.put(Code.dup);
		Code.load(desStmInc.getDesignator().obj);
		Code.loadConst(1);
		Code.put(Code.add);
		Code.store(desStmInc.getDesignator().obj);
	}
	
	@Override
	public void visit(DesStmDec desStmDec) {
		// dec
		if (desStmDec.getDesignator().obj.getKind() == Obj.Elem) Code.put(Code.dup2);
		if (desStmDec.getDesignator().obj.getKind() == Obj.Fld) Code.put(Code.dup);
		Code.load(desStmDec.getDesignator().obj);
		Code.loadConst(1);
		Code.put(Code.sub);
		Code.store(desStmDec.getDesignator().obj);
	}
	
	/* ----------------------------------------------------------------- VISIT_SING_STATEMENT ------------------------------------------------------------------- */
	
	@Override
	public void visit(IfSingleStatement ifSingleStatement) {
		// 
		Code.fixup(skipThen.pop());
	}
	
	@Override
	public void visit(IfElseSingleStatement ifElseSingleStatement) {
		// 
		Code.fixup(skipElse.pop());
	}
	
	@Override
	public void visit(ElseHelp elseHelp) {
		//push
		Code.putJump(0);
		skipElse.push(Code.pc - 2);
		
		Code.fixup(skipThen.pop());
	}
	
	@Override
	public void visit(DoWhileHelp doWhileHelp) {
		//push 
		doWhileStart.push(Code.pc);
		doWhileLevel++;
	}
	
	@Override
	public void visit(DoWhileSingleStatement doWhileSingleStatement) {
		//dowhile
		Code.putJump(doWhileStart.pop());
		while (!breakLevelStack.empty() /*&& !continueAdrStack.empty()*/ && breakLevelStack.peek() == doWhileLevel) {
			breakLevelStack.pop();
			Code.fixup(breakAdrStack.pop());
		}
		Code.fixup(skipThen.pop());
		doWhileLevel--;
	}
	
	@Override
	public void visit(ContinueSingleStatement continueSingleStatement) {
		//continue
		Code.putJump(0);
		continueAdrStack.push(Code.pc - 2);
		continueLevelStack.push(doWhileLevel);
	}
	
	@Override
	public void visit(CondHelp condHelp) {
		//pop
		while (!continueLevelStack.empty() /*&& !continueAdrStack.empty()*/ && continueLevelStack.peek() == doWhileLevel) {
			continueLevelStack.pop();
			Code.fixup(continueAdrStack.pop());
		}
	}
	
	@Override
	public void visit(BreakSingleStatement breakSingleStatement) {
		// break
		Code.putJump(0);
		breakAdrStack.push(Code.pc - 2);
		breakLevelStack.push(doWhileLevel);
	}
	
	@Override
	public void visit(ReturnSingleStatement returnSingleStatement) {
		// exit
		Code.put(Code.exit);
		Code.put(Code.return_);
	}
	
	@Override
	public void visit(ReturnExprSingleStatement returnExprSingleStatement) {
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
	
	@Override
	public void visit(Label label) {
		// label
		if (label.getParent() instanceof StatementWithLabel) {
			labelAdrs.put(label.getI1(), Code.pc);
			if (patchAdrs.containsKey(label.getI1())) {
				for (int i : patchAdrs.get(label.getI1())) {
					Code.fixup(i);
				}
				patchAdrs.get(label.getI1()).clear();
			}
		}
	}
	
	@Override
	public void visit(GotoSingleStatement gotoSingleStatement) {
		// jmp
		if (labelAdrs.containsKey(gotoSingleStatement.getI1())) Code.putJump(labelAdrs.get(gotoSingleStatement.getI1()));
		else {
			Code.putJump(0);
			
			int patchAdr = Code.pc - 2;
			
			if (!patchAdrs.containsKey(gotoSingleStatement.getI1())) {
				List<Integer> tmp = new ArrayList<>();
				tmp.add(patchAdr);
				patchAdrs.put(gotoSingleStatement.getI1(), tmp);
			}
			else patchAdrs.get(gotoSingleStatement.getI1()).add(patchAdr);
		}
	}
	
	/* ----------------------------------------------------------------- VISIT_CONDITIONALS -------------------------------------------------------------------- */
	
	@Override
	public void visit(CondFactExpr condFactExpr) {
		// 
		Code.loadConst(0);
		Code.putFalseJump(Code.ne, 0);
		skipCondFact.add(Code.pc - 2);
	}
	
	@Override
	public void visit(CondFactRelop condFactRelop) {
		// 
		switch (condFactRelop.getRelop().getClass().getSimpleName()) { //CODE SMELL :(
		case "Equals":
			Code.putFalseJump(Code.eq, 0);
			break;
		case "NotEqual":
			Code.putFalseJump(Code.ne, 0);
			break;
		case "GreaterThan":
			Code.putFalseJump(Code.gt, 0);
			break;
		case "GreaterOrEqual":
			Code.putFalseJump(Code.ge, 0);
			break;
		case "LessThan":
			Code.putFalseJump(Code.lt, 0);
			break;
		case "LessOrEqual":
			Code.putFalseJump(Code.le, 0);
			break;			
		default:
			break;
		}
		skipCondFact.add(Code.pc - 2);
	}
	
	@Override
	public void visit(SingleCondTerm singleCondTerm) {
		// 
		if (singleCondTerm.getParent() instanceof MulCondTerm) return;
		Code.putJump(0);
		skipCondition.add(Code.pc - 2);
		while (!skipCondFact.isEmpty()) {
			Code.fixup(skipCondFact.remove(0));
		}
	}
	
	@Override
	public void visit(MulCondTerm mulCondTerm) {
		// 
		if (mulCondTerm.getParent() instanceof MulCondTerm) return;
		Code.putJump(0);
		skipCondition.add(Code.pc - 2);
		while (!skipCondFact.isEmpty()) {
			Code.fixup(skipCondFact.remove(0));
		}
	}
	
	@Override
	public void visit(SingleCondition singleCondition) {
		// 
		if (singleCondition.getParent() instanceof MultipleCondition) return;
		Code.putJump(0);
		skipThen.push(Code.pc - 2);
		
		while (!skipCondition.isEmpty()) {
			Code.fixup(skipCondition.remove(0));
		}
	}
	
	@Override
	public void visit(MultipleCondition multipleCondition) {
		// 
		if (multipleCondition.getParent() instanceof MultipleCondition) return;
		Code.putJump(0);
		skipThen.push(Code.pc - 2);
		
		while (!skipCondition.isEmpty()) {
			Code.fixup(skipCondition.remove(0));
		}
	}
	
	
	
}
