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

		Object[][] strSite = { { imaDaum, "www.daum.com", "카카오프렌즈" }, { imaNaver, "www.naver.com", "웹툰" },
				{imaGoogle, "www.google.com", "검색엔진이 좋아요" } };
		String[] columnName = { "로고", "URL", "특징" };
		dtmSite = new DefaultTableModel(strSite,columnName);
		JTable jtbSite= new JTable(dtmSite) {
			@Override
			public Class getColumnClass(int column) {
				//row = JTable 에 입력된 이차원 배열의 행에 속한다면
				//모든 컬럼의 값을 입력된 형으로 반환한다.
				return getValueAt(0,column).getClass();
			}
		};
		jtbSite.setRowHeight(100);
		JScrollPane jsp = new JScrollPane(jtbSite);
		jtbSite.getTableHeader().setResizingAllowed(false); //컬럼의 크기변경 막기
		jtbSite.getTableHeader().setReorderingAllowed(false); //컬럼의 이동막기
		
		jtbSite.getTableHeader().getColumnModel().getColumn(0).setPreferredWidth(30);
		add("Center",jsp);
		
		setBounds(100, 100, 700, 400);
		setVisible(true);

	}// view

	public static void main(String[] args) {
		new TableInputImage();
	}

}
