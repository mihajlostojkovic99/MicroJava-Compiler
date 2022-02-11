// generated with ast extension for cup
// version 0.8
// 11/1/2022 14:50:44


package rs.ac.bg.etf.pp1.ast;

public class DesignatorArrWithMore extends Designator {

    private DesignatorMoreElem DesignatorMoreElem;
    private DesignatorMore DesignatorMore;

    public DesignatorArrWithMore (DesignatorMoreElem DesignatorMoreElem, DesignatorMore DesignatorMore) {
        this.DesignatorMoreElem=DesignatorMoreElem;
        if(DesignatorMoreElem!=null) DesignatorMoreElem.setParent(this);
        this.DesignatorMore=DesignatorMore;
        if(DesignatorMore!=null) DesignatorMore.setParent(this);
    }

    public DesignatorMoreElem getDesignatorMoreElem() {
        return DesignatorMoreElem;
    }

    public void setDesignatorMoreElem(DesignatorMoreElem DesignatorMoreElem) {
        this.DesignatorMoreElem=DesignatorMoreElem;
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
        if(DesignatorMoreElem!=null) DesignatorMoreElem.accept(visitor);
        if(DesignatorMore!=null) DesignatorMore.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorMoreElem!=null) DesignatorMoreElem.traverseTopDown(visitor);
        if(DesignatorMore!=null) DesignatorMore.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorMoreElem!=null) DesignatorMoreElem.traverseBottomUp(visitor);
        if(DesignatorMore!=null) DesignatorMore.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorArrWithMore(\n");

        if(DesignatorMoreElem!=null)
            buffer.append(DesignatorMoreElem.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(DesignatorMore!=null)
            buffer.append(DesignatorMore.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorArrWithMore]");
        return buffer.toString();
    }
}
