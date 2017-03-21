package jface.tableholder.view.actions;

import org.eclipse.jface.action.Action;

import jface.tableholder.view.TableCreator;

public class DeleteRowAction extends Action {
    
    private TableCreator tableCreator;
    
    public DeleteRowAction() {
        super("&Delete@Ctrl+D", AS_PUSH_BUTTON);
        setToolTipText("Delete row");
    }

    public void run() {
        tableCreator.deleteRow();
    }
    
    public void setTableCreator(TableCreator tableCreator) {
        this.tableCreator = tableCreator;
    }

}
