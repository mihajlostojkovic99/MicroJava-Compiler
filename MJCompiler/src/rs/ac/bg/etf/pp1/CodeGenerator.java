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
	public void visit(MethodRetVoid methodRetVoid) {
		// enter b1, b2
		Code.put(Code.enter);
		Code.put(methodRetVoid.obj.getLevel());
		Code.put(methodRetVoid.obj.getLocalSymbols().size());
	}
}
