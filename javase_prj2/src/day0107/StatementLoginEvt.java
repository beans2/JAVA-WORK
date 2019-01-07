package day0107;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class StatementLoginEvt extends WindowAdapter implements ActionListener {
	private StatementLogin sl;

	public StatementLoginEvt(StatementLogin sl) {
		this.sl = sl;
	}

	@Override
	public void windowClosing(WindowEvent we) {
		sl.dispose();
	}// windowClosing

	public boolean chkNull(String id, String pass) {
		boolean flag = false;
		try {
		if(id.equals("")) {
			JOptionPane.showMessageDialog(sl,"���̵�� �ʼ� �Է�");
			sl.getJtfId().requestFocus();
			flag= true;
			//���ܸ� ������ �߻�  :throw new ����ó�� Ŭ������();
			throw new LoginException();
		}//end if
		if(pass.equals("")) {
			JOptionPane.showMessageDialog(sl,"��й�ȣ�� �ʼ� �Է�");
			sl.getJptPass().requestFocus();
			flag= true;
		}//end if
		}catch(LoginException le) {
			le.printStackTrace();
		}
		return !flag;
	}// chkNull

	public String login(String id, String pass) throws SQLException{
		String name = "";
		//1. ����̹��ε�
		try {
			Class.forName("orcla.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Connection con =null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
		//2. Connection���
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
			String dbo_id ="scott";
			String dbo_pass="tiger";
			con = DriverManager.getConnection(url, dbo_id, dbo_pass);
		//3. ������ ������ü���
			stmt = con.createStatement();
		//4. ���������� �� ��� ���
			StringBuilder selectName = new StringBuilder();
			selectName.append("select name ") 
			.append("from test_login ")
			.append(" where id ='").append(blockSqlInjection(id)).append("' and ")
			.append(" pass ='").append(blockSqlInjection(pass)).append("'");
			//������: select name from test_login where id='id' and pass ='pass'
			
			rs = stmt.executeQuery(selectName.toString());
			if(rs.next()) {//�Էµ� ���̵�� ��й�ȣ�� �´� �̸��� ���� =>�α��μ���
				name = rs.getString("name");
			}//end if
		//5. ���� ����
		}finally {
			if(rs !=null) {rs.close();}
			if(stmt!=null) {stmt.close();}
			if(con !=null) {con.close();}
		}
		
		return name;
	}//login
	
	public String blockSqlInjection(String data) {
		return data.replace(" ","").replaceAll("'","").replaceAll("--", "");
	}//blockSqlInjection
	
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == sl.getJtfId() || ae.getSource() == sl.getJptPass()
				|| ae.getSource() == sl.getJbtLogin()) {
			String id= sl.getJtfId().getText().trim();
			String pass = new String(sl.getJptPass().getPassword()).trim();
			if(chkNull(id, pass)) {
					
				try {
					String name =login(id,pass);
					if(name.isEmpty()) {
						JOptionPane.showMessageDialog(sl, "���̵� ��й�ȣ�� Ȯ�����ּ���.");
						sl.getJtfId().setText("");
						sl.getJptPass().setText("");
						sl.getJtfId().requestFocus();
						return;
					}//end if
					
					JDialog jd = new JDialog(sl, "�α��� ����", true);
					jd.add(new JLabel(name+"�� �α��� �ϼ̽��ϴ�."));
					jd.setBounds(sl.getX()+100,sl.getY()+100,300,200);
					jd.setVisible(true);
					jd.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(sl, "DB �۾� �� ������ �߻��Ͽ����ϴ�.");
					e.printStackTrace();
				}
			}//end if
		}
		if (ae.getSource() == sl.getJbtCancel()) {
			sl.getJtfId().setText("");
			sl.getJptPass().setText("");
			sl.getJtfId().requestFocus();
		}
	}// actionPerformed

}// class
