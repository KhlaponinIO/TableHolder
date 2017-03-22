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
import jface.tableholder.view.actions.CopyRowAction;
import jface.tableholder.view.actions.DeleteRowAction;
import jface.tableholder.view.actions.PasteRowAction;
import jface.tableholder.view.actions.SaveAsFileAction;
import jface.tableholder.view.actions.SaveFileAction;
import jface.tableholder.view.actions.ShowAboutAction;

/* TODO:
 * 1. add dispose() method
 * 2. add JSON and XML files storage support - done for JSON
 * 3. add javadocs
 */
public class TableHolder extends ApplicationWindow {
    
    private TableCreator tableCreator;
    
    private SaveFileAction saveFileAction;
    private SaveAsFileAction saveAsFileAction;
    private AddNewRowAction addNewRowAction;
    private CopyRowAction copyRowAction;
    private PasteRowAction pasteRowAction;
    private DeleteRowAction deleteRowAction;
    private CancelAction cancelAction;
    
    public TableHolder() {
        super(null);
        addMenuBar();
    }

    @Override
    protected Control createContents(Composite parent) {

        getShell().setText("JFace homework log");
        getShell().setMinimumSize(800, 300);
        layoutsSetting(parent);
        
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
        
        tableCreator = new TableCreator(form);
        EditPartCreator editPart = new EditPartCreator(form, tableCreator);
        setTableCreatorInActions(tableCreator);
        
    }
    
    protected MenuManager createMenuManager() {
        MenuManager menuManager = new MenuManager();
        MenuManager fileMenu = new MenuManager("&File");
        menuManager.add(fileMenu);
        initActions();
        fileMenu.add(saveFileAction);
        fileMenu.add(saveAsFileAction);
        
        MenuManager editMenu = new MenuManager("&Edit");
        menuManager.add(editMenu);
        editMenu.add(addNewRowAction);
        editMenu.add(copyRowAction);
        editMenu.add(pasteRowAction);
        editMenu.add(deleteRowAction);
        editMenu.add(cancelAction);
        
        MenuManager aboutMenu = new MenuManager("&Help");
        menuManager.add(aboutMenu);
        aboutMenu.add(new ShowAboutAction());
        
        return menuManager;
    }
    
    private void initActions() {
        saveFileAction = new SaveFileAction();
        saveAsFileAction = new SaveAsFileAction();
        addNewRowAction = new AddNewRowAction();
        copyRowAction = new CopyRowAction();
        pasteRowAction = new PasteRowAction();
        deleteRowAction = new DeleteRowAction();
        cancelAction = new CancelAction();
    }
    
    private void setTableCreatorInActions(TableCreator tableCreator) {
        addNewRowAction.setTableCreator(tableCreator);
        copyRowAction.setTableCreator(tableCreator);
        pasteRowAction.setTableCreator(tableCreator);
        deleteRowAction.setTableCreator(tableCreator);
        cancelAction.setTableCreator(tableCreator);
    }

}
