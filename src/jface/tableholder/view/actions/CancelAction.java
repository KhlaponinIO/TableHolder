package jface.tableholder.view.actions;

import org.eclipse.jface.action.Action;

import jface.tableholder.view.TableCreator;

public class CancelAction extends Action {
    
    private TableCreator tableCreator;

    public CancelAction() {
        super("&Cancel", AS_PUSH_BUTTON);
        setToolTipText("Cancel");
    }

    public void run() {
        tableCreator.cancel();
    }
    
    public void setTableCreator(TableCreator tableCreator) {
        this.tableCreator = tableCreator;
    }
}
