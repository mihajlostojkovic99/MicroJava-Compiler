// generated with ast extension for cup
// version 0.8
// 10/0/2022 23:59:26


package rs.ac.bg.etf.pp1.ast;

public class RecordDecl implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private String I1;
    private ListVarDeclWrapper ListVarDeclWrapper;

    public RecordDecl (String I1, ListVarDeclWrapper ListVarDeclWrapper) {
        this.I1=I1;
        this.ListVarDeclWrapper=ListVarDeclWrapper;
        if(ListVarDeclWrapper!=null) ListVarDeclWrapper.setParent(this);
    }

    public String getI1() {
        return I1;
    }

    public void setI1(String I1) {
        this.I1=I1;
    }

    public ListVarDeclWrapper getListVarDeclWrapper() {
        return ListVarDeclWrapper;
    }

    public void setListVarDeclWrapper(ListVarDeclWrapper ListVarDeclWrapper) {
        this.ListVarDeclWrapper=ListVarDeclWrapper;
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
        if(ListVarDeclWrapper!=null) ListVarDeclWrapper.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ListVarDeclWrapper!=null) ListVarDeclWrapper.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ListVarDeclWrapper!=null) ListVarDeclWrapper.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("RecordDecl(\n");

        buffer.append(" "+tab+I1);
        buffer.append("\n");

        if(ListVarDeclWrapper!=null)
            buffer.append(ListVarDeclWrapper.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [RecordDecl]");
        return buffer.toString();
    }
}
