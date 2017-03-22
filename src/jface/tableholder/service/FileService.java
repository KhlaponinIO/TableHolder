package jface.tableholder.service;

import java.util.List;

import jface.tableholder.model.TableData;
import jface.tableholder.util.JsonFileWriter;

public class FileService {
    
    /**
     * Saves list of <code>TableData</code> to the default file
     * @param data - list of data for saving
     */
    public static void saveDataToFile(List<TableData> data){
        JsonFileWriter.writeToJsonFile(data);
    }
    
    /**
     * Saves list of <code>TableData</code> to the selected file
     * @param data - list of data for saving
     * @param filePath - path to the file for saving 
     */
    public static void saveDataToFile(List<TableData> data, String filePath) {
        JsonFileWriter.writeToJsonFile(data, filePath);
    }

}
