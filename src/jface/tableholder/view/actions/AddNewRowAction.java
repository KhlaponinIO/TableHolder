package jface.tableholder.view.actions;

import org.eclipse.jface.action.Action;

import jface.tableholder.view.TableCreator;

public class AddNewRowAction extends Action {
    
    private TableCreator tableCreator;

    public AddNewRowAction() {
        super("&New@Ctrl+N", AS_PUSH_BUTTON);
        setToolTipText("New line");
    }
    
    public void run() {
        tableCreator.addNewRow();
    }
    
    public void setTableCreator(TableCreator tableCreator) {
        this.tableCreator = tableCreator;
    }
}
