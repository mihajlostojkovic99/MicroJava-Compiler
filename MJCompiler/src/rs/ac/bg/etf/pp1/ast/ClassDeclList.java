// generated with ast extension for cup
// version 0.8
// 10/0/2022 23:59:26


package rs.ac.bg.etf.pp1.ast;

public class ClassDeclList implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private ClassDeclList ClassDeclList;
    private ClassDecl ClassDecl;

    public ClassDeclList (ClassDeclList ClassDeclList, ClassDecl ClassDecl) {
        this.ClassDeclList=ClassDeclList;
        if(ClassDeclList!=null) ClassDeclList.setParent(this);
        this.ClassDecl=ClassDecl;
        if(ClassDecl!=null) ClassDecl.setParent(this);
    }

    public ClassDeclList getClassDeclList() {
        return ClassDeclList;
    }

    public void setClassDeclList(ClassDeclList ClassDeclList) {
        this.ClassDeclList=ClassDeclList;
    }

    public ClassDecl getClassDecl() {
        return ClassDecl;
    }

    public void setClassDecl(ClassDecl ClassDecl) {
        this.ClassDecl=ClassDecl;
    }

    public SyntaxNode getParent() {
        return parent;
    }

    public void setParent(SyntaxNode parent) {
        this.parent=parent;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line=line;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ClassDeclList!=null) ClassDeclList.accept(visitor);
        if(ClassDecl!=null) ClassDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ClassDeclList!=null) ClassDeclList.traverseTopDown(visitor);
        if(ClassDecl!=null) ClassDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ClassDeclList!=null) ClassDeclList.traverseBottomUp(visitor);
        if(ClassDecl!=null) ClassDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ClassDeclList(\n");

        if(ClassDeclList!=null)
            buffer.append(ClassDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ClassDecl!=null)
            buffer.append(ClassDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ClassDeclList]");
        return buffer.toString();
    }
}
