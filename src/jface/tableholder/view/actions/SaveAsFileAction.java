package jface.tableholder.view.actions;

import java.util.ResourceBundle;

import org.eclipse.jface.action.Action;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;

import jface.tableholder.service.FileService;
import jface.tableholder.service.TableDataService;
import jface.tableholder.util.PackageUtil;

public class SaveAsFileAction extends Action {
    
    private TableDataService tableService;
    
    private ResourceBundle rb;
    private final String MENU_ITEM_NAME;
    private final String MENU_ITEM_TOOLTIP;
    
    {
        rb = ResourceBundle.getBundle(PackageUtil.getPackageName(this.getClass()) + ".menu_actions");
        MENU_ITEM_NAME = rb.getString("SaveAsFileAction.menuItem");
        MENU_ITEM_TOOLTIP = rb.getString("SaveAsFileAction.menuTooltip");
    }

    public SaveAsFileAction() {
        setText("&" + MENU_ITEM_NAME);
        setToolTipText(MENU_ITEM_TOOLTIP);
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
    }
}
