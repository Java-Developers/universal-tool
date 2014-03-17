/**
 * 
 */
package com.tps.universal.ui;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.swing.table.AbstractTableModel;

/**
 * @author cy20494
 *
 */
public class ResultSetTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 3757406450694293520L;
	
	private String columnNames[];
	
	private List<Map<String, Object>> rowData;

	public void setResultSet(ResultSet resultSet) {
		try {
			int columnCount = resultSet.getMetaData().getColumnCount();
			columnNames = new String[columnCount];
			rowData = new ArrayList<Map<String, Object>>();
			for (int i = 0; i < columnCount; i++) {
				columnNames[i] = resultSet.getMetaData().getColumnLabel(i);
			}
			while (resultSet.next()) {
				Map<String, Object> map = new HashMap<String, Object>();
				for (int i = 0; i < columnCount; i++) {
					map.put(columnNames[i], resultSet.getObject(i));
				}
				rowData.add(map);
			}
		} catch (SQLException e) {
			throw new RuntimeException("Unable to extract metadata from result set!", e);
		}
		this.fireTableStructureChanged();
	}
	
	public void setResultSet(List<Map<String, Object>> resultSet) {
		boolean columnNamesInitialized = false;
		rowData = new ArrayList<Map<String, Object>>();
		for (Iterator<Map<String, Object>> it = resultSet.iterator(); it.hasNext();) {
			Map<String, Object> map = (Map<String, Object>) it.next();
			
			if (!columnNamesInitialized) {
				columnNames = new String[map.keySet().size()];
				int i = 0;
				for (Iterator<String> iter = map.keySet().iterator(); iter.hasNext(); i++) {
					columnNames[i] = iter.next();
				}
				columnNamesInitialized = true;
			}
			
			rowData.add(map);
		}
		this.fireTableStructureChanged();
	}
	
	public void addResultSet(List<Map<String, Object>> resultSet) {
		if (rowData.size() <= 0) {
			setResultSet(resultSet);
		} else {
			if (resultSet != null && resultSet.size() > 0) {
				if (resultSet.get(0).keySet().size() != columnNames.length) {
					throw new IllegalArgumentException("Column names does not match current table model!");
				}
				rowData.addAll(resultSet);
			}
		}
		
		this.fireTableDataChanged();
	}

	public ResultSetTableModel() {
		super();
		columnNames = new String[1];
		columnNames[0] = "Undefined";
		rowData = new ArrayList<Map<String, Object>>();
	}

	public ResultSetTableModel(ResultSet resultSet) {
		super();
		setResultSet(resultSet);
	}
	
	public ResultSetTableModel(List<Map<String, Object>> resultSet) {
		super();
		setResultSet(resultSet);
	}

	public String getColumnName(int column) {
		return columnNames[column].toString();
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return rowData.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return rowData.get(rowIndex).get(columnNames[columnIndex]);
	}
	
	@Override
	public void setValueAt(Object arg0, int arg1, int arg2) {
		// Do nothing, this is a read only table model.
	}
	
	@Override
	public boolean isCellEditable(int arg0, int arg1) {
		return true;
	}
	
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return String.class;
	}

}
