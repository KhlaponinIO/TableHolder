package jface.tableholder.view;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TextCellEditor;

import jface.tableholder.model.TableData;

public class NameEditingSupport extends EditingSupport {
    
    private TableViewer viewer;
    private CellEditor editor;
    private EditPartCreator editPart;

    public NameEditingSupport(TableViewer viewer) {
        super(viewer);
        this.viewer = viewer;
        this.editor = new TextCellEditor(viewer.getTable());
    }
    
//    public NameEditingSupport(TableViewer viewer, EditPartCreator editPart) {
//        this(viewer);
//        this.editPart = editPart;
//    }

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
        
        //update edit part here
        editPart.getNameTextField().setText(String.valueOf(value));
        viewer.update(element, null);
    }

    public EditPartCreator getEditPart() {
        return editPart;
    }

    public void setEditPart(EditPartCreator editPart) {
        this.editPart = editPart;
    }
}
