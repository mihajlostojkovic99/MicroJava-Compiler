// generated with ast extension for cup
// version 0.8
// 7/1/2022 0:7:32


package rs.ac.bg.etf.pp1.ast;

public class DesignatorWithMore extends Designator {

    private String I1;
    private DesignatorMore DesignatorMore;

    public DesignatorWithMore (String I1, DesignatorMore DesignatorMore) {
        this.I1=I1;
        this.DesignatorMore=DesignatorMore;
        if(DesignatorMore!=null) DesignatorMore.setParent(this);
    }

    public String getI1() {
        return I1;
    }

    public void setI1(String I1) {
        this.I1=I1;
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
        if(DesignatorMore!=null) DesignatorMore.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorMore!=null) DesignatorMore.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorMore!=null) DesignatorMore.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorWithMore(\n");

        buffer.append(" "+tab+I1);
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
