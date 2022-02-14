// generated with ast extension for cup
// version 0.8
// 14/1/2022 13:8:18


package rs.ac.bg.etf.pp1.ast;

public class DoWhileSingleStatement extends SingleStatement {

    private DoWhileHelp DoWhileHelp;
    private Statement Statement;
    private Condition Condition;

    public DoWhileSingleStatement (DoWhileHelp DoWhileHelp, Statement Statement, Condition Condition) {
        this.DoWhileHelp=DoWhileHelp;
        if(DoWhileHelp!=null) DoWhileHelp.setParent(this);
        this.Statement=Statement;
        if(Statement!=null) Statement.setParent(this);
        this.Condition=Condition;
        if(Condition!=null) Condition.setParent(this);
    }

    public DoWhileHelp getDoWhileHelp() {
        return DoWhileHelp;
    }

    public void setDoWhileHelp(DoWhileHelp DoWhileHelp) {
        this.DoWhileHelp=DoWhileHelp;
    }

    public Statement getStatement() {
        return Statement;
    }

    public void setStatement(Statement Statement) {
        this.Statement=Statement;
    }

    public Condition getCondition() {
        return Condition;
    }

    public void setCondition(Condition Condition) {
        this.Condition=Condition;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DoWhileHelp!=null) DoWhileHelp.accept(visitor);
        if(Statement!=null) Statement.accept(visitor);
        if(Condition!=null) Condition.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DoWhileHelp!=null) DoWhileHelp.traverseTopDown(visitor);
        if(Statement!=null) Statement.traverseTopDown(visitor);
        if(Condition!=null) Condition.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DoWhileHelp!=null) DoWhileHelp.traverseBottomUp(visitor);
        if(Statement!=null) Statement.traverseBottomUp(visitor);
        if(Condition!=null) Condition.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DoWhileSingleStatement(\n");

        if(DoWhileHelp!=null)
            buffer.append(DoWhileHelp.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Statement!=null)
            buffer.append(Statement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Condition!=null)
            buffer.append(Condition.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DoWhileSingleStatement]");
        return buffer.toString();
    }
}
