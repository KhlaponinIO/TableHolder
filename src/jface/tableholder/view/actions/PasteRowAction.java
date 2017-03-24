package jface.tableholder.view.actions;

import java.util.ResourceBundle;

import org.eclipse.jface.action.Action;

import jface.tableholder.util.PackageUtil;
import jface.tableholder.view.TableCreator;

public class PasteRowAction extends Action {
    
    private TableCreator tableCreator;
    
    private ResourceBundle rb;
    private final String MENU_ITEM_NAME;
    private final String MENU_ITEM_TOOLTIP;
    
    {
        rb = ResourceBundle.getBundle(PackageUtil.getPackageName(this.getClass()) + ".menu_actions");
        MENU_ITEM_NAME = rb.getString("PasteRowAction.menuItem");
        MENU_ITEM_TOOLTIP = rb.getString("PasteRowAction.menuTooltip");
    }

    public PasteRowAction() {
        setText("&" + MENU_ITEM_NAME + "@Ctrl+V");
        setToolTipText(MENU_ITEM_TOOLTIP);
    }

    public void run() {
        tableCreator.pasteRow();
    }
    
    public void setTableCreator(TableCreator tableCreator) {
        this.tableCreator = tableCreator;
    }
}
