// generated with ast extension for cup
// version 0.8
// 10/0/2022 15:58:17


package rs.ac.bg.etf.pp1.ast;

public class ThereIsMoreExpr extends ExprMore {

    private ExprMore ExprMore;
    private Addop Addop;
    private Term Term;

    public ThereIsMoreExpr (ExprMore ExprMore, Addop Addop, Term Term) {
        this.ExprMore=ExprMore;
        if(ExprMore!=null) ExprMore.setParent(this);
        this.Addop=Addop;
        if(Addop!=null) Addop.setParent(this);
        this.Term=Term;
        if(Term!=null) Term.setParent(this);
    }

    public ExprMore getExprMore() {
        return ExprMore;
    }

    public void setExprMore(ExprMore ExprMore) {
        this.ExprMore=ExprMore;
    }

    public Addop getAddop() {
        return Addop;
    }

    public void setAddop(Addop Addop) {
        this.Addop=Addop;
    }

    public Term getTerm() {
        return Term;
    }

    public void setTerm(Term Term) {
        this.Term=Term;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ExprMore!=null) ExprMore.accept(visitor);
        if(Addop!=null) Addop.accept(visitor);
        if(Term!=null) Term.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ExprMore!=null) ExprMore.traverseTopDown(visitor);
        if(Addop!=null) Addop.traverseTopDown(visitor);
        if(Term!=null) Term.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ExprMore!=null) ExprMore.traverseBottomUp(visitor);
        if(Addop!=null) Addop.traverseBottomUp(visitor);
        if(Term!=null) Term.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ThereIsMoreExpr(\n");

        if(ExprMore!=null)
            buffer.append(ExprMore.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Addop!=null)
            buffer.append(Addop.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Term!=null)
            buffer.append(Term.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ThereIsMoreExpr]");
        return buffer.toString();
    }
}
