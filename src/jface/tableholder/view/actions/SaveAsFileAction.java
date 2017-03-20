package jface.tableholder.view.actions;

import org.eclipse.jface.action.Action;

public class SaveAsFileAction extends Action {

    public SaveAsFileAction() {
        super("&Save as...", AS_PUSH_BUTTON);
        setToolTipText("Save as file");
    }

    public void run() {
        System.out.println("file saved as..."); //mock
    }
}
