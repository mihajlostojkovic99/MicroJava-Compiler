// generated with ast extension for cup
// version 0.8
// 9/1/2022 16:26:18


package rs.ac.bg.etf.pp1.ast;

public class DoWhileHelp implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    public DoWhileHelp () {
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
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DoWhileHelp(\n");

        buffer.append(tab);
        buffer.append(") [DoWhileHelp]");
        return buffer.toString();
    }
}