package jface.tableholder.view.actions;

import java.util.ResourceBundle;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;

import jface.tableholder.util.PackageUtil;

public class ShowAboutAction extends Action {
    
    private ResourceBundle rb;
    private final String MENU_ITEM_NAME;
    private final String MENU_ITEM_TOOLTIP;
    private final String ABOUT_TITLE;
    private final String ABOUT_MESSAGE;
    
    {
        rb = ResourceBundle.getBundle(PackageUtil.getPackageName(this.getClass()) + ".menu_actions");
        MENU_ITEM_NAME = rb.getString("ShowAboutAction.menuItem");
        MENU_ITEM_TOOLTIP = rb.getString("ShowAboutAction.menuTooltip");
        ABOUT_TITLE = rb.getString("ShowAboutAction.about.message.title");
        ABOUT_MESSAGE = rb.getString("ShowAboutAction.about.message");
    }
    
    public ShowAboutAction() {
        setText("&" + MENU_ITEM_NAME + "@Ctrl+H");
        setToolTipText(MENU_ITEM_TOOLTIP);
    }

    public void run() {
        MessageDialog.openInformation(null, ABOUT_TITLE, ABOUT_MESSAGE);
    }

}
