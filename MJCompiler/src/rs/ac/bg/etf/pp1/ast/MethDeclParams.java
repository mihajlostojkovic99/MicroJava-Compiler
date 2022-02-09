// generated with ast extension for cup
// version 0.8
// 9/1/2022 16:43:48


package rs.ac.bg.etf.pp1.ast;

public class MethDeclParams extends MethodDecl {

    private MethodRet MethodRet;
    private MethodName MethodName;
    private FormPars FormPars;
    private ListVarDeclWrapper ListVarDeclWrapper;
    private StatementList StatementList;

    public MethDeclParams (MethodRet MethodRet, MethodName MethodName, FormPars FormPars, ListVarDeclWrapper ListVarDeclWrapper, StatementList StatementList) {
        this.MethodRet=MethodRet;
        if(MethodRet!=null) MethodRet.setParent(this);
        this.MethodName=MethodName;
        if(MethodName!=null) MethodName.setParent(this);
        this.FormPars=FormPars;
        if(FormPars!=null) FormPars.setParent(this);
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

    public FormPars getFormPars() {
        return FormPars;
    }

    public void setFormPars(FormPars FormPars) {
        this.FormPars=FormPars;
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
        if(FormPars!=null) FormPars.accept(visitor);
        if(ListVarDeclWrapper!=null) ListVarDeclWrapper.accept(visitor);
        if(StatementList!=null) StatementList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MethodRet!=null) MethodRet.traverseTopDown(visitor);
        if(MethodName!=null) MethodName.traverseTopDown(visitor);
        if(FormPars!=null) FormPars.traverseTopDown(visitor);
        if(ListVarDeclWrapper!=null) ListVarDeclWrapper.traverseTopDown(visitor);
        if(StatementList!=null) StatementList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MethodRet!=null) MethodRet.traverseBottomUp(visitor);
        if(MethodName!=null) MethodName.traverseBottomUp(visitor);
        if(FormPars!=null) FormPars.traverseBottomUp(visitor);
        if(ListVarDeclWrapper!=null) ListVarDeclWrapper.traverseBottomUp(visitor);
        if(StatementList!=null) StatementList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MethDeclParams(\n");

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

        if(FormPars!=null)
            buffer.append(FormPars.toString("  "+tab));
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
        buffer.append(") [MethDeclParams]");
        return buffer.toString();
    }
}
