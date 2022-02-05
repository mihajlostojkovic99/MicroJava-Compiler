// generated with ast extension for cup
// version 0.8
// 5/1/2022 1:28:11


package rs.ac.bg.etf.pp1.ast;

public class IsListVarDeclWrapper extends ListVarDeclWrapper {

    private ListVarDeclWrapper ListVarDeclWrapper;
    private VarDeclWrapper VarDeclWrapper;

    public IsListVarDeclWrapper (ListVarDeclWrapper ListVarDeclWrapper, VarDeclWrapper VarDeclWrapper) {
        this.ListVarDeclWrapper=ListVarDeclWrapper;
        if(ListVarDeclWrapper!=null) ListVarDeclWrapper.setParent(this);
        this.VarDeclWrapper=VarDeclWrapper;
        if(VarDeclWrapper!=null) VarDeclWrapper.setParent(this);
    }

    public ListVarDeclWrapper getListVarDeclWrapper() {
        return ListVarDeclWrapper;
    }

    public void setListVarDeclWrapper(ListVarDeclWrapper ListVarDeclWrapper) {
        this.ListVarDeclWrapper=ListVarDeclWrapper;
    }

    public VarDeclWrapper getVarDeclWrapper() {
        return VarDeclWrapper;
    }

    public void setVarDeclWrapper(VarDeclWrapper VarDeclWrapper) {
        this.VarDeclWrapper=VarDeclWrapper;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ListVarDeclWrapper!=null) ListVarDeclWrapper.accept(visitor);
        if(VarDeclWrapper!=null) VarDeclWrapper.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ListVarDeclWrapper!=null) ListVarDeclWrapper.traverseTopDown(visitor);
        if(VarDeclWrapper!=null) VarDeclWrapper.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ListVarDeclWrapper!=null) ListVarDeclWrapper.traverseBottomUp(visitor);
        if(VarDeclWrapper!=null) VarDeclWrapper.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("IsListVarDeclWrapper(\n");

        if(ListVarDeclWrapper!=null)
            buffer.append(ListVarDeclWrapper.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarDeclWrapper!=null)
            buffer.append(VarDeclWrapper.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [IsListVarDeclWrapper]");
        return buffer.toString();
    }
}
