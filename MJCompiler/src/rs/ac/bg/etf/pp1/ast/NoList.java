// generated with ast extension for cup
// version 0.8
// 11/0/2022 21:11:49


package rs.ac.bg.etf.pp1.ast;

public class NoList extends List {

    public NoList () {
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
        buffer.append("NoList(\n");

        buffer.append(tab);
        buffer.append(") [NoList]");
        return buffer.toString();
    }
}
