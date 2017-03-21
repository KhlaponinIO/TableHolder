package jface.tableholder.view.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;

public class ShowAboutAction extends Action {
    
    public ShowAboutAction() {
        super("&About@Ctrl+H", AS_PUSH_BUTTON);
        setToolTipText("About");
    }

    public void run() {
        MessageDialog.openInformation(null, "About", "This is JFace/SWT application");
    }

}
