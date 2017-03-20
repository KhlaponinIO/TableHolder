package jface.tableholder;

import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;

import jface.tableholder.view.EditPartCreator;
import jface.tableholder.view.TableCreator;
import jface.tableholder.view.actions.AddNewRowAction;
import jface.tableholder.view.actions.CancelAction;
import jface.tableholder.view.actions.DeleteFileAction;
import jface.tableholder.view.actions.SaveAsFileAction;
import jface.tableholder.view.actions.SaveFileAction;
import jface.tableholder.view.actions.ShowAboutAction;


public class TableHolder extends ApplicationWindow {
    
    public TableHolder() {
        super(null);
        addMenuBar();
    }

    @Override
    protected Control createContents(Composite parent) {

        getShell().setText("JFace homework log");
        getShell().setMinimumSize(600, 300);
        addMenuBar();
        layoutsSetting(parent);
        
        // parent.pack();
        return parent;
    }

    public static void main(String[] args) {
        TableHolder holder = new TableHolder();
        holder.setBlockOnOpen(true);
        holder.open();
        Display.getCurrent().dispose();
    }
    
    @SuppressWarnings("unused")
    private void layoutsSetting(Composite parent) {
        
        Composite composite = new Composite(parent, SWT.NONE);
        composite.setLayout(new FillLayout());
        
        SashForm form = new SashForm(composite, SWT.HORIZONTAL);
        
        TableCreator tableCreator = new TableCreator(form);
        EditPartCreator editPart = new EditPartCreator(form);
        
    }
    
    protected MenuManager createMenuManager() {
        MenuManager menuManager = new MenuManager();
        MenuManager fileMenu = new MenuManager("&File");
        menuManager.add(fileMenu);
        fileMenu.add(new SaveFileAction());
        fileMenu.add(new SaveAsFileAction());
        
        MenuManager editMenu = new MenuManager("&Edit");
        menuManager.add(editMenu);
        editMenu.add(new AddNewRowAction());
        editMenu.add(new DeleteFileAction());
        editMenu.add(new CancelAction());
        
        MenuManager aboutMenu = new MenuManager("&Help");
        menuManager.add(aboutMenu);
        aboutMenu.add(new ShowAboutAction());
        
        return menuManager;
    }

}
