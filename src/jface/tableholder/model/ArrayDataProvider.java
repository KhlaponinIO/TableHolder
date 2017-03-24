package jface.tableholder.model;

import java.util.ArrayList;
import java.util.List;

import jface.tableholder.util.JsonFileWriter;

/**
 * Implementation of <code>DataProvider</code> that stores the data in the <code>List</code>
 * 
 * @author Igor Khlaponin
 *
 */
public class ArrayDataProvider implements DataProvider {

    /**
     * Data storage. Contains the instances of <code>TableData</code>
     */
    private List<TableData> data;

    /**
     * Storage for the previous row data. Used for cancelling changes in the row if the user isn't save changes
     */
    public TableData previousRow = new TableData("", "", false);
    /**
     * Storage for the updated row data. Used for updating table row from edit bar
     */
    public TableData updatedRow = new TableData("", "", false);

    private static class SingletonHolder {
        private final static ArrayDataProvider INSTANCE = new ArrayDataProvider();
    }

    /**
     * Returns the instance of this class
     * 
     * @return instance of <code>ArrayDataProvider</code>
     */
    public static ArrayDataProvider getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private ArrayDataProvider() {
        data = JsonFileWriter.getDataFromJsonFile();
        if (data == null) {
            data = new ArrayList<>();
            initData();
        }
    }

    private void initData() {
        data.add(new TableData("Darth Vader", "1", false));
        data.add(new TableData("Yoda", "2", true));
        data.add(new TableData("Luk Skywalker", "1", true));
    }

    /**
     * Sets the data from the file If the path wrong or such file doesn't exit table will be fullfilled with default
     * data
     * 
     * @param fileName - full path to the file where table data stored
     */
    public void setData(String fileName) {
        if (JsonFileWriter.getDataFromJsonFile(fileName) != null) {
            data = JsonFileWriter.getDataFromJsonFile(fileName);
        }
    }

    @Override
    public List<TableData> getData() {

        return data;
    }

    @Override
    public TableData getRow(int index) {

        if (index < 0 || index > data.size()) {
            return null;
        } else {
            return data.get(index);
        }
    }

    @Override
    public boolean deleteRow(int index) {
        if (index < 0 || index > data.size()) {
            return false;
        } else {
            data.remove(index);
            return true;
        }
    }

    @Override
    public boolean addRow(TableData rowData) {

        return data.add(rowData);
    }

    @Override
    public boolean addRow(String name, String group, boolean isDone) {
        TableData newData = new TableData(name, group, isDone);

        return this.addRow(newData);
    }

    @Override
    public boolean update(int index, TableData rowData) {
        if (index < 0 || index > data.size()) {
            return false;
        } else {
            data.set(index, rowData);
            return true;
        }
    }

    public TableData getPreviousRow() {
        return previousRow;
    }

    public void setPreviousRow(TableData previousRow) {
        this.previousRow = previousRow;
    }

    public TableData getUpdatedRow() {
        return updatedRow;
    }

    public void setUpdatedRow(TableData updatedRow) {
        this.updatedRow = updatedRow;
    }

}
