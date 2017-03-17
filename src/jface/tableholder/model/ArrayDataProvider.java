package jface.tableholder.model;

import java.util.ArrayList;
import java.util.List;

public class ArrayDataProvider implements DataProvider {

    private List<TableData> data;
    
    public ArrayDataProvider() {
        data = new ArrayList<>();
        
        data.add(new TableData("Darth Vaded", "1", false));
        data.add(new TableData("Yoda", "2", true));
        data.add(new TableData("Luk Skywalker", "1", true));
    }
    
    @Override
    public List<TableData> getData() {
        
        return data;
    }

}
