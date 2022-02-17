// generated with ast extension for cup
// version 0.8
// 17/1/2022 0:5:19


package rs.ac.bg.etf.pp1.ast;

public class DesStmFuncParams extends DesignatorStatement {

    private Designator Designator;
    private ActParsHelp ActParsHelp;
    private ActPars ActPars;

    public DesStmFuncParams (Designator Designator, ActParsHelp ActParsHelp, ActPars ActPars) {
        this.Designator=Designator;
        if(Designator!=null) Designator.setParent(this);
        this.ActParsHelp=ActParsHelp;
        if(ActParsHelp!=null) ActParsHelp.setParent(this);
        this.ActPars=ActPars;
        if(ActPars!=null) ActPars.setParent(this);
    }

    public Designator getDesignator() {
        return Designator;
    }

    public void setDesignator(Designator Designator) {
        this.Designator=Designator;
    }

    public ActParsHelp getActParsHelp() {
        return ActParsHelp;
    }

    public void setActParsHelp(ActParsHelp ActParsHelp) {
        this.ActParsHelp=ActParsHelp;
    }

    public ActPars getActPars() {
        return ActPars;
    }

    public void setActPars(ActPars ActPars) {
        this.ActPars=ActPars;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Designator!=null) Designator.accept(visitor);
        if(ActParsHelp!=null) ActParsHelp.accept(visitor);
        if(ActPars!=null) ActPars.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Designator!=null) Designator.traverseTopDown(visitor);
        if(ActParsHelp!=null) ActParsHelp.traverseTopDown(visitor);
        if(ActPars!=null) ActPars.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Designator!=null) Designator.traverseBottomUp(visitor);
        if(ActParsHelp!=null) ActParsHelp.traverseBottomUp(visitor);
        if(ActPars!=null) ActPars.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesStmFuncParams(\n");

        if(Designator!=null)
            buffer.append(Designator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ActParsHelp!=null)
            buffer.append(ActParsHelp.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ActPars!=null)
            buffer.append(ActPars.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesStmFuncParams]");
        return buffer.toString();
    }
}
