// generated with ast extension for cup
// version 0.8
// 5/1/2022 1:28:11


package rs.ac.bg.etf.pp1.ast;

public class ListVar extends List {

    private List List;
    private VarDeclWrapper VarDeclWrapper;

    public ListVar (List List, VarDeclWrapper VarDeclWrapper) {
        this.List=List;
        if(List!=null) List.setParent(this);
        this.VarDeclWrapper=VarDeclWrapper;
        if(VarDeclWrapper!=null) VarDeclWrapper.setParent(this);
    }

    public List getList() {
        return List;
    }

    public void setList(List List) {
        this.List=List;
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
        if(List!=null) List.accept(visitor);
        if(VarDeclWrapper!=null) VarDeclWrapper.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(List!=null) List.traverseTopDown(visitor);
        if(VarDeclWrapper!=null) VarDeclWrapper.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(List!=null) List.traverseBottomUp(visitor);
        if(VarDeclWrapper!=null) VarDeclWrapper.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ListVar(\n");

        if(List!=null)
            buffer.append(List.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarDeclWrapper!=null)
            buffer.append(VarDeclWrapper.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ListVar]");
        return buffer.toString();
    }
}
