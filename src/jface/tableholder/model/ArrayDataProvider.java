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

}
