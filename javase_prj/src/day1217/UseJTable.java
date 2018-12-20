package day1217;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 * MVC Pattern�� ����� class 
 * @author owner
 */
@SuppressWarnings("serial")
public class UseJTable extends JFrame implements ActionListener{
	private JButton btnAdd;
	private DefaultTableModel dtm;
	private JTable jt;
	private UseJTable ujt;
	public UseJTable() {
		super("JTable ����");
		//1. �����͸� �����ϴ� Model Ŭ���� ����
		String[] columnNames = {"��ȣ","�̸�","�ּ�","�̸���"};
		String[][] rowData = {
				{"1","������","��õ�� �ҷ���","chan@test.com"},
				{"2","���ü�","����� ���ε�","teack@sist.co.kr"},
				{"3","������","��⵵ �Ⱦ��","hyun@gmail.com"},
				};
		dtm = new DefaultTableModel(rowData ,columnNames) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		//2. �����͸� �����ִ� View Ŭ���� ����
		jt= new JTable(dtm);
		ujt = this;
		//���̺� �÷��� ũ�� ���� :�÷��� �ϳ��� ���� �����ϸ� ���� ��� �÷��� ������ ũ�⸦ ����޴´�.
		//�÷�ũ�⺯�� 1. :�÷��� ��´�.
		TableColumn tc =jt.getColumnModel().getColumn(0);
		//�÷�ũ�⺯�� 2. :�÷��� ũ�⺯��.
		tc.setPreferredWidth(30);
		jt.getColumnModel().getColumn(1).setPreferredWidth(100);
		jt.getColumnModel().getColumn(2).setPreferredWidth(200);
		jt.getColumnModel().getColumn(3).setPreferredWidth(170);
		
		//���̺� ���� ���� ����.
		jt.setRowHeight(30);
		
		
		btnAdd = new JButton("������ �߰�");
		
		//Column�� �̸��� ScrollBar�� ����� �� �ֵ��� JScrollPane�� ��ġ
		JScrollPane jsp = new JScrollPane(jt);
		JPanel jp = new JPanel();
		jp.add(btnAdd);
		
		//3. ��ġ		
		add("Center", jsp);
		add("South",jp);
		
		//4.�̺�Ʈ ���
		btnAdd.addActionListener(this);
		UseJTable.TableEvt te = this.new TableEvt();
		jt.addMouseListener(te);
		
		setBounds(100,100,500,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}//UseJTable
	@Override
	public void actionPerformed(ActionEvent ae) {
		String inputData = JOptionPane.showInputDialog("������ �Է�\n��)��ȣ,�̸�,�ּ�,�̸���");
		
		String[] tempData = inputData.split(",");
		
		if(tempData.length!=4) {
			JOptionPane.showMessageDialog(this,"�Էµ������� ���´� \n��ȣ,�̸�,�ּ�,�̸��� �̾�� �մϴ�.",
					"�Է¿���",JOptionPane.ERROR_MESSAGE);
			return;
		}//end if
		
		//�Էµ� �����͸� ȭ�鿡 �����ֱ� ���� DefaultTableModel�� �߰�(���߰�)
		dtm.addRow(tempData); 
		
	}//actionPerformed
	
	////////////////////////////////////////////innerclass ����//////////////////////////////////////////////////////
	public class TableEvt extends MouseAdapter{
		@Override
		public void mouseClicked(MouseEvent e) {
//			String selectValue[][];
//			for(int i = 0; i<selectValue.length;i++) {
//				selectValue[i] =(String[])jt.getValueAt(jt.getSelectedRow(), i);
//			}
//			String selectValue3 =(String)jt.getValueAt(jt.getSelectedRow(), 3);
			
			StringBuilder viewData = new StringBuilder();
			int selectedRow = jt.getSelectedRow();
			int columnCount = jt.getColumnCount();
			
			int flag = JOptionPane.showConfirmDialog(ujt,"���� ������ ��ȸ, �ƴϿ��� ������ ������ �����մϴ�.");
			switch (flag) {
			case JOptionPane.OK_OPTION:
				for(int i=0; i<columnCount;i++) {
					viewData.append(jt.getValueAt(selectedRow,i)).append("\n");
				}//end for
				
				JOptionPane.showMessageDialog(ujt,viewData); 				
				break;

			case JOptionPane.NO_OPTION:
				switch (JOptionPane.showConfirmDialog(ujt,"���� �����Ͻðڽ��ϱ�?")) {
				case JOptionPane.OK_OPTION:
					dtm.removeRow(selectedRow);
				}
				break;				
			}//end switch
		}//mouseClicked
	}//class
	
	////////////////////////////////////////////innerclass ��//////////////////////////////////////////////////////
	
	public static void main(String[] args) {
		new UseJTable();
	}//main

}//class
