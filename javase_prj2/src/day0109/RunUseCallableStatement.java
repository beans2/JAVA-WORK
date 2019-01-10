package day0109;

import java.awt.Font;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

import day0107.CpEmp2AllVO;
import day0107.CpEmp2OneVO;
import day0107.CpEmp2VO;
import day0110.TestProcAllVO;
import day0110.TestProcOneVO;
import day0110.TestProcUpdateVO;
import day1221.test;

public class RunUseCallableStatement {

	public void addTestProc() {
		String tempData = JOptionPane.showInputDialog("������� �߰�\n�Է� ��) �����ȣ,�����,����,����");
		if (tempData != null && !tempData.equals("")) {
			String[] data = tempData.split(",");

			if (data.length != 4) {
				JOptionPane.showMessageDialog(null, "�Է������� Ȯ���� �ּ���.");
				return;
			} // end if

			int empno = 0, sal = 0;
			String ename = "", job = "";

			try {
				empno = Integer.parseInt(data[0]);
				ename = data[1].trim();
				sal = Integer.parseInt(data[2].trim());
				job = data[3].trim();

			} catch (NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null, "�����ȣ�� ������ ���� �Դϴ�.");
				return;
			} // end catch

			// ó���� �Էµ����͸� VO�� �����ϰ�
			TestProcVO tpvo = new TestProcVO(empno, sal, ename, job);

			// VO�� ���� DB�� insert�Ѵ�
			try {
				String msg = "";
				msg = UseCallableStatementDAO.getInstance().insertProc(tpvo);
				JOptionPane.showMessageDialog(null, msg);
			} catch (SQLException se) { // ����
				JOptionPane.showMessageDialog(null, "DBMS�� ����� �����߻�");
			} // end catch

		} // end if
	}// addTestProc

	public  void modifyTestProc() {
		String tempData = JOptionPane.showInputDialog("������� ����\n�����ȣ�� ��ġ�ϴ� ������ ������ �����մϴ�\n �Է� ��) �����ȣ,����,����");
		if(tempData != null && !tempData.equals("")) {
			String [] data=tempData.split(",");
			if(data.length != 3) {
				JOptionPane.showMessageDialog(null, "�Է������� Ȯ���� �ּ���.");
				return;
			}//end if
			
			int empno=0,sal =0;
			String job ="";
			
			try {
				empno = Integer.parseInt(data[0]);
				job =data[1].trim();
				sal=Integer.parseInt(data[2]);
				
			}catch( NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null, "�����ȣ�� ������ ���� �Դϴ�.");
				return;
			}//end catch
			
			//ó���� �Էµ����͸� VO�� �����ϰ�
			TestProcUpdateVO tpuvo= new TestProcUpdateVO(empno,sal,job);
			//VO�� ���� DB�� insert�Ѵ�
			try {
				String msg="";
				msg = UseCallableStatementDAO.getInstance().updateProc(tpuvo);
				JOptionPane.showMessageDialog(null, msg);
			}catch(SQLException se) { //���� 
					JOptionPane.showMessageDialog(null, "�˼��մϴ�����Ĵٽýõ����ּ���");
					se.printStackTrace();
			}//end catch
			
		}//end if
		
	}//modifyTestProc
	
	public void removeTestProc() {
		String inputData= JOptionPane.showInputDialog("�������\n������ �����ȣ �Է�");
		if(inputData!=null&&!inputData.equals("")) {
			int empno =0;
			try {
				empno = Integer.parseInt(inputData.trim());
			}catch(NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null, "�����ȣ�� �����̾���մϴ�.");
				return;
			}//end catch
			
			try {
				String msg ="";
				msg = UseCallableStatementDAO.getInstance().delectProc(empno);
				JOptionPane.showMessageDialog(null, msg);
				
			} catch (SQLException se) {
				JOptionPane.showMessageDialog(null, "�˼��մϴ�. ������ �߻��Ͽ����ϴ�.");
				se.printStackTrace();
			}
			
			
		}//end if
	}//removeTestProc
	
	public void searchAllTestPorc() {
		StringBuilder viewTestProc= new StringBuilder();
		viewTestProc
		.append("---------------------------------------------------------------------------------\n")
		.append("��ȣ\t�����ȣ\t�����\t����\t����\t�Ի���\n")
		.append("---------------------------------------------------------------------------------\n");
		int rowCount = 0;
		try {
			//DB���� ��ȸ�� ��� �ޱ�
			List<TestProcAllVO> list = UseCallableStatementDAO.getInstance().selectAllTestProc();
			TestProcAllVO tpavo= null;
			
			rowCount=list.size();
			for(int i=0; i<list.size();i++) {
				tpavo= list.get(i);
				viewTestProc
				.append(i+1).append("\t")
				.append(tpavo.getEmpno()).append("\t")
				.append(tpavo.getEname()).append("\t")
				.append(tpavo.getSal()).append("\t")
				.append(tpavo.getJob()).append("\t")
				.append(tpavo.getHiredate()).append("\n");
			}//end for
			
			if(list.isEmpty()) { //list.size() ==0
				viewTestProc.append("�Էµ� ��������� �������� �ʽ��ϴ�\n");
			}//end if
			
		} catch (SQLException e) {
			viewTestProc.append("DBMS���� ������ �߻��߽��ϴ�.\n");
			e.printStackTrace();
		}//end catch
		
		viewTestProc.append("----------------------------------------------------------------------------------\n")
		.append("\t\t��").append(rowCount).append("���� ��������� ��ȸ�Ǿ����ϴ�.");
		
		JTextArea jta = new JTextArea(20,50);
		jta.setEditable(false);
		jta.setText(viewTestProc.toString()); //������� ��µ����͸� T.A�� �����Ѵ�.
		
		JScrollPane jsp = new JScrollPane(jta);
		jsp.setBorder(new TitledBorder("��ü ��� ��ȸ ���"));
		JOptionPane.showMessageDialog(null, jsp);

	}//selectAllTestPorc
	
	public void searchOneTestProc() {
		String inputData = JOptionPane.showInputDialog("�����ȸ\n��ȸ�� �����ȣ �Է�");
		if(inputData!=null&&!inputData.equals("")) {
			try {
				int empno = Integer.parseInt(inputData.trim());	
				//�����ȣ�� �Է��Ͽ� �����ȣ�� �ش��ϴ� ��������� ��ȸ
				//��ȸ�� ����� �ִٸ� ������ ��ü(TestProcOneVO)�� ��ȯ�ǰ� ��ȸ�� ����� ���ٸ�
				//null�� ��ȯ�ȴ�.
				TestProcOneVO tpovo = UseCallableStatementDAO.getInstance().selectOneTestProc(empno);
				StringBuilder viewData = new StringBuilder();
				viewData.append("�����: ").append(tpovo.getEname())
				.append(", ����: ").append(tpovo.getSal())
				.append(", ����: ").append(tpovo.getJob())
				.append(", �Ի���: ").append(tpovo.getHiredate());
				
				JLabel lbl = new JLabel(viewData.toString());
				lbl.setFont(new Font("SansSerif", Font.BOLD, 15));
				
				JOptionPane.showMessageDialog(null, lbl);
			}catch(NullPointerException npe) {
				JOptionPane.showMessageDialog(null, inputData+"�� �����ȣ�� �������� �ʽ��ϴ�.\n");
			}catch(NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null, "�����ȣ�� ���� ���·� �Է��ϼž� �մϴ�.");
			} catch (SQLException se) {
				JOptionPane.showMessageDialog(null, "�������� ���� �߻�!!!");
				se.printStackTrace();
			}
		}
		
	}//searchOneTestProc
	
	
	public static void main(String[] args) {
		RunUseCallableStatement rucs = new RunUseCallableStatement();
		boolean exitFlag = false;
		String inputMenu = "";

		do {
			inputMenu = JOptionPane.showInputDialog("�޴�����\n1.����߰� 2.������� 3.������� 4.��ü�����ȸ 5.Ư�������ȸ 6.����");
			if (inputMenu != null) {

				switch (inputMenu) {
				case "1":
					rucs.addTestProc();
					break;
				case "2":
					rucs.modifyTestProc();
					break;
				case "3":
					rucs.removeTestProc();
					break;
				case "4":
					rucs.searchAllTestPorc();
					break;
				case "5":
					rucs.searchOneTestProc();
					break;
				case "6":
					exitFlag = true;
					break;

				default:
					JOptionPane.showMessageDialog(null, inputMenu + "��(��)�����Ǵ� ���񽺰� �ƴմϴ�.");
				}// end switch
			} else {
				exitFlag = true;
			}

		} while (!exitFlag);
		JOptionPane.showMessageDialog(null, "����� �ּż� �����մϴ�");
	}// main

}// class
