// generated with ast extension for cup
// version 0.8
// 13/1/2022 14:36:14


package rs.ac.bg.etf.pp1.ast;

public class NoUnary extends Unary {

    public NoUnary () {
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
        buffer.append("NoUnary(\n");

        buffer.append(tab);
        buffer.append(") [NoUnary]");
        return buffer.toString();
    }
}
