// generated with ast extension for cup
// version 0.8
// 9/1/2022 16:26:18


package rs.ac.bg.etf.pp1.ast;

public class AssignWrapperError extends AssignWrapper {

    public AssignWrapperError () {
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
        buffer.append("AssignWrapperError(\n");

        buffer.append(tab);
        buffer.append(") [AssignWrapperError]");
        return buffer.toString();
    }
}
