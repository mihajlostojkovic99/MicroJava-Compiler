// generated with ast extension for cup
// version 0.8
// 10/0/2022 23:59:26


package rs.ac.bg.etf.pp1.ast;

public class ConstDeclBool extends ConstDecl {

    private String I1;
    private String B2;

    public ConstDeclBool (String I1, String B2) {
        this.I1=I1;
        this.B2=B2;
    }

    public String getI1() {
        return I1;
    }

    public void setI1(String I1) {
        this.I1=I1;
    }

    public String getB2() {
        return B2;
    }

    public void setB2(String B2) {
        this.B2=B2;
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
        buffer.append("ConstDeclBool(\n");

        buffer.append(" "+tab+I1);
        buffer.append("\n");

        buffer.append(" "+tab+B2);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstDeclBool]");
        return buffer.toString();
    }
}
