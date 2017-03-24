package jface.tableholder.view.actions;

import java.util.ResourceBundle;

import org.eclipse.jface.action.Action;

import jface.tableholder.util.PackageUtil;
import jface.tableholder.view.TableCreator;

public class AddNewRowAction extends Action {

    private TableCreator tableCreator;
    private ResourceBundle rb;
    private final String NEW_MENU_NAME;
    private final String NEW_MENU_ITEM_TOOLTIP;
    
    {
        rb = ResourceBundle.getBundle(PackageUtil.getPackageName(this.getClass()) + ".menu_actions");
        NEW_MENU_NAME = rb.getString("AddNewRowAction.menuItem");
        NEW_MENU_ITEM_TOOLTIP = rb.getString("AddNewRowAction.menuTooltip");
    }
    
    public AddNewRowAction() {
        setText("&" + NEW_MENU_NAME + "@Ctrl+N");
        setToolTipText(NEW_MENU_ITEM_TOOLTIP);
    }

    public void run() {
        tableCreator.addNewRow();
    }

    public void setTableCreator(TableCreator tableCreator) {
        this.tableCreator = tableCreator;
    }

}
