// generated with ast extension for cup
// version 0.8
// 10/0/2022 14:42:42


package rs.ac.bg.etf.pp1.ast;

public class LessOrEqual extends Relop {

    public LessOrEqual () {
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
        buffer.append("LessOrEqual(\n");

        buffer.append(tab);
        buffer.append(") [LessOrEqual]");
        return buffer.toString();
    }
}