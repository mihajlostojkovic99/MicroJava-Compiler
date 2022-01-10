// generated with ast extension for cup
// version 0.8
// 10/0/2022 14:42:42


package rs.ac.bg.etf.pp1.ast;

public class RecordDeclList implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private RecordDeclList RecordDeclList;
    private RecordDecl RecordDecl;

    public RecordDeclList (RecordDeclList RecordDeclList, RecordDecl RecordDecl) {
        this.RecordDeclList=RecordDeclList;
        if(RecordDeclList!=null) RecordDeclList.setParent(this);
        this.RecordDecl=RecordDecl;
        if(RecordDecl!=null) RecordDecl.setParent(this);
    }

    public RecordDeclList getRecordDeclList() {
        return RecordDeclList;
    }

    public void setRecordDeclList(RecordDeclList RecordDeclList) {
        this.RecordDeclList=RecordDeclList;
    }

    public RecordDecl getRecordDecl() {
        return RecordDecl;
    }

    public void setRecordDecl(RecordDecl RecordDecl) {
        this.RecordDecl=RecordDecl;
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
        if(RecordDeclList!=null) RecordDeclList.accept(visitor);
        if(RecordDecl!=null) RecordDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(RecordDeclList!=null) RecordDeclList.traverseTopDown(visitor);
        if(RecordDecl!=null) RecordDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(RecordDeclList!=null) RecordDeclList.traverseBottomUp(visitor);
        if(RecordDecl!=null) RecordDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("RecordDeclList(\n");

        if(RecordDeclList!=null)
            buffer.append(RecordDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(RecordDecl!=null)
            buffer.append(RecordDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [RecordDeclList]");
        return buffer.toString();
    }
}
