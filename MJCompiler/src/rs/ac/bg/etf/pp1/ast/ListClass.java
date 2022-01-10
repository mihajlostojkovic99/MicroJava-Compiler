// generated with ast extension for cup
// version 0.8
// 10/0/2022 13:44:31


package rs.ac.bg.etf.pp1.ast;

public class ListClass extends List {

    private List List;
    private ClassDeclList ClassDeclList;

    public ListClass (List List, ClassDeclList ClassDeclList) {
        this.List=List;
        if(List!=null) List.setParent(this);
        this.ClassDeclList=ClassDeclList;
        if(ClassDeclList!=null) ClassDeclList.setParent(this);
    }

    public List getList() {
        return List;
    }

    public void setList(List List) {
        this.List=List;
    }

    public ClassDeclList getClassDeclList() {
        return ClassDeclList;
    }

    public void setClassDeclList(ClassDeclList ClassDeclList) {
        this.ClassDeclList=ClassDeclList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(List!=null) List.accept(visitor);
        if(ClassDeclList!=null) ClassDeclList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(List!=null) List.traverseTopDown(visitor);
        if(ClassDeclList!=null) ClassDeclList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(List!=null) List.traverseBottomUp(visitor);
        if(ClassDeclList!=null) ClassDeclList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ListClass(\n");

        if(List!=null)
            buffer.append(List.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ClassDeclList!=null)
            buffer.append(ClassDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ListClass]");
        return buffer.toString();
    }
}
