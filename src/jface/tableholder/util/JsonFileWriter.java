package jface.tableholder.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import jface.tableholder.model.TableData;

public class JsonFileWriter {

    private static Gson gson = new Gson();
    private static final String PATH = "d:\\jsonData.json";

    public static void writeToJsonFile(List<TableData> data) {

        try (FileWriter fileWriter = new FileWriter(PATH)) {
            fileWriter.write(gson.toJson(data));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static ArrayList<TableData> getDataFromJsonFile() {
        
        try (BufferedReader reader = new BufferedReader(new FileReader(PATH))) {
            
            String fileData = "";
            String currentLine;
            
            while ((currentLine = reader.readLine()) != null) {
                fileData = fileData + currentLine;
            }
            //isn't work properly. Fix it
            ArrayList<TableData> data = gson.fromJson(fileData, ArrayList.class);
            
            return data;
            
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
