package com.tps.universal.ui;

import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

public class AutoSizingTextTable extends JTable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -447363980063770320L;
	
	private int minWidth;
	
	private int maxWidth;
	
	private int scope;
	
	private int hight;
	
	private boolean initialized = false;

	public AutoSizingTextTable(int minWidth, int maxWidth,
			int scope, int hight) {
		super();
		setAutoResizeMode(AUTO_RESIZE_OFF);
		this.minWidth = minWidth;
		this.maxWidth = maxWidth;
		this.scope = scope;
		this.hight = hight;
		this.initialized = true;
	}
	
	@Override
	public void setModel(TableModel paramTableModel) {
		super.setModel(paramTableModel);
	}
	
	public void tableChanged(TableModelEvent paramTableModelEvent) {
		super.tableChanged(paramTableModelEvent);
		setTableSize();
	}
	
	private void setTableSize() {
		if (!initialized) {
			return;
		}
		
		this.setRowHeight(hight);
		
		TableColumnModel columnModel = this.getColumnModel();
		for (int i = 0; i < columnModel.getColumnCount(); i++) {
			TableColumn column = columnModel.getColumn(i);
			
			int preferredWidth = (int) this.getTableHeader().getDefaultRenderer()
	                 .getTableCellRendererComponent(this, column.getIdentifier()
	                         , false, false, -1, i).getPreferredSize().getWidth();
			
			for (int j = 0; j < this.getModel().getRowCount(); j++) {
				int width = (int)this.getCellRenderer(j, i).getTableCellRendererComponent(this,
			               this.getValueAt(j, i), false, false, j, i).getPreferredSize().getWidth();
				if (width > preferredWidth) {
					preferredWidth = width;
				}
			}
			
			column.setMaxWidth(maxWidth * scope);
			column.setMinWidth(minWidth * scope);
			column.setPreferredWidth(preferredWidth + this.getIntercellSpacing().width + 2);
		}
	}

}
