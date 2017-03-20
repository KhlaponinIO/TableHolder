package jface.tableholder.view.actions;

import org.eclipse.jface.action.Action;

public class CancelAction extends Action {

    public CancelAction() {
        super("&Cancel", AS_PUSH_BUTTON);
        setToolTipText("Cancel");
    }

    public void run() {
        System.out.println("action canceled!"); //mock
    }
}
