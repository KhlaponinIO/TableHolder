package jface.tableholder.view.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;

import jface.tableholder.service.FileService;
import jface.tableholder.service.TableDataService;

public class SaveAsFileAction extends Action {
    
    private TableDataService tableService;

    public SaveAsFileAction() {
        super("&Save as...", AS_PUSH_BUTTON);
        setToolTipText("Save as file");
        tableService = new TableDataService();
    }

    public void run() {
        FileDialog fileDialog = new FileDialog(Display.getCurrent().getShells()[0], SWT.SAVE);
        fileDialog.setText("Save as");
        fileDialog.setFilterPath("D:/");
        String[] filterExt = { ".json", ".xml" };
        fileDialog.setFilterExtensions(filterExt);
        
        String path = fileDialog.open();
        
        FileService.saveDataToFile(tableService.getData(), path);
        System.out.println("file saved to " + path);
    }
}
