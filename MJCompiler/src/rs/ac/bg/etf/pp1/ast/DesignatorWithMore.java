// generated with ast extension for cup
// version 0.8
// 9/1/2022 16:43:49


package rs.ac.bg.etf.pp1.ast;

public class DesignatorWithMore extends Designator {

    private DesignatorWithMoreName DesignatorWithMoreName;
    private DesignatorMore DesignatorMore;

    public DesignatorWithMore (DesignatorWithMoreName DesignatorWithMoreName, DesignatorMore DesignatorMore) {
        this.DesignatorWithMoreName=DesignatorWithMoreName;
        if(DesignatorWithMoreName!=null) DesignatorWithMoreName.setParent(this);
        this.DesignatorMore=DesignatorMore;
        if(DesignatorMore!=null) DesignatorMore.setParent(this);
    }

    public DesignatorWithMoreName getDesignatorWithMoreName() {
        return DesignatorWithMoreName;
    }

    public void setDesignatorWithMoreName(DesignatorWithMoreName DesignatorWithMoreName) {
        this.DesignatorWithMoreName=DesignatorWithMoreName;
    }

    public DesignatorMore getDesignatorMore() {
        return DesignatorMore;
    }

    public void setDesignatorMore(DesignatorMore DesignatorMore) {
        this.DesignatorMore=DesignatorMore;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DesignatorWithMoreName!=null) DesignatorWithMoreName.accept(visitor);
        if(DesignatorMore!=null) DesignatorMore.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorWithMoreName!=null) DesignatorWithMoreName.traverseTopDown(visitor);
        if(DesignatorMore!=null) DesignatorMore.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorWithMoreName!=null) DesignatorWithMoreName.traverseBottomUp(visitor);
        if(DesignatorMore!=null) DesignatorMore.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorWithMore(\n");

        if(DesignatorWithMoreName!=null)
            buffer.append(DesignatorWithMoreName.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(DesignatorMore!=null)
            buffer.append(DesignatorMore.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorWithMore]");
        return buffer.toString();
    }
}
