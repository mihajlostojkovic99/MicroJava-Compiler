// generated with ast extension for cup
// version 0.8
// 17/1/2022 0:5:19


package rs.ac.bg.etf.pp1.ast;

public class MethDeclNoParams extends MethodDecl {

    private MethodRet MethodRet;
    private MethodName MethodName;
    private ListVarDeclWrapper ListVarDeclWrapper;
    private StatementList StatementList;

    public MethDeclNoParams (MethodRet MethodRet, MethodName MethodName, ListVarDeclWrapper ListVarDeclWrapper, StatementList StatementList) {
        this.MethodRet=MethodRet;
        if(MethodRet!=null) MethodRet.setParent(this);
        this.MethodName=MethodName;
        if(MethodName!=null) MethodName.setParent(this);
        this.ListVarDeclWrapper=ListVarDeclWrapper;
        if(ListVarDeclWrapper!=null) ListVarDeclWrapper.setParent(this);
        this.StatementList=StatementList;
        if(StatementList!=null) StatementList.setParent(this);
    }

    public MethodRet getMethodRet() {
        return MethodRet;
    }

    public void setMethodRet(MethodRet MethodRet) {
        this.MethodRet=MethodRet;
    }

    public MethodName getMethodName() {
        return MethodName;
    }

    public void setMethodName(MethodName MethodName) {
        this.MethodName=MethodName;
    }

    public ListVarDeclWrapper getListVarDeclWrapper() {
        return ListVarDeclWrapper;
    }

    public void setListVarDeclWrapper(ListVarDeclWrapper ListVarDeclWrapper) {
        this.ListVarDeclWrapper=ListVarDeclWrapper;
    }

    public StatementList getStatementList() {
        return StatementList;
    }

    public void setStatementList(StatementList StatementList) {
        this.StatementList=StatementList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(MethodRet!=null) MethodRet.accept(visitor);
        if(MethodName!=null) MethodName.accept(visitor);
        if(ListVarDeclWrapper!=null) ListVarDeclWrapper.accept(visitor);
        if(StatementList!=null) StatementList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MethodRet!=null) MethodRet.traverseTopDown(visitor);
        if(MethodName!=null) MethodName.traverseTopDown(visitor);
        if(ListVarDeclWrapper!=null) ListVarDeclWrapper.traverseTopDown(visitor);
        if(StatementList!=null) StatementList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MethodRet!=null) MethodRet.traverseBottomUp(visitor);
        if(MethodName!=null) MethodName.traverseBottomUp(visitor);
        if(ListVarDeclWrapper!=null) ListVarDeclWrapper.traverseBottomUp(visitor);
        if(StatementList!=null) StatementList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MethDeclNoParams(\n");

        if(MethodRet!=null)
            buffer.append(MethodRet.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MethodName!=null)
            buffer.append(MethodName.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ListVarDeclWrapper!=null)
            buffer.append(ListVarDeclWrapper.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(StatementList!=null)
            buffer.append(StatementList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MethDeclNoParams]");
        return buffer.toString();
    }
}
