// generated with ast extension for cup
// version 0.8
// 7/1/2022 13:17:23


package rs.ac.bg.etf.pp1.ast;

public class LessThan extends Relop {

    public LessThan () {
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
        buffer.append("LessThan(\n");

        buffer.append(tab);
        buffer.append(") [LessThan]");
        return buffer.toString();
    }
}
