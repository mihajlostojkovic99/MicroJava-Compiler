// generated with ast extension for cup
// version 0.8
// 11/1/2022 14:50:44


package rs.ac.bg.etf.pp1.ast;

public class MulTerms extends Term {

    private Term Term;
    private Mulop Mulop;
    private FactorWrapper FactorWrapper;

    public MulTerms (Term Term, Mulop Mulop, FactorWrapper FactorWrapper) {
        this.Term=Term;
        if(Term!=null) Term.setParent(this);
        this.Mulop=Mulop;
        if(Mulop!=null) Mulop.setParent(this);
        this.FactorWrapper=FactorWrapper;
        if(FactorWrapper!=null) FactorWrapper.setParent(this);
    }

    public Term getTerm() {
        return Term;
    }

    public void setTerm(Term Term) {
        this.Term=Term;
    }

    public Mulop getMulop() {
        return Mulop;
    }

    public void setMulop(Mulop Mulop) {
        this.Mulop=Mulop;
    }

    public FactorWrapper getFactorWrapper() {
        return FactorWrapper;
    }

    public void setFactorWrapper(FactorWrapper FactorWrapper) {
        this.FactorWrapper=FactorWrapper;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Term!=null) Term.accept(visitor);
        if(Mulop!=null) Mulop.accept(visitor);
        if(FactorWrapper!=null) FactorWrapper.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Term!=null) Term.traverseTopDown(visitor);
        if(Mulop!=null) Mulop.traverseTopDown(visitor);
        if(FactorWrapper!=null) FactorWrapper.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Term!=null) Term.traverseBottomUp(visitor);
        if(Mulop!=null) Mulop.traverseBottomUp(visitor);
        if(FactorWrapper!=null) FactorWrapper.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MulTerms(\n");

        if(Term!=null)
            buffer.append(Term.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Mulop!=null)
            buffer.append(Mulop.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(FactorWrapper!=null)
            buffer.append(FactorWrapper.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MulTerms]");
        return buffer.toString();
    }
}
