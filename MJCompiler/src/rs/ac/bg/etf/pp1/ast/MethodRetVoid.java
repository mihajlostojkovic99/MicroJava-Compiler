// generated with ast extension for cup
// version 0.8
// 13/1/2022 14:36:14


package rs.ac.bg.etf.pp1.ast;

public class MethodRetVoid extends MethodRet {

    public MethodRetVoid () {
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
        buffer.append("MethodRetVoid(\n");

        buffer.append(tab);
        buffer.append(") [MethodRetVoid]");
        return buffer.toString();
    }
}
