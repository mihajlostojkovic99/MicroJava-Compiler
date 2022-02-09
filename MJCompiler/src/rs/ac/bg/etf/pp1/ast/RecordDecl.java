// generated with ast extension for cup
// version 0.8
// 9/1/2022 16:43:48


package rs.ac.bg.etf.pp1.ast;

public class RecordDecl implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private RecordDeclName RecordDeclName;
    private ListVarDeclWrapper ListVarDeclWrapper;

    public RecordDecl (RecordDeclName RecordDeclName, ListVarDeclWrapper ListVarDeclWrapper) {
        this.RecordDeclName=RecordDeclName;
        if(RecordDeclName!=null) RecordDeclName.setParent(this);
        this.ListVarDeclWrapper=ListVarDeclWrapper;
        if(ListVarDeclWrapper!=null) ListVarDeclWrapper.setParent(this);
    }

    public RecordDeclName getRecordDeclName() {
        return RecordDeclName;
    }

    public void setRecordDeclName(RecordDeclName RecordDeclName) {
        this.RecordDeclName=RecordDeclName;
    }

    public ListVarDeclWrapper getListVarDeclWrapper() {
        return ListVarDeclWrapper;
    }

    public void setListVarDeclWrapper(ListVarDeclWrapper ListVarDeclWrapper) {
        this.ListVarDeclWrapper=ListVarDeclWrapper;
    }

    public SyntaxNode getParent() {
        return parent;
    }

    public void setParent(SyntaxNode parent) {
        this.parent=parent;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line=line;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(RecordDeclName!=null) RecordDeclName.accept(visitor);
        if(ListVarDeclWrapper!=null) ListVarDeclWrapper.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(RecordDeclName!=null) RecordDeclName.traverseTopDown(visitor);
        if(ListVarDeclWrapper!=null) ListVarDeclWrapper.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(RecordDeclName!=null) RecordDeclName.traverseBottomUp(visitor);
        if(ListVarDeclWrapper!=null) ListVarDeclWrapper.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("RecordDecl(\n");

        if(RecordDeclName!=null)
            buffer.append(RecordDeclName.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ListVarDeclWrapper!=null)
            buffer.append(ListVarDeclWrapper.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [RecordDecl]");
        return buffer.toString();
    }
}
