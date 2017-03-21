package jface.tableholder.model;

import java.util.ArrayList;
import java.util.List;

public class ArrayDataProvider implements DataProvider {

    private List<TableData> data;

    private static class SingletonHolder {
        private final static ArrayDataProvider INSTANCE = new ArrayDataProvider();
    }

    private ArrayDataProvider() {
        data = new ArrayList<>();
        initData();
    }

    private void initData() {
        data.add(new TableData("Darth Vader", "1", false));
        data.add(new TableData("Yoda", "2", true));
        data.add(new TableData("Luk Skywalker", "1", true));
    }

    public static ArrayDataProvider getInstance() {
        return SingletonHolder.INSTANCE;
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

}
