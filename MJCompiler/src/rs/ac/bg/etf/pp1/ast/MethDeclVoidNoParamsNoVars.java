// generated with ast extension for cup
// version 0.8
// 10/0/2022 23:45:10


package rs.ac.bg.etf.pp1.ast;

public class MethDeclVoidNoParamsNoVars extends MethodDecl {

    private String I1;
    private StatementList StatementList;

    public MethDeclVoidNoParamsNoVars (String I1, StatementList StatementList) {
        this.I1=I1;
        this.StatementList=StatementList;
        if(StatementList!=null) StatementList.setParent(this);
    }

    public String getI1() {
        return I1;
    }

    public void setI1(String I1) {
        this.I1=I1;
    }

    public StatementList getStatementList() {
        return StatementList;
    }

    public void setStatementList(StatementList StatementList) {
        this.StatementList=StatementList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(StatementList!=null) StatementList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(StatementList!=null) StatementList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(StatementList!=null) StatementList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MethDeclVoidNoParamsNoVars(\n");

        buffer.append(" "+tab+I1);
        buffer.append("\n");

        if(StatementList!=null)
            buffer.append(StatementList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MethDeclVoidNoParamsNoVars]");
        return buffer.toString();
    }
}
