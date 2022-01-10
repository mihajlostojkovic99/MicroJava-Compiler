// generated with ast extension for cup
// version 0.8
// 10/0/2022 14:42:42


package rs.ac.bg.etf.pp1.ast;

public class NormalClass extends ClassDecl {

    private String I1;
    private VarDeclWrapper VarDeclWrapper;

    public NormalClass (String I1, VarDeclWrapper VarDeclWrapper) {
        this.I1=I1;
        this.VarDeclWrapper=VarDeclWrapper;
        if(VarDeclWrapper!=null) VarDeclWrapper.setParent(this);
    }

    public String getI1() {
        return I1;
    }

    public void setI1(String I1) {
        this.I1=I1;
    }

    public VarDeclWrapper getVarDeclWrapper() {
        return VarDeclWrapper;
    }

    public void setVarDeclWrapper(VarDeclWrapper VarDeclWrapper) {
        this.VarDeclWrapper=VarDeclWrapper;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(VarDeclWrapper!=null) VarDeclWrapper.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(VarDeclWrapper!=null) VarDeclWrapper.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(VarDeclWrapper!=null) VarDeclWrapper.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("NormalClass(\n");

        buffer.append(" "+tab+I1);
        buffer.append("\n");

        if(VarDeclWrapper!=null)
            buffer.append(VarDeclWrapper.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [NormalClass]");
        return buffer.toString();
    }
}
