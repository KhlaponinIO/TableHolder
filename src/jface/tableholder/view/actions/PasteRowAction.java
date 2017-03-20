package jface.tableholder.view.actions;

import org.eclipse.jface.action.Action;

public class PasteRowAction extends Action {

    public PasteRowAction() {
        super("&Paste@Ctrl+V", AS_PUSH_BUTTON);
        setToolTipText("Paste line from clipboard");
    }

    public void run() {
        System.out.println("Paste line from clipboard"); //mock
    }
}
