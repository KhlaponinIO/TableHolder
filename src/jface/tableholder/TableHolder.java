package jface.tableholder;

import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;

import jface.tableholder.view.EditPartCreator;
import jface.tableholder.view.TableCreator;


public class TableHolder extends ApplicationWindow {

    public TableHolder() {
        super(null);
    }

    @Override
    protected Control createContents(Composite parent) {

        getShell().setText("JFace homework log");
        getShell().setMinimumSize(600, 300);

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
    
    private void layoutsSetting(Composite parent) {
        
        Composite composite = new Composite(parent, SWT.NONE);
        composite.setLayout(new FillLayout());
        
        
        SashForm form = new SashForm(composite, SWT.HORIZONTAL);
        
        
        TableCreator tableCreator = new TableCreator(form);
        EditPartCreator editPart = new EditPartCreator(form);
        
    }

}
