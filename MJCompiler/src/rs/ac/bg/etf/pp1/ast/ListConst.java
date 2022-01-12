// generated with ast extension for cup
// version 0.8
// 12/0/2022 18:41:45


package rs.ac.bg.etf.pp1.ast;

public class ListConst extends List {

    private List List;
    private ConstDeclWrapper ConstDeclWrapper;

    public ListConst (List List, ConstDeclWrapper ConstDeclWrapper) {
        this.List=List;
        if(List!=null) List.setParent(this);
        this.ConstDeclWrapper=ConstDeclWrapper;
        if(ConstDeclWrapper!=null) ConstDeclWrapper.setParent(this);
    }

    public List getList() {
        return List;
    }

    public void setList(List List) {
        this.List=List;
    }

    public ConstDeclWrapper getConstDeclWrapper() {
        return ConstDeclWrapper;
    }

    public void setConstDeclWrapper(ConstDeclWrapper ConstDeclWrapper) {
        this.ConstDeclWrapper=ConstDeclWrapper;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(List!=null) List.accept(visitor);
        if(ConstDeclWrapper!=null) ConstDeclWrapper.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(List!=null) List.traverseTopDown(visitor);
        if(ConstDeclWrapper!=null) ConstDeclWrapper.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(List!=null) List.traverseBottomUp(visitor);
        if(ConstDeclWrapper!=null) ConstDeclWrapper.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ListConst(\n");

        if(List!=null)
            buffer.append(List.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ConstDeclWrapper!=null)
            buffer.append(ConstDeclWrapper.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ListConst]");
        return buffer.toString();
    }
}
