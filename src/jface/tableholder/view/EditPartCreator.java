package jface.tableholder.view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;


public class EditPartCreator {

    private Text nameTextField;
    private Text groupTextField;
    private Button checkTaskButton;

    private TableCreator tableCreator;

    private Button newButton;
    private Button saveButton;
    private Button deleteButton;
    private Button cancelButton;

    public EditPartCreator(Composite parent) {
        initUI(parent);
    }

    public EditPartCreator(Composite parent, TableCreator tableCreator) {
        this.tableCreator = tableCreator;
        initUI(parent);
    }

    private void initUI(Composite parent) {

        createFields(parent);
        tableCreator.addRowSelectionEvent(nameTextField, groupTextField, checkTaskButton);
    }

    private void createFields(Composite parent) {

        Composite composite = new Composite(parent, SWT.NONE);
        GridLayout grid = new GridLayout(4, false);
        composite.setLayout(grid);

        Label name = new Label(composite, SWT.LEFT);
        name.setText("Name:");
        GridData nameGridData = new GridData(SWT.BEGINNING, SWT.BEGINNING, true, true);
        name.setLayoutData(nameGridData);

        nameTextField = new Text(composite, SWT.SINGLE | SWT.BORDER | SWT.RIGHT);
        GridData nameTextFieldData = new GridData(SWT.FILL, SWT.BEGINNING, true, true);
        nameTextFieldData.horizontalAlignment = GridData.FILL;
        nameTextFieldData.horizontalSpan = 3;
        nameTextField.setLayoutData(nameTextFieldData);

        Label group = new Label(composite, SWT.LEFT);
        group.setText("Group:");
        GridData groupGridData = new GridData(SWT.FILL, SWT.BEGINNING, true, true);
        group.setLayoutData(groupGridData);

        groupTextField = new Text(composite, SWT.SINGLE | SWT.BORDER | SWT.RIGHT);
        GridData groupTextFieldData = new GridData(SWT.BEGINNING, SWT.BEGINNING, true, true);
        groupTextFieldData.horizontalAlignment = GridData.FILL;
        groupTextFieldData.horizontalSpan = 3;
        groupTextField.setLayoutData(groupTextFieldData);

        Label task = new Label(composite, SWT.LEFT);
        task.setText("SWT task done");
        GridData taskGridData = new GridData(SWT.BEGINNING, SWT.BEGINNING, true, true);
        taskGridData.horizontalAlignment = GridData.FILL;
        taskGridData.horizontalSpan = 3;
        task.setLayoutData(taskGridData);

        checkTaskButton = new Button(composite, SWT.CHECK);
        GridData checkTaskButtonGrid = new GridData(SWT.RIGHT, SWT.BEGINNING, true, true);
        checkTaskButtonGrid.horizontalSpan = 1;
        checkTaskButton.setLayoutData(checkTaskButtonGrid);

        addButtons(composite);
        addButtonsListeners();
    }

    private void addButtons(Composite parent) {

        newButton = new Button(parent, SWT.PUSH);
        newButton.setText("New");
        newButton.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, true));

        saveButton = new Button(parent, SWT.PUSH);
        saveButton.setText("Save");
        saveButton.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, true));

        deleteButton = new Button(parent, SWT.PUSH);
        deleteButton.setText("Delete");
        deleteButton.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, true));

        cancelButton = new Button(parent, SWT.PUSH);
        cancelButton.setText("Cancel");
        cancelButton.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, true));
    }

    public void addButtonsListeners() {
        newButton.addListener(SWT.Selection, event -> {
            tableCreator.addNewRow();
        });

        saveButton.addListener(SWT.Selection, event -> {
            tableCreator.updateRow(nameTextField.getText(), groupTextField.getText(),
                    checkTaskButton.getSelection());
        });

        deleteButton.addListener(SWT.Selection, event -> {
            tableCreator.deleteRow();
        });

        cancelButton.addListener(SWT.Selection, event -> {
            tableCreator.cancel(nameTextField, groupTextField, checkTaskButton);
        });
    }

}
