package jface.tableholder.view.actions;

import org.eclipse.jface.action.Action;

import jface.tableholder.service.TableDataService;
import jface.tableholder.util.JsonFileWriter;

public class SaveFileAction extends Action {
    
    private TableDataService dataService;

    public SaveFileAction() {
        super("&Save@Ctrl+S", AS_PUSH_BUTTON);
        setToolTipText("Save file");
        dataService = new TableDataService();
    }

    public void run() {
        
        JsonFileWriter.writeToJsonFile(dataService.getData());
        System.out.println("file saved to d:\\jsonData.json");
    }
}
