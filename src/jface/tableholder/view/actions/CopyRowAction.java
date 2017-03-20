package jface.tableholder.view.actions;

import org.eclipse.jface.action.Action;

public class CopyRowAction extends Action {

    public CopyRowAction() {
        super("&Copy@Ctrl+C", AS_PUSH_BUTTON);
        setToolTipText("Copy active line");
    }

    public void run() {
        System.out.println("copy active line to the clipboard"); //mock
    }
}
