package day0109;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import kr.co.sist.connection.GetConnetion;

public class work0109Evt extends WindowAdapter implements ActionListener, ItemListener {
	private work0109View wv;
	private String comboDataType;
	private String comboDataConstraints;
	private StringBuilder query = new StringBuilder();
	private String getTableName;
	private boolean flag;

	public work0109Evt(work0109View wv) {
		this.wv = wv;
	}

	public void addTableName() {
		StringBuilder tableName = new StringBuilder();
		getTableName = wv.getJtfTableName().getText();
		if((wv.getJtfTableName().getText()!=null)||wv.getJtfTableName().getText().equals("")) {
			tableName.append("create table ").append(getTableName).append("(");
			query = tableName;
			wv.getJtaQueryView().setText(query.toString());
			wv.getJtfTableName().setText("");
			flag = true;			
		}else {
			JOptionPane.showMessageDialog(null, "테이블명을 입력해주세요.");
		}
	}

	public void addColumn() {
		
		String getColumnName = wv.getJtfColumnName().getText();
		int getDataPrecision = Integer.parseInt(wv.getJtfDataPrecision().getText());
		String getConstraintName = wv.getJtfConstraintsName().getText();
		String getDataType = comboDataType;
		String getConsrtaintType = comboDataConstraints;
		StringBuilder etcNameType = new StringBuilder();
		if (flag) {
			etcNameType.append("\n ").append(getColumnName).append(" ").append(getDataType);
			if(!comboDataType.equals("date")) {
				etcNameType.append("(").append(getDataPrecision).append(") ");
			}
			if(comboDataConstraints.equals("primary key")) {
				etcNameType.append("constraint ");		
			}
			
			etcNameType.append(getConstraintName).append(" ").append(getConsrtaintType);	
			flag = false;
		} else {
			etcNameType.append(",\n ").append(getColumnName).append(" ").append(getDataType);
			if(!comboDataType.equals("date")) {
				etcNameType.append("(").append(getDataPrecision).append(") ");
			}
			if(comboDataConstraints.equals("primary key")) {
				etcNameType.append("constraint ");		
			}
			etcNameType.append(getConstraintName).append(" ").append(getConsrtaintType);	
		}

		query.append(etcNameType);
		wv.getJtaQueryView().setText(query.toString());
		wv.getJtaQueryView().append(" );");

	}

	public void clearAll() {
//		wv.getJtfColumnName().setText("");
//		wv.getJtfConstraintsName().setText("");
//		wv.getJcbDataType().setSelectedIndex(0);
//		wv.getJcbConstraints().setSelectedIndex(0);
//		wv.getJtfConstraintsName().setText("");
//		wv.getJtfDataPrecision().setText("");
		wv.getJtaQueryView().setText("");
		wv.getJtfTableName().requestFocus();
	}
//////////////////////////////////////////////////////////////////
	public void CreateTable() throws SQLException{
			query.append(" )");
			Connection con = null;
			PreparedStatement pstmt =null;
			
			try {
					String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
					String id = "scott";
					String pass = "tiger";
					con = GetConnetion.getInstance().getConn(url, id, pass);
					
					System.out.println(query);
					pstmt = con.prepareStatement(query.toString());
					pstmt.execute();
					JOptionPane.showMessageDialog(null, "테이블 생성 완료!");
	
			}finally {
				if(pstmt!= null) {pstmt.close();}
				if(con!=null) {con.close();}
			}
		}// CreateTable
////////////////////////////////////////////////////////////
	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == wv.getBtnAddTableName()) {
			addTableName();
		}
		if (ae.getSource() == wv.getBtnAddEtc()) {
			addColumn();
		}
		if (ae.getSource() == wv.getBtnClearAll()) {
			clearAll();
		}
		if (ae.getSource() == wv.getBtnCreateTable()) {
			try {
				CreateTable();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void windowClosing(WindowEvent we) {
		wv.dispose();
	}

	@Override
	public void windowClosed(WindowEvent we) {
		System.exit(0);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == wv.getJcbDataType()) {
			comboDataType = wv.getJcbDataType().getItemAt(wv.getJcbDataType().getSelectedIndex());
		}
		if (e.getSource() == wv.getJcbConstraints()) {
			comboDataConstraints = wv.getJcbConstraints().getItemAt(wv.getJcbConstraints().getSelectedIndex());
		}
	}

}
