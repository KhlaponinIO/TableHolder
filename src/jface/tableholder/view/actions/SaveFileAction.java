package jface.tableholder.view.actions;

import org.eclipse.jface.action.Action;

public class SaveFileAction extends Action {

    public SaveFileAction() {
        super("&Save@Ctrl+S", AS_PUSH_BUTTON);
        setToolTipText("Save file");
    }

    public void run() {
        System.out.println("file saved!"); //mock
    }
}
