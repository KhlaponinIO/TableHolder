package jface.tableholder.view.actions;

import java.util.ResourceBundle;

import org.eclipse.jface.action.Action;

import jface.tableholder.util.PackageUtil;
import jface.tableholder.view.TableCreator;

public class DeleteRowAction extends Action {
    
    private TableCreator tableCreator;
    
    private ResourceBundle rb;
    private final String MENU_ITEM_NAME;
    private final String MENU_ITEM_TOOLTIP;
    
    {
        rb = ResourceBundle.getBundle(PackageUtil.getPackageName(this.getClass()) + ".menu_actions");
        MENU_ITEM_NAME = rb.getString("DeleteRowAction.menuItem");
        MENU_ITEM_TOOLTIP = rb.getString("DeleteRowAction.menuTooltip");
    }
    
    public DeleteRowAction() {
        setText("&" + MENU_ITEM_NAME + "@Ctrl+D");
        setToolTipText(MENU_ITEM_TOOLTIP);
    }

    public void run() {
        tableCreator.deleteRow();
    }
    
    public void setTableCreator(TableCreator tableCreator) {
        this.tableCreator = tableCreator;
    }

}
