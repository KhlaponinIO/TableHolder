package jface.tableholder.view.actions;

import org.eclipse.jface.action.Action;

public class AddNewRowAction extends Action {

    public AddNewRowAction() {
        super("&New@Ctrl+N", AS_PUSH_BUTTON);
        setToolTipText("New line");
    }

    public void run() {
        System.out.println("add new line to the table"); //mock
    }
}
