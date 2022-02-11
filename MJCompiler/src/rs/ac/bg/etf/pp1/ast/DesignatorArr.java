// generated with ast extension for cup
// version 0.8
// 11/1/2022 16:24:27


package rs.ac.bg.etf.pp1.ast;

public class DesignatorArr extends Designator {

    private DesignatorArrName DesignatorArrName;
    private Expr Expr;

    public DesignatorArr (DesignatorArrName DesignatorArrName, Expr Expr) {
        this.DesignatorArrName=DesignatorArrName;
        if(DesignatorArrName!=null) DesignatorArrName.setParent(this);
        this.Expr=Expr;
        if(Expr!=null) Expr.setParent(this);
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

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DesignatorArrName!=null) DesignatorArrName.accept(visitor);
        if(Expr!=null) Expr.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorArrName!=null) DesignatorArrName.traverseTopDown(visitor);
        if(Expr!=null) Expr.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorArrName!=null) DesignatorArrName.traverseBottomUp(visitor);
        if(Expr!=null) Expr.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorArr(\n");

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

        buffer.append(tab);
        buffer.append(") [DesignatorArr]");
        return buffer.toString();
    }
}
