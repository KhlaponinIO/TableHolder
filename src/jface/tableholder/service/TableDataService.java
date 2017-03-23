package jface.tableholder.service;

import java.util.List;

import jface.tableholder.model.ArrayDataProvider;
import jface.tableholder.model.TableData;

/**
 * Service for the work with <code>DataProvider</code> instance
 * 
 * @author Igor Khlaponin
 *
 */
public class TableDataService {

	/**
	 * Storage for the previous row data. Used for cancelling changes in the row
	 * if the user isn't save changes
	 */
    public static TableData previousRow = new TableData("", "", false);
    /**
     * Storage for the updated row data. Used for updating table row from
     * edit bar
     */
    public static TableData updatedRow = new TableData("", "", false);
    
    /**
     * Instance of <code>ArrayDataProvider</code> - provides the list of <code>TableData</code>
     */
    private ArrayDataProvider provider;
    
    /**
     * Instance of <code>TableData</code> for storing copied (Ctrl + C) row
     * for futher pasting (Ctrl + V) it to the table - some kind of clipboard  
     */
    private TableData clipboardRow;

    /**
     * Creates the instance of this class
     * Instantiates <code>ArrayDataProvider</code> and clipboard <code>TableData</code>
     */
    public TableDataService() {
        provider = ArrayDataProvider.getInstance();
        clipboardRow = null;
    }

    /**
     * Get the list of data from <code>DataProvider</code>
     * @return list of <code>TableData</code>
     */
    public List<TableData> getData() {
        return provider.getData();
    }

    /**
     * Get the row from the list by the index
     * @param index - index of the row
     * @return instance of <code>TableData</code>
     */
    public TableData getRow(int index) {
        if (index >= 0 && index < provider.getData().size()) {
            return provider.getRow(index);
        } else {
            return null;
        }
    }

    /**
     * Deletes row from the list by index using <code>DataProvider</code>
     * @param index - index of the row
     * @return <code>true</code> if deleting is successful or <code>false</code> if not
     */
    public boolean deleteRow(int index) {
        return provider.deleteRow(index);
    }

    /**
     * Adds the row (instance of <code>TableData</code>) to the list using <code>DataProvider</code> 
     * @param rowData - instance of <code>TableData</code>
     * @return <code>true</code> if data was added successfully or <code>false</code> if not
     */
    public boolean addRow(TableData rowData) {
        return provider.addRow(rowData);
    }

    /**
     * Adds the row (instance of <code>TableData</code>) to the list using <code>DataProvider</code>
     * @param name - person's name
     * @param group - its group
     * @param isDone - check if he done the task
     * @return <code>true</code> if data was added successfully or <code>false</code> if not
     */
    public boolean addRow(String name, String group, boolean isDone) {
        return provider.addRow(name, group, isDone);
    }

    /**
     * Updates <code>TableData</code> in the list by index using <code>DataProvider</code> 
     * @param index - index of the row
     * @param rowData - updated row (instance of <code>TableData</code>
     * @return <code>true</code> if data was updated successfully or <code>false</code> if not
     */
    public boolean updateRow(int index, TableData rowData) {
        return provider.update(index, rowData);
    }

    /**
     * Copy the row to the "clipboard" 
     * @param rowData - current row (instance of <code>TableData</code>)
     */
    public void copyRow(TableData rowData) {
        clipboardRow = rowData;
    }

    /**
     * Paste the row to the list from the "clipboard"
     * It obtains the row data from the clipboard and adds it to the list
     */
    public void pasteRow() {
        if (clipboardRow != null) {
            addRow(new TableData(clipboardRow.getName(), clipboardRow.getGroup(), clipboardRow.isDone()));
        }
    }

    /**
     * Sets the data from the file
     * If the path wrong or such file doesn't exit table will be fullfilled with default data 
     * @param filePath - full path to the file where table data stored
     */
    public void setDataFromFile(String filePath) {
        provider.setData(filePath);
    }
}
