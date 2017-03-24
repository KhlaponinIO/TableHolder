package jface.tableholder.view.actions;

import java.util.ResourceBundle;

import org.eclipse.jface.action.Action;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;

import jface.tableholder.service.TableDataService;
import jface.tableholder.util.PackageUtil;
import jface.tableholder.view.TableCreator;

public class OpenFileAction extends Action {
    
    private TableCreator tableCreator;
    private TableDataService tableService;
    
    private ResourceBundle rb;
    private final String MENU_ITEM_NAME;
    private final String MENU_ITEM_TOOLTIP;
    
    {
        rb = ResourceBundle.getBundle(PackageUtil.getPackageName(this.getClass()) + ".menu_actions");
        MENU_ITEM_NAME = rb.getString("OpenFileAction.menuItem");
        MENU_ITEM_TOOLTIP = rb.getString("OpenFileAction.menuTooltip");
    }

    public OpenFileAction() {
        setText("&" + MENU_ITEM_NAME + "@Ctrl+O");
        setToolTipText(MENU_ITEM_TOOLTIP);
        tableService = new TableDataService();
    }

    public void run() {
        FileDialog fileDialog = new FileDialog(Display.getCurrent().getShells()[0], SWT.OPEN);
        fileDialog.setText(MENU_ITEM_TOOLTIP);
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
