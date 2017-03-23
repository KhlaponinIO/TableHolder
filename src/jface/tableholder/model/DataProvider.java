package jface.tableholder.model;

import java.util.List;

/**
 * This is the interface for storing the row data for the <code>TableHolder</code> 
 * 
 * @author Igor Khlaponin
 *
 */
public interface DataProvider {
    
	/**
	 * Get the list of all data stored in the table
	 * @return list of <code>TableData</code>
	 */
    public List<TableData> getData();
    
    /**
     * Get the row with current index
     * @param index of the row
     * @return data stored in the current row (instance of <code>TableData</code>
     */
    public TableData getRow(int index);
    
    /**
     * Deletes the row from the list by current index
     * @param index of the row
     * @return <code>true</code> if deletion success and <code>false</code> if not
     */
    public boolean deleteRow(int index);
    
    /**
     * Add the row of data to the list
     * @param rowData - instance of <code>TableData</code>
     * @return <code>true</code> if the data was successfully added and <code>false</code> if not
     */
    public boolean addRow(TableData rowData);
    
    /**
     * Creates the instance of <code>TableData</code> and adds it to the list
     * @param name - name of the person
     * @param group - its group
     * @param isDone - check if he done his task
     * @return <code>true</code> if the data was successfully added and <code>false</code> if not
     */
    public boolean addRow(String name, String group, boolean isDone);
    
    /**
     * Updates row of data in the list by the index
     * @param index - index of row for updating
     * @param rowData - instance of <code>TableData</code>
     * @return
     */
    public boolean update(int index, TableData rowData);
}
