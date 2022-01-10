// generated with ast extension for cup
// version 0.8
// 10/0/2022 13:44:31


package rs.ac.bg.etf.pp1.ast;

public class ListRecord extends List {

    private List List;
    private RecordDeclList RecordDeclList;

    public ListRecord (List List, RecordDeclList RecordDeclList) {
        this.List=List;
        if(List!=null) List.setParent(this);
        this.RecordDeclList=RecordDeclList;
        if(RecordDeclList!=null) RecordDeclList.setParent(this);
    }

    public List getList() {
        return List;
    }

    public void setList(List List) {
        this.List=List;
    }

    public RecordDeclList getRecordDeclList() {
        return RecordDeclList;
    }

    public void setRecordDeclList(RecordDeclList RecordDeclList) {
        this.RecordDeclList=RecordDeclList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(List!=null) List.accept(visitor);
        if(RecordDeclList!=null) RecordDeclList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(List!=null) List.traverseTopDown(visitor);
        if(RecordDeclList!=null) RecordDeclList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(List!=null) List.traverseBottomUp(visitor);
        if(RecordDeclList!=null) RecordDeclList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ListRecord(\n");

        if(List!=null)
            buffer.append(List.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(RecordDeclList!=null)
            buffer.append(RecordDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ListRecord]");
        return buffer.toString();
    }
}
