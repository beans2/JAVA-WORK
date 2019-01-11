package day0111;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class TableInputImage extends JFrame {
	
	private DefaultTableModel dtmSite;
	private ImageIcon imaNaver;
	private ImageIcon imaDaum;
	private ImageIcon imaGoogle;
	

	public TableInputImage() {
		imaNaver = new ImageIcon("C:\\dev\\workspace\\javase_prj2\\src\\day0111\\images\\naver.png");
		imaDaum = new ImageIcon("C:\\dev\\workspace\\javase_prj2\\src\\day0111\\images\\daum.png");
		imaGoogle = new ImageIcon("C:\\dev\\workspace\\javase_prj2\\src\\day0111\\images\\google.png");

		Object[][] strSite = { { imaDaum, "www.daum.com", "īī��������" }, { imaNaver, "www.naver.com", "����" },
				{imaGoogle, "www.google.com", "�˻������� ���ƿ�" } };
		String[] columnName = { "�ΰ�", "URL", "Ư¡" };
		dtmSite = new DefaultTableModel(strSite,columnName);
		JTable jtbSite= new JTable(dtmSite) {
			@Override
			public Class getColumnClass(int column) {
				//row = JTable �� �Էµ� ������ �迭�� �࿡ ���Ѵٸ�
				//��� �÷��� ���� �Էµ� ������ ��ȯ�Ѵ�.
				return getValueAt(0,column).getClass();
			}
		};
		jtbSite.setRowHeight(100);
		JScrollPane jsp = new JScrollPane(jtbSite);
		jtbSite.getTableHeader().setResizingAllowed(false); //�÷��� ũ�⺯�� ����
		jtbSite.getTableHeader().setReorderingAllowed(false); //�÷��� �̵�����
		
		jtbSite.getTableHeader().getColumnModel().getColumn(0).setPreferredWidth(30);
		add("Center",jsp);
		
		setBounds(100, 100, 700, 400);
		setVisible(true);

	}// view

	public static void main(String[] args) {
		new TableInputImage();
	}

}
