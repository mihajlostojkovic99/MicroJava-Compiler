// generated with ast extension for cup
// version 0.8
// 5/1/2022 1:28:11


package rs.ac.bg.etf.pp1.ast;

public class FormalParameterError extends FormPar {

    public FormalParameterError () {
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
        buffer.append("FormalParameterError(\n");

        buffer.append(tab);
        buffer.append(") [FormalParameterError]");
        return buffer.toString();
    }
}
