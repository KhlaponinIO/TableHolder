package jface.tableholder.view.actions;

import org.eclipse.jface.action.Action;

public class ShowAboutAction extends Action {
    
    public ShowAboutAction() {
        super("&About@Ctrl+H", AS_PUSH_BUTTON);
        setToolTipText("About");
    }

    public void run() {
        System.out.println("show info about application"); //mock
    }

}
