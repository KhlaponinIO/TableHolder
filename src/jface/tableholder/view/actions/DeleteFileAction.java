package jface.tableholder.view.actions;

import org.eclipse.jface.action.Action;

public class DeleteFileAction extends Action {
    
    public DeleteFileAction() {
        super("&Delete@Ctrl+D", AS_PUSH_BUTTON);
        setToolTipText("Delete file");
    }

    public void run() {
        System.out.println("file deleted!"); //mock
    }

}
