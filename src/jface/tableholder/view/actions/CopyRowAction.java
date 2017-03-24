package jface.tableholder.view.actions;

import java.util.ResourceBundle;

import org.eclipse.jface.action.Action;

import jface.tableholder.util.PackageUtil;
import jface.tableholder.view.TableCreator;

public class CopyRowAction extends Action {
    
    private TableCreator tableCreator;
    private ResourceBundle rb;
    private final String MENU_ITEM_NAME;
    private final String MENU_ITEM_TOOLTIP;
    
    {
        rb = ResourceBundle.getBundle(PackageUtil.getPackageName(this.getClass()) + ".menu_actions");
        MENU_ITEM_NAME = rb.getString("CopyRowAction.menuItem");
        MENU_ITEM_TOOLTIP = rb.getString("CopyRowAction.menuTooltip");
    }

    public CopyRowAction() {
        setText("&" + MENU_ITEM_NAME + "@Ctrl+C");
        setToolTipText(MENU_ITEM_TOOLTIP);
    }

    public void run() {
        tableCreator.copyRow();
    }
    
    public void setTableCreator(TableCreator tableCreator) {
        this.tableCreator = tableCreator;
    }
}
