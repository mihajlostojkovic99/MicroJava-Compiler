// generated with ast extension for cup
// version 0.8
// 11/1/2022 14:50:44


package rs.ac.bg.etf.pp1.ast;

public class DesStmAssign extends DesignatorStatement {

    private Designator Designator;
    private AssignWrapper AssignWrapper;

    public DesStmAssign (Designator Designator, AssignWrapper AssignWrapper) {
        this.Designator=Designator;
        if(Designator!=null) Designator.setParent(this);
        this.AssignWrapper=AssignWrapper;
        if(AssignWrapper!=null) AssignWrapper.setParent(this);
    }

    public Designator getDesignator() {
        return Designator;
    }

    public void setDesignator(Designator Designator) {
        this.Designator=Designator;
    }

    public AssignWrapper getAssignWrapper() {
        return AssignWrapper;
    }

    public void setAssignWrapper(AssignWrapper AssignWrapper) {
        this.AssignWrapper=AssignWrapper;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Designator!=null) Designator.accept(visitor);
        if(AssignWrapper!=null) AssignWrapper.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Designator!=null) Designator.traverseTopDown(visitor);
        if(AssignWrapper!=null) AssignWrapper.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Designator!=null) Designator.traverseBottomUp(visitor);
        if(AssignWrapper!=null) AssignWrapper.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesStmAssign(\n");

        if(Designator!=null)
            buffer.append(Designator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(AssignWrapper!=null)
            buffer.append(AssignWrapper.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesStmAssign]");
        return buffer.toString();
    }
}
