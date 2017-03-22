package jface.tableholder.view.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;

import jface.tableholder.service.TableDataService;
import jface.tableholder.view.TableCreator;

public class OpenFileAction extends Action {
    
    private TableCreator tableCreator;
    private TableDataService tableService;

    public OpenFileAction() {
        super("Open...", AS_PUSH_BUTTON);
        setToolTipText("Save file");
        tableService = new TableDataService();
    }

    public void run() {
        FileDialog fileDialog = new FileDialog(Display.getCurrent().getShells()[0], SWT.OPEN);
        fileDialog.setText("Open file");
        fileDialog.setFilterPath("D:/");
        String[] filterExtensions = { "*.*", ".json", ".xml" };
        fileDialog.setFilterExtensions(filterExtensions);

        String selected = fileDialog.open();
        tableService.setDataFromFile(selected);
        tableCreator.getTableViewer().setInput(tableService.getData());
        tableCreator.refreshViewer();
    }
    
    public void setTableCreator(TableCreator tableCreator) {
        this.tableCreator = tableCreator;
    }
}
