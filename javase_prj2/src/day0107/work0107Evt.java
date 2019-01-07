package day0107;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class work0107Evt extends WindowAdapter implements ActionListener, ItemListener {
	private work0107View wk;
	private String comboSelect;

	public work0107Evt() {
	}

	public work0107Evt(work0107View wk) {
		this.wk = wk;
	}

	private void searchColumn() throws SQLException{
		clearAll();
		// 1.드라이버 로딩
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// 2. connection 얻기
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
			String id = "scott";
			String pass = "tiger";
			con = DriverManager.getConnection(url, id, pass);
			// 3. 쿼리문 수행 객체얻기
			stmt = con.createStatement();
			// 4. 쿼리문 수행 후 결과얻기
			StringBuilder sb = new StringBuilder();
			sb.append("select column_name from user_tab_cols where table_name='").append(comboSelect).append("'");

			rs = stmt.executeQuery(sb.toString());
			while (rs.next()) {
//				System.out.println(rs.getString("column_name"));
				String[] rowData = { rs.getString("column_name") };
				wk.getDtmSelect().addRow(rowData);
			}

		} finally {
			// 5. 연결끊기
		}
	}

	@Override
	public void windowClosing(WindowEvent e) {
		wk.dispose();
	}

	@Override
	public void windowClosed(WindowEvent e) {
		System.exit(0);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == wk.getJbnSelect()) {
			String[] rowData = { comboSelect };
			wk.getDtmSelect().addRow(rowData);
		}
		try {
			searchColumn();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void itemStateChanged(ItemEvent we) {
//		System.out.println(wk.getJcbTable().getSelectedItem());
		comboSelect = wk.getJcbTable().getSelectedItem().toString();
		System.out.println(comboSelect);
		
	}
	public void clearAll() {
		for (int i = 0; i < wk.getDtmSelect().getRowCount(); i++) {
			wk.getDtmSelect().removeRow(i);
		}
	}

}
