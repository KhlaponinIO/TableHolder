package jface.tableholder.view.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;

import jface.tableholder.service.FileService;
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
        if (MessageDialog.openQuestion(null, "Save file", "Want to save this table to " + JsonFileWriter.PATH + "?")) {
            FileService.saveDataToFile(dataService.getData());
        }
    }
}
