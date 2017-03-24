package jface.tableholder.view.actions;

import java.util.ResourceBundle;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;

import jface.tableholder.service.FileService;
import jface.tableholder.service.TableDataService;
import jface.tableholder.util.JsonFileWriter;
import jface.tableholder.util.PackageUtil;

public class SaveFileAction extends Action {

    private TableDataService dataService;
    
    private ResourceBundle rb;
    private final String MENU_ITEM_NAME;
    private final String MENU_ITEM_TOOLTIP;
    private final String SAVE_TITLE;
    private final String SAVE_MESSAGE;
    
    {
        rb = ResourceBundle.getBundle(PackageUtil.getPackageName(this.getClass()) + ".menu_actions");
        MENU_ITEM_NAME = rb.getString("SaveFileAction.menuItem");
        MENU_ITEM_TOOLTIP = rb.getString("SaveFileAction.menuTooltip");
        SAVE_TITLE = rb.getString("SaveFileAction.save.message.title");
        SAVE_MESSAGE = rb.getString("SaveFileAction.save.message");
    }

    public SaveFileAction() {
        setText("&" + MENU_ITEM_NAME + "@Ctrl+S");
        setToolTipText(MENU_ITEM_TOOLTIP);
        dataService = new TableDataService();
    }

    public void run() {
        if (MessageDialog.openQuestion(null, SAVE_TITLE, SAVE_MESSAGE + " " + JsonFileWriter.PATH + "?")) {
            FileService.saveDataToFile(dataService.getData());
        }
    }
}
