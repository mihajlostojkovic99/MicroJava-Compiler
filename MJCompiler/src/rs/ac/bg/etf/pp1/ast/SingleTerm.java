// generated with ast extension for cup
// version 0.8
// 7/1/2022 0:7:32


package rs.ac.bg.etf.pp1.ast;

public class SingleTerm extends Term {

    private FactorWrapper FactorWrapper;

    public SingleTerm (FactorWrapper FactorWrapper) {
        this.FactorWrapper=FactorWrapper;
        if(FactorWrapper!=null) FactorWrapper.setParent(this);
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
        if(FactorWrapper!=null) FactorWrapper.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(FactorWrapper!=null) FactorWrapper.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(FactorWrapper!=null) FactorWrapper.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("SingleTerm(\n");

        if(FactorWrapper!=null)
            buffer.append(FactorWrapper.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [SingleTerm]");
        return buffer.toString();
    }
}
