package jface.tableholder.model;

import java.util.List;

public interface DataProvider {
    
    public List<TableData> getData();
    
    public TableData getRow(int index);
    
    public boolean deleteRow(int index);
    
    public boolean addRow(TableData rowData);
    
    public boolean addRow(String name, String group, boolean isDone);
    
    public boolean update(int index, TableData rowData);
}
