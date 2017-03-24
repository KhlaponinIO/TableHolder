package jface.tableholder.view.actions;

import java.util.ResourceBundle;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.ApplicationWindow;

import jface.tableholder.util.PackageUtil;

public class ExitAction extends Action {

    private ApplicationWindow window;
    
    private ResourceBundle rb;
    private final String MENU_ITEM_NAME;
    private final String MENU_ITEM_TOOLTIP;
    private final String EXIT_TITLE;
    private final String EXIT_MESSAGE;
    
    {
        rb = ResourceBundle.getBundle(PackageUtil.getPackageName(this.getClass()) + ".menu_actions");
        MENU_ITEM_NAME = rb.getString("ExitAction.menuItem");
        MENU_ITEM_TOOLTIP = rb.getString("ExitAction.menuTooltip");
        EXIT_TITLE = rb.getString("ExitAction.exit.title");
        EXIT_MESSAGE = rb.getString("ExitAction.exit.message");
    }

    public ExitAction(ApplicationWindow window) {
        this.window = window;
        setText("&" + MENU_ITEM_NAME + "@Ctrl+Q");
        setToolTipText(MENU_ITEM_TOOLTIP);
    }

    public void run() {
        if (MessageDialog.openQuestion(null, EXIT_TITLE, EXIT_MESSAGE)) {
            window.close();
        }
    }
}
