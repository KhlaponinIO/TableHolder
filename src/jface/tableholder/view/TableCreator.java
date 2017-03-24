package jface.tableholder.view;

import java.util.ResourceBundle;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;

import jface.tableholder.model.TableData;
import jface.tableholder.service.TableDataService;
import jface.tableholder.util.PackageUtil;

public class TableCreator {

    private TableViewer tableViewer;
    private TableDataService dataService;
    private EditPartCreator editPart;

    private NameEditingSupport nameEditingSupport;

    private ResourceBundle rb;
    private final String FIRST_COLUMN_NAME;
    private final String SECOND_COLUMN_NAME;
    private final String THIRD_COLUMN_NAME;
    private final String CHANGES_TITLE;
    private final String CHANGES_MESSAGE;

    {
        rb = ResourceBundle.getBundle(PackageUtil.getPackageName(this.getClass()) + ".elementsNames");
        FIRST_COLUMN_NAME = rb.getString("TableCreator.first.column.name");
        SECOND_COLUMN_NAME = rb.getString("TableCreator.second.column.name");
        THIRD_COLUMN_NAME = rb.getString("TableCreator.third.column.name");
        CHANGES_TITLE = rb.getString("TableCreator.changes.title");
        CHANGES_MESSAGE = rb.getString("TableCreator.changes.message");
    }

    public TableCreator(Composite parent) {
        // initialization
        dataService = new TableDataService();
        buildAndLayoutTable(parent);
        editPart = new EditPartCreator(parent, this);
        nameEditingSupport.setEditPart(editPart);
    }

    public EditPartCreator getEditPart() {
        return editPart;
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

        TableViewerColumn column1 = createTableViewerColumn(FIRST_COLUMN_NAME, 200, 0);
        nameEditingSupport = new NameEditingSupport(tableViewer);
        column1.setEditingSupport(nameEditingSupport);
        column1.setLabelProvider(new ColumnLabelProvider() {
            @Override
            public String getText(Object element) {
                TableData data = (TableData) element;
                return data.getName();
            }
        });

        TableViewerColumn column2 = createTableViewerColumn(SECOND_COLUMN_NAME, 100, 1);
        column2.setLabelProvider(new ColumnLabelProvider() {
            @Override
            public String getText(Object element) {
                TableData data = (TableData) element;
                return data.getGroup();
            }
        });

        TableViewerColumn column3 = createTableViewerColumn(THIRD_COLUMN_NAME, 100, 2);
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
                // checking of previous row changing
                if (editPart.isPreviousRowChanged()) {
                    if (MessageDialog.openQuestion(null, CHANGES_TITLE, CHANGES_MESSAGE)) {
                        dataService.updateRow(editPart.getPreviousIndex(), dataService.getUpdatedRow());
                        refreshViewer();
                    } else {
                        editPart.getNameTextField().setText(dataService.getPreviousRow().getName());
                        editPart.getGroupTextField().setText(dataService.getPreviousRow().getGroup());
                        editPart.getCheckTaskButton().setSelection(dataService.getPreviousRow().isDone());
                    }
                }

                IStructuredSelection selection = (IStructuredSelection) event.getSelection();
                showRowDataOnEditBar(selection, nameTextField, groupTextField, checkTaskButton);

                // set previous row parameters
                dataService.setPreviousRow(
                        new TableData(nameTextField.getText(), groupTextField.getText(), checkTaskButton.isEnabled()));
                editPart.setPreviousRowIsChanged(false);
                editPart.setPreviousIndex(tableViewer.getTable().getSelectionIndex());
            }
        });
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

    public void addNewRow() {
        dataService.addRow("-update me-", "0", false);
        refreshViewer();
    }

    public void deleteRow() {
        int index = tableViewer.getTable().getSelectionIndex();
        if (index < 0) {
            return;
        }
        dataService.deleteRow(index);
        refreshViewer();
    }

    public void updateRow(String name, String group, boolean isDone) {
        TableData rowData = new TableData(name, group, isDone);
        int index = tableViewer.getTable().getSelectionIndex();
        dataService.updateRow(index, rowData);
        refreshViewer();
    }

    public void cancel(Text name, Text group, Button isDone) {
        if (getSelectedRow() != null) {
            name.setText(getSelectedRow().getName());
            group.setText(getSelectedRow().getGroup());
            isDone.setSelection(getSelectedRow().isDone());
            refreshViewer();
        }
    }

    public void copyRow() {
        int index = tableViewer.getTable().getSelectionIndex();
        if (index >= 0) {
            TableData clipboardData = dataService.getRow(index);
            dataService.copyRow(clipboardData);
        }
    }

    public TableData getSelectedRow() {
        return dataService.getRow(tableViewer.getTable().getSelectionIndex());
    }

    public void pasteRow() {

        dataService.pasteRow();
        refreshViewer();
    }

    public void setSelectionListenerOnTheTable(Action copyAction, Action pasteAction, Action deleteAction) {
        tableViewer.getTable().addSelectionListener(new SelectionListener() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                copyAction.setEnabled(true);
                deleteAction.setEnabled(true);
            }

            @Override
            public void widgetDefaultSelected(SelectionEvent e) {
                // do nothing
            }
            
        });
    }

}
