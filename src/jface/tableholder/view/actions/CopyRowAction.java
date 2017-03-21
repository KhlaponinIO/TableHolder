package jface.tableholder.view.actions;

import org.eclipse.jface.action.Action;

import jface.tableholder.view.TableCreator;

public class CopyRowAction extends Action {
    
    private TableCreator tableCreator;

    public CopyRowAction() {
        super("&Copy@Ctrl+C", AS_PUSH_BUTTON);
        setToolTipText("Copy active line");
    }

    public void run() {
        tableCreator.copyRow();
    }
    
    public void setTableCreator(TableCreator tableCreator) {
        this.tableCreator = tableCreator;
    }
}
