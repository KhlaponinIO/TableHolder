package jface.tableholder;

import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;

public class TableHolder extends ApplicationWindow {
	
	public TableHolder() {
		super(null);
	}
	
	@Override
	protected Control createContents(Composite parent) {
		
		// some code
		
		parent.pack();
		return parent;
	}

	public static void main(String[] args) {
		TableHolder holder = new TableHolder();
		holder.setBlockOnOpen(true);
		holder.open();
		Display.getCurrent().dispose();
	}

}
