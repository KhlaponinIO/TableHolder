package jface.tableholder.view;

import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

public class TableCreator {
    
    private final Table table;
    private TableViewer tableViewer;

    public TableCreator(Composite parent) {
        // initialization
        table = new Table(parent, SWT.FULL_SELECTION);
        tableViewer = buildAndLayoutTable(table);
    }

    private TableViewer buildAndLayoutTable(final Table parentTable) {
        
        TableViewer viewer = new TableViewer(parentTable,
                SWT.MULTI | SWT.V_SCROLL | SWT.H_SCROLL | SWT.FULL_SELECTION | SWT.BORDER);

        TableLayout layout = new TableLayout();
        layout.addColumnData(new ColumnWeightData(50, 75, true));
        layout.addColumnData(new ColumnWeightData(50, 75, true));
        layout.addColumnData(new ColumnWeightData(50, 75, true));
        table.setLayout(layout);
        
        TableColumn nameColumn = new TableColumn(parentTable, SWT.CENTER);
        nameColumn.setText("Name");
        TableColumn groupColumn = new TableColumn(parentTable, SWT.CENTER);
        groupColumn.setText("Group");
        TableColumn taskDone = new TableColumn(parentTable, SWT.CENTER);
        taskDone.setText("SWT done");
        table.setHeaderVisible(true);
        table.setLinesVisible(true);
        
        return viewer;
    }
}
