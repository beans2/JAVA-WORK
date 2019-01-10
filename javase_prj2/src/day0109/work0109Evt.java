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
		if(wv.getJtfTableName().getText().trim()==null||wv.getJtfTableName().getText().trim().equals("")) {
			JOptionPane.showMessageDialog(null, "���̺���� �Է����ּ���.");
		}else {
			tableName.append("create table ").append(getTableName).append("(");
			query = tableName;
			wv.getJtaQueryView().setText(query.toString());
			wv.getJtfTableName().setText("");
			flag = true;			
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
//			System.out.println("--"+wv.getJtfColumnName().getText().toString().trim()+"--");
			
			if(comboDataType==null) {
				JOptionPane.showMessageDialog(null, "������ ������ �ݵ�� �����ؾ��մϴ�.");
			}
			
			if(comboDataType.equals("varchar2")) {
				System.out.println("varchar2");
				if((  (Integer.parseInt(wv.getJtfDataPrecision().getText()) <0 || (Integer.parseInt(wv.getJtfDataPrecision().getText())>=22)) )) {
					JOptionPane.showMessageDialog(null, "varchar2�� ������ 0~22�Դϴ�. ");
					return;
				}
			}else if(getDataType.equals("char")) {
				if((  (Integer.parseInt(wv.getJtfDataPrecision().getText()) <0 || (Integer.parseInt(wv.getJtfDataPrecision().getText())>=2000)) )) {
					JOptionPane.showMessageDialog(null, "char�� ������ 0~2000�Դϴ�. ");
					return;
				}
			}else if(getDataType.equals("number")) {
				if((  (Integer.parseInt(wv.getJtfDataPrecision().getText()) <0 || (Integer.parseInt(wv.getJtfDataPrecision().getText())>=4000)) )) {
					JOptionPane.showMessageDialog(null, "number�� ������ 0~4000�Դϴ�. ");
					return;
				}
			}
			
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
		query=null;
	}
//////////////////////////////////////////////////////////////////
	public void CreateTable() throws SQLException{

			query.append(" )");
			Connection con = null;
			PreparedStatement pstmt =null;
			System.out.println("");
				try {
					String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
					String id = "scott";
					String pass = "tiger";
					con = GetConnetion.getInstance().getConn(url, id, pass);
					
					System.out.println(query);
					pstmt = con.prepareStatement(query.toString());
					pstmt.execute();
					JOptionPane.showMessageDialog(null, "���̺� ���� �Ϸ�!");
					
				}finally {
					if(pstmt!= null) {pstmt.close();}
					if(con!=null) {con.close();}
				}//end finally

			
		}// CreateTable
////////////////////////////////////////////////////////////
	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == wv.getBtnAddTableName()) {
			addTableName();
		}
		if (ae.getSource() == wv.getBtnAddEtc()) {
			try {
				if(wv.getJtfColumnName().getText().trim()==null||wv.getJtfColumnName().getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "�÷����� �ʼ��Դϴ�.");
					return;
				}
				if(comboDataType==null||comboDataType.equals("")) {
					JOptionPane.showMessageDialog(null, "������ Ÿ���� �������ּ���.");
				}else
				if(wv.getJtfDataPrecision().getText().trim()==null||wv.getJtfDataPrecision().getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "������ ũ�⸦ �Է��ϼ���.");
				}else
//				if(!(wv.getJtfConstraintsName().getText().trim().equals("null"))) {
//					JOptionPane.showMessageDialog(null, "��������� null�� �ϰڽ��ϱ�?");
//				}
			addColumn();
			}catch(NumberFormatException nfe) {
				if(!(wv.getJtfDataPrecision().getText().trim()==null||wv.getJtfDataPrecision().getText().trim().equals(""))) {
					JOptionPane.showMessageDialog(null, "������ũ��� �ݵ�� ���������̾�� �մϴ�.");					
				}
			}catch(NullPointerException npe) {
//				JOptionPane.showMessageDialog(null, "��������� null�� �����Ͻðڽ��ϱ�?");
			}
		}
		if (ae.getSource() == wv.getBtnClearAll()) {
			if(query==null) {
				JOptionPane.showMessageDialog(null, "�ʱ�ȭ�� �����Դϴ�.");
			}
			clearAll();
		}
		if (ae.getSource() == wv.getBtnCreateTable()) {
			try {
				if(query.toString()==null||query.toString().equals("")) {
					JOptionPane.showMessageDialog(null, "�������� �ϼ��� �� ���̺��� �����ϼ���.");
				}else if(query.toString().substring(query.toString().length()-1).equals("(")) {
					JOptionPane.showMessageDialog(null, "�÷��� ������ �ϼ� �� �� ���̺��� �����ϼ���.");
				}else {
					CreateTable();					
				}
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "���� �̸��� ���̺��� �̹� �����մϴ�.");
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
