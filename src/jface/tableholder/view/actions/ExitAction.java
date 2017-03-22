package jface.tableholder.view.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.ApplicationWindow;

public class ExitAction extends Action {

    private ApplicationWindow window;

    public ExitAction(ApplicationWindow window) {
        this.window = window;
        setText("&Exit@Ctrl+Q");
        setToolTipText("Exit from application");
    }

    public void run() {
        if (MessageDialog.openQuestion(null, "Exit", "Want to exit?")) {
            window.close();
        }
    }
}
