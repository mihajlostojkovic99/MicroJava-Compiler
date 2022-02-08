// generated with ast extension for cup
// version 0.8
// 9/1/2022 0:29:24


package rs.ac.bg.etf.pp1.ast;

public interface Visitor { 

    public void visit(Mulop Mulop);
    public void visit(MethodDecl MethodDecl);
    public void visit(RecordDeclList RecordDeclList);
    public void visit(Relop Relop);
    public void visit(Unary Unary);
    public void visit(StatementList StatementList);
    public void visit(Addop Addop);
    public void visit(ConstDeclWrapper ConstDeclWrapper);
    public void visit(List List);
    public void visit(ListVarDeclWrapper ListVarDeclWrapper);
    public void visit(Factor Factor);
    public void visit(CondTerm CondTerm);
    public void visit(AssignWrapper AssignWrapper);
    public void visit(Designator Designator);
    public void visit(Term Term);
    public void visit(Condition Condition);
    public void visit(ConstDeclList ConstDeclList);
    public void visit(MethodRet MethodRet);
    public void visit(VarDeclList VarDeclList);
    public void visit(ActPars ActPars);
    public void visit(DesignatorStatement DesignatorStatement);
    public void visit(ExprMore ExprMore);
    public void visit(Statement Statement);
    public void visit(VarDecl VarDecl);
    public void visit(ConstDecl ConstDecl);
    public void visit(CondFact CondFact);
    public void visit(FormPar FormPar);
    public void visit(MethodDeclList MethodDeclList);
    public void visit(DesignatorMore DesignatorMore);
    public void visit(SingleStatement SingleStatement);
    public void visit(FormPars FormPars);
    public void visit(LessOrEqual LessOrEqual);
    public void visit(LessThan LessThan);
    public void visit(GreaterOrEqual GreaterOrEqual);
    public void visit(GreaterThan GreaterThan);
    public void visit(NotEqual NotEqual);
    public void visit(Equals Equals);
    public void visit(FactorWithExpr FactorWithExpr);
    public void visit(NewFactorWithPars NewFactorWithPars);
    public void visit(NewFactor NewFactor);
    public void visit(Bool Bool);
    public void visit(Char Char);
    public void visit(Num Num);
    public void visit(FactorWithoutActPars FactorWithoutActPars);
    public void visit(FactorWithActPars FactorWithActPars);
    public void visit(NormalFactor NormalFactor);
    public void visit(NoUnary NoUnary);
    public void visit(UnaryNegative UnaryNegative);
    public void visit(FactorWrapper FactorWrapper);
    public void visit(Mod Mod);
    public void visit(Divide Divide);
    public void visit(Multiply Multiply);
    public void visit(CondFactRelop CondFactRelop);
    public void visit(CondFactExpr CondFactExpr);
    public void visit(SingleTerm SingleTerm);
    public void visit(MulTerms MulTerms);
    public void visit(SingleCondTerm SingleCondTerm);
    public void visit(MulCondTerm MulCondTerm);
    public void visit(SingleActPar SingleActPar);
    public void visit(MulActPars MulActPars);
    public void visit(AssignWrapperError AssignWrapperError);
    public void visit(AssignWrap AssignWrap);
    public void visit(Assignop Assignop);
    public void visit(DesigMoreDotArrList DesigMoreDotArrList);
    public void visit(DesigMoreDotList DesigMoreDotList);
    public void visit(DesigMoreDotArr DesigMoreDotArr);
    public void visit(DesigMoreDot DesigMoreDot);
    public void visit(DesignatorMoreElem DesignatorMoreElem);
    public void visit(DesignatorWithMoreName DesignatorWithMoreName);
    public void visit(DesignatorArrName DesignatorArrName);
    public void visit(DesignatorArrWithMore DesignatorArrWithMore);
    public void visit(DesignatorWithMore DesignatorWithMore);
    public void visit(DesignatorArr DesignatorArr);
    public void visit(DesignatorSimple DesignatorSimple);
    public void visit(Minus Minus);
    public void visit(Plus Plus);
    public void visit(Expr Expr);
    public void visit(NoMoreExpr NoMoreExpr);
    public void visit(ThereIsMoreExpr ThereIsMoreExpr);
    public void visit(ConditionError ConditionError);
    public void visit(SingleCondition SingleCondition);
    public void visit(MultipleCondition MultipleCondition);
    public void visit(DesStmDec DesStmDec);
    public void visit(DesStmInc DesStmInc);
    public void visit(DesStmFunc DesStmFunc);
    public void visit(DesStmFuncParams DesStmFuncParams);
    public void visit(DesStmAssign DesStmAssign);
    public void visit(Statements Statements);
    public void visit(GotoSingleStatement GotoSingleStatement);
    public void visit(PrintSingleStatement PrintSingleStatement);
    public void visit(PrintNumberSingleStatement PrintNumberSingleStatement);
    public void visit(ReadSingleStatement ReadSingleStatement);
    public void visit(ReturnSingleStatement ReturnSingleStatement);
    public void visit(ReturnExprSingleStatement ReturnExprSingleStatement);
    public void visit(ContinueSingleStatement ContinueSingleStatement);
    public void visit(BreakSingleStatement BreakSingleStatement);
    public void visit(DoWhileSingleStatement DoWhileSingleStatement);
    public void visit(IfSingleStatement IfSingleStatement);
    public void visit(IfElseSingleStatement IfElseSingleStatement);
    public void visit(DesignatorSingleStatement DesignatorSingleStatement);
    public void visit(Label Label);
    public void visit(StatementWithStatements StatementWithStatements);
    public void visit(StatementWithSingleStatement StatementWithSingleStatement);
    public void visit(StatementWithLabel StatementWithLabel);
    public void visit(NoStatementList NoStatementList);
    public void visit(StatementListExists StatementListExists);
    public void visit(FormalParameterError FormalParameterError);
    public void visit(FormalParameterArray FormalParameterArray);
    public void visit(FormalParameter FormalParameter);
    public void visit(SingleFormPars SingleFormPars);
    public void visit(FormParameters FormParameters);
    public void visit(RecordDeclName RecordDeclName);
    public void visit(RecordDecl RecordDecl);
    public void visit(Type Type);
    public void visit(MethodRetType MethodRetType);
    public void visit(MethodRetVoid MethodRetVoid);
    public void visit(MethodName MethodName);
    public void visit(MethDeclNoParams MethDeclNoParams);
    public void visit(MethDeclParams MethDeclParams);
    public void visit(ArrayVarDecl ArrayVarDecl);
    public void visit(NormalVarDecl NormalVarDecl);
    public void visit(SingleVarDecl SingleVarDecl);
    public void visit(VarDeclarations VarDeclarations);
    public void visit(NoListVarDeclWrapper NoListVarDeclWrapper);
    public void visit(IsListVarDeclWrapper IsListVarDeclWrapper);
    public void visit(VarDeclWrapper VarDeclWrapper);
    public void visit(ConstDeclError ConstDeclError);
    public void visit(ConstDeclChar ConstDeclChar);
    public void visit(ConstDeclBool ConstDeclBool);
    public void visit(ConstDeclNumber ConstDeclNumber);
    public void visit(SingleConstDeclaration SingleConstDeclaration);
    public void visit(ConstDeclarations ConstDeclarations);
    public void visit(ConstDeclWrapperError ConstDeclWrapperError);
    public void visit(ConstDeclWrapperClass ConstDeclWrapperClass);
    public void visit(NoMethodDecl NoMethodDecl);
    public void visit(MethodDeclarations MethodDeclarations);
    public void visit(NoList NoList);
    public void visit(ListRecord ListRecord);
    public void visit(ListVar ListVar);
    public void visit(ListConst ListConst);
    public void visit(ProgramName ProgramName);
    public void visit(Program Program);

}
