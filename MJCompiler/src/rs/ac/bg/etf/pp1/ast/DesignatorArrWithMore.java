// generated with ast extension for cup
// version 0.8
// 7/1/2022 20:20:37


package rs.ac.bg.etf.pp1.ast;

public class DesignatorArrWithMore extends Designator {

    private DesignatorArrName DesignatorArrName;
    private Expr Expr;
    private DesignatorMore DesignatorMore;

    public DesignatorArrWithMore (DesignatorArrName DesignatorArrName, Expr Expr, DesignatorMore DesignatorMore) {
        this.DesignatorArrName=DesignatorArrName;
        if(DesignatorArrName!=null) DesignatorArrName.setParent(this);
        this.Expr=Expr;
        if(Expr!=null) Expr.setParent(this);
        this.DesignatorMore=DesignatorMore;
        if(DesignatorMore!=null) DesignatorMore.setParent(this);
    }

    public DesignatorArrName getDesignatorArrName() {
        return DesignatorArrName;
    }

    public void setDesignatorArrName(DesignatorArrName DesignatorArrName) {
        this.DesignatorArrName=DesignatorArrName;
    }

    public Expr getExpr() {
        return Expr;
    }

    public void setExpr(Expr Expr) {
        this.Expr=Expr;
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
        if(DesignatorArrName!=null) DesignatorArrName.accept(visitor);
        if(Expr!=null) Expr.accept(visitor);
        if(DesignatorMore!=null) DesignatorMore.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorArrName!=null) DesignatorArrName.traverseTopDown(visitor);
        if(Expr!=null) Expr.traverseTopDown(visitor);
        if(DesignatorMore!=null) DesignatorMore.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorArrName!=null) DesignatorArrName.traverseBottomUp(visitor);
        if(Expr!=null) Expr.traverseBottomUp(visitor);
        if(DesignatorMore!=null) DesignatorMore.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorArrWithMore(\n");

        if(DesignatorArrName!=null)
            buffer.append(DesignatorArrName.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Expr!=null)
            buffer.append(Expr.toString("  "+tab));
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
