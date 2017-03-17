package jface.tableholder.model;

public class TableData {

    private String name;
    private String group;
    private boolean isDone;
    
    public TableData(String name, String group, boolean done) {
        this.name = name;
        this.group = group;
        this.isDone = done;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        this.isDone = done;
    }
    
    
}
