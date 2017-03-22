package jface.tableholder.view;

import java.util.Arrays;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Listener;

public class TableSashForm extends SashForm {
    
    public TableSashForm(Composite parent, int style) {
        super(parent, style);
    }
    
    
    @Override
    public void dispose () {
        
        List<Listener> listeners = Arrays.asList(this.getListeners(SWT.Selection));
        for (Listener listener: listeners) {
            this.removeListener(SWT.Selection, listener);
        }
        
        super.dispose();
    }

}
