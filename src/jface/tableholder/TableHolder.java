package jface.tableholder;

import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;

import jface.tableholder.view.TableCreator;
import jface.tableholder.view.TableSashForm;
import jface.tableholder.view.actions.AddNewRowAction;
import jface.tableholder.view.actions.CopyRowAction;
import jface.tableholder.view.actions.DeleteRowAction;
import jface.tableholder.view.actions.ExitAction;
import jface.tableholder.view.actions.OpenFileAction;
import jface.tableholder.view.actions.PasteRowAction;
import jface.tableholder.view.actions.SaveAsFileAction;
import jface.tableholder.view.actions.SaveFileAction;
import jface.tableholder.view.actions.ShowAboutAction;

/* TODO:
 * 1. add XML files storage support 
 * 2. add javadocs
 * 4. change row event listener
 */
public class TableHolder extends ApplicationWindow {
    
    private TableCreator tableCreator;
    
    private SaveFileAction saveFileAction;
    private SaveAsFileAction saveAsFileAction;
    private AddNewRowAction addNewRowAction;
    private CopyRowAction copyRowAction;
    private PasteRowAction pasteRowAction;
    private DeleteRowAction deleteRowAction;
    private ExitAction exitAction;
    private OpenFileAction openFileAction;
    
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
    
    private void layoutsSetting(Composite parent) {
        
        Composite composite = new Composite(parent, SWT.NONE);
        composite.setLayout(new FillLayout());
        
        TableSashForm form = new TableSashForm(composite, SWT.HORIZONTAL);
        
        tableCreator = new TableCreator(form);
        setTableCreatorInActions(tableCreator);
        
    }
    
    protected MenuManager createMenuManager() {
        MenuManager menuManager = new MenuManager();
        MenuManager fileMenu = new MenuManager("&File");
        menuManager.add(fileMenu);
        initActions();
        fileMenu.add(saveFileAction);
        fileMenu.add(saveAsFileAction);
        fileMenu.add(openFileAction);
        fileMenu.add(exitAction);
        
        MenuManager editMenu = new MenuManager("&Edit");
        menuManager.add(editMenu);
        editMenu.add(addNewRowAction);
        editMenu.add(copyRowAction);
        editMenu.add(pasteRowAction);
        editMenu.add(deleteRowAction);
        
        MenuManager aboutMenu = new MenuManager("&Help");
        menuManager.add(aboutMenu);
        aboutMenu.add(new ShowAboutAction());
        
        return menuManager;
    }
    
    private void initActions() {
        saveFileAction = new SaveFileAction();
        saveAsFileAction = new SaveAsFileAction();
        openFileAction = new OpenFileAction();
        exitAction = new ExitAction(this);
        addNewRowAction = new AddNewRowAction();
        copyRowAction = new CopyRowAction();
        pasteRowAction = new PasteRowAction();
        deleteRowAction = new DeleteRowAction();
    }
    
    private void setTableCreatorInActions(TableCreator tableCreator) {
        addNewRowAction.setTableCreator(tableCreator);
        copyRowAction.setTableCreator(tableCreator);
        pasteRowAction.setTableCreator(tableCreator);
        deleteRowAction.setTableCreator(tableCreator);
        openFileAction.setTableCreator(tableCreator);
    }

}
