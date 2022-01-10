// generated with ast extension for cup
// version 0.8
// 10/0/2022 23:45:10


package rs.ac.bg.etf.pp1.ast;

public class ExprNegative extends Expr {

    private Term Term;
    private ExprMore ExprMore;

    public ExprNegative (Term Term, ExprMore ExprMore) {
        this.Term=Term;
        if(Term!=null) Term.setParent(this);
        this.ExprMore=ExprMore;
        if(ExprMore!=null) ExprMore.setParent(this);
    }

    public Term getTerm() {
        return Term;
    }

    public void setTerm(Term Term) {
        this.Term=Term;
    }

    public ExprMore getExprMore() {
        return ExprMore;
    }

    public void setExprMore(ExprMore ExprMore) {
        this.ExprMore=ExprMore;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Term!=null) Term.accept(visitor);
        if(ExprMore!=null) ExprMore.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Term!=null) Term.traverseTopDown(visitor);
        if(ExprMore!=null) ExprMore.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Term!=null) Term.traverseBottomUp(visitor);
        if(ExprMore!=null) ExprMore.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ExprNegative(\n");

        if(Term!=null)
            buffer.append(Term.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ExprMore!=null)
            buffer.append(ExprMore.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ExprNegative]");
        return buffer.toString();
    }
}
