package jface.tableholder.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import jface.tableholder.model.TableData;

public class JsonFileWriter {

    private static Gson gson = new Gson();
    public static final String PATH = "d:\\jsonData.json";
    
    /**
     * Writes the list of <code>TableData</code> to the JSON file
     * @param data
     *            is the list of <code>TableData</code>
     */
    public static void writeToJsonFile(List<TableData> data) {

        try (FileWriter fileWriter = new FileWriter(PATH)) {
            fileWriter.write(gson.toJson(data));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Returns list of <code>TableData</code> from file 
     * @return list of <code>TableData</code> or
     *         <code>null</code> if file is absent or file contains different data
     */
    public static ArrayList<TableData> getDataFromJsonFile() {
        
        try (BufferedReader reader = new BufferedReader(new FileReader(PATH))) {
            
            String fileData = "";
            String currentLine;
            
            while ((currentLine = reader.readLine()) != null) {
                fileData = fileData + currentLine;
            }
            
            Type listType = new TypeToken<ArrayList<TableData>>(){}.getType();
            List<TableData> dataList = gson.fromJson(fileData, listType); 
            
            return (ArrayList<TableData>) dataList;
            
        } catch (IOException e) {
            return null;
        } catch (Exception e) {
            return null;
        }
    }
    
}
