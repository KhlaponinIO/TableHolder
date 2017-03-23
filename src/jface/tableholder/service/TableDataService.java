package jface.tableholder.service;

import java.util.List;

import jface.tableholder.model.ArrayDataProvider;
import jface.tableholder.model.TableData;

public class TableDataService {

    private ArrayDataProvider provider;
    private TableData clipboardRow;

    public TableDataService() {
        provider = ArrayDataProvider.getInstance();
        clipboardRow = null;
    }

    public List<TableData> getData() {
        return provider.getData();
    }

    public TableData getRow(int index) {
        if (index >= 0 && index < provider.getData().size()) {
            return provider.getRow(index);
        } else {
            return null;
        }
    }

    public boolean deleteRow(int index) {
        return provider.deleteRow(index);
    }

    public boolean addRow(TableData rowData) {
        return provider.addRow(rowData);
    }

    public boolean addRow(String name, String group, boolean isDone) {
        return provider.addRow(name, group, isDone);
    }

    public boolean updateRow(int index, TableData rowData) {
        return provider.update(index, rowData);
    }

    public void copyRow(TableData rowData) {
        clipboardRow = rowData;
    }

    public void pasteRow() {
        if (clipboardRow != null) {
            addRow(new TableData(clipboardRow.getName(), clipboardRow.getGroup(), clipboardRow.isDone()));
        }
    }

    public void setDataFromFile(String filePath) {
        provider.setData(filePath);
    }
}
