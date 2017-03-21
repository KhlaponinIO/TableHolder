package jface.tableholder.view;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;

import jface.tableholder.model.TableData;
import jface.tableholder.service.TableDataService;

public class TableCreator {

    private TableViewer tableViewer;
    private TableDataService dataService;

    public TableCreator(Composite parent) {
        // initialization
        dataService = new TableDataService();
        buildAndLayoutTable(parent);
    }

    private void buildAndLayoutTable(Composite parent) {

        tableViewer = new TableViewer(parent, SWT.V_SCROLL | SWT.H_SCROLL | SWT.FULL_SELECTION | SWT.BORDER);

        createColumns(parent, tableViewer);

        final Table table = tableViewer.getTable();
        table.setHeaderVisible(true);
        table.setLinesVisible(true);

        tableViewer.setContentProvider(new ArrayContentProvider());
        tableViewer.setInput(dataService.getData());

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

    public void addRowSelectionEvent(Text nameTextField, Text groupTextField, Button checkTaskButton) {
        tableViewer.addSelectionChangedListener(new ISelectionChangedListener() {

            @Override
            public void selectionChanged(final SelectionChangedEvent event) {
                IStructuredSelection selection = (IStructuredSelection) event.getSelection();
                showRowDataOnEditBar(selection, nameTextField, groupTextField, checkTaskButton);
            }
        });
    }

    public void focusOnFirstRow(Event event) {

    }

    private void showRowDataOnEditBar(IStructuredSelection selection, Text nameTextField, Text groupTextField,
            Button checkTaskButton) {
        TableData rowData = (TableData) selection.getFirstElement();
        if (rowData == null) {
            nameTextField.setText("");
            groupTextField.setText("");
            checkTaskButton.setSelection(false);
        } else {
            nameTextField.setText(rowData.getName());
            groupTextField.setText(rowData.getGroup());
            checkTaskButton.setSelection(rowData.isDone());
        }
    }

    public TableViewer getTableViewer() {
        return tableViewer;
    }

    public void refreshViewer() {
        tableViewer.refresh();
    }

}
