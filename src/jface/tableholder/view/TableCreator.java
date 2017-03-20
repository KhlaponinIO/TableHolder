package jface.tableholder.view;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

import jface.tableholder.model.ArrayDataProvider;
import jface.tableholder.model.DataProvider;
import jface.tableholder.model.TableData;

public class TableCreator {
    
    private TableViewer tableViewer;
    private DataProvider data;

    public TableCreator(Composite parent) {
        // initialization
        data = ArrayDataProvider.getInstance();
        buildAndLayoutTable(parent);
    }

    private void buildAndLayoutTable(Composite parent) {
        
        tableViewer = new TableViewer(parent,
                SWT.MULTI | SWT.V_SCROLL | SWT.H_SCROLL | SWT.FULL_SELECTION | SWT.BORDER);

        createColumns(parent, tableViewer);
        
        final Table table = tableViewer.getTable();
        table.setHeaderVisible(true);
        table.setLinesVisible(true);
        
        tableViewer.setContentProvider(new ArrayContentProvider());
        tableViewer.setInput(data.getData());
        
    }
    
    private void createColumns(Composite parent, TableViewer viewer) {
        
        TableViewerColumn column1 = createTableViewerColumn("Name", 200, 0);
        column1.setLabelProvider(new ColumnLabelProvider() {
            @Override
            public String getText(Object element) {
                TableData data = (TableData) element;
                return data.getName();
            }
        });
        
        TableViewerColumn column2 = createTableViewerColumn("Group", 100, 1);
        column2.setLabelProvider(new ColumnLabelProvider() {
            @Override
            public String getText(Object element) {
                TableData data = (TableData) element;
                return data.getGroup();
            }
        });
        
        TableViewerColumn column3 = createTableViewerColumn("SWT done", 100, 2);
        column3.setLabelProvider(new ColumnLabelProvider() {
            @Override
            public String getText(Object element) {
                TableData data = (TableData) element;
                return String.valueOf(data.isDone());
            }
        });
        
    }
    
    private TableViewerColumn createTableViewerColumn(String title, int bound, int colNumber) {
        
        TableViewerColumn viewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
        
        TableColumn column = viewerColumn.getColumn();
        column.setText(title);
        column.setWidth(bound);
        column.setResizable(true);
        column.setMoveable(true);
        
        return viewerColumn;
    }
    
    
}
