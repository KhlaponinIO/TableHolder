package jface.tableholder.view;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TextCellEditor;

import jface.tableholder.model.TableData;

public class NameEditingSupport extends EditingSupport {
    
    private TableViewer viewer;
    private CellEditor editor;

    public NameEditingSupport(TableViewer viewer) {
        super(viewer);
        this.viewer = viewer;
        this.editor = new TextCellEditor(viewer.getTable());
    }

    @Override
    protected CellEditor getCellEditor(Object element) {
        return editor;
    }

    @Override
    protected boolean canEdit(Object element) {
        return true;
    }

    @Override
    protected Object getValue(Object element) {
        return ((TableData) element).getName();
    }

    @Override
    protected void setValue(Object element, Object value) {
        ((TableData) element).setName(String.valueOf(value));
        viewer.update(element, null);
    }

}
