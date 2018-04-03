package presentation;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.swing.table.DefaultTableModel;

public class CreateTableModel {
	public  DefaultTableModel getTable(ResultSet rs) throws Exception {
		DefaultTableModel defaultTableModel = new DefaultTableModel();
		ResultSetMetaData rsmd = rs.getMetaData();
		int cols = rsmd.getColumnCount();
		String c[] = new String[cols];
		for (int i = 0; i < cols; i++) {
			c[i] = rsmd.getColumnName(i + 1);
			defaultTableModel.addColumn(c[i]);
		}
		Object row[] = new Object[cols];
		while (rs.next()) {
			for (int i = 0; i < cols; i++) {
				row[i] = rs.getString(i + 1);
			}
			defaultTableModel.addRow(row);
		}
		return defaultTableModel;
	}
}
