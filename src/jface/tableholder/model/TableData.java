package jface.tableholder.model;


/**
 * Stores the data in the row of the <code>TableHolder</code>
 * 
 * @author Igor Khlaponin
 *
 */
public class TableData {

	/**
	 * Name of the person
	 */
    private String name;
    /**
     * Person's group
     */
    private String group;
    /**
     * Show if person finished the task
     */
    private boolean isDone;
    
    /**
     * Creates the instance of this class with next parameters
     * @param name - name of the person
     * @param group - its group
     * @param done - show if he done task
     */
    public TableData(String name, String group, boolean done) {
        this.name = name;
        this.group = group;
        this.isDone = done;
    }
    
    /**
     * Creates the new instance of this class based on another <class>TableData</class> instance
     * @param data - instance for copying
     */
    public TableData(TableData data) {
        this.name = data.getName();
        this.group = data.getGroup();
        this.isDone = data.isDone();
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((group == null) ? 0 : group.hashCode());
        result = prime * result + (isDone ? 1231 : 1237);
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        TableData other = (TableData) obj;
        if (group == null) {
            if (other.group != null)
                return false;
        } else if (!group.equals(other.group))
            return false;
        if (isDone != other.isDone)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }
    
    @Override
    public String toString() {
        return "name: " + this.name + "; group: " + this.group + " " + "; SWT done: " + this.isDone;
    }
    
}
