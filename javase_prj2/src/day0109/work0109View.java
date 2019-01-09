package day0109;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class work0109View extends JFrame{
	private JButton btnAddTableName;
	private JButton btnAddEtc;
	private JButton btnCreateTable;
	private JButton btnClearAll;
	private JLabel jlbTableName;
	private JLabel jlbColunmName;
	private JLabel jlbDataType;
	private JLabel jlbDataPrecision;
	private JLabel jlbConstraints;
	private JLabel jlbConstraintsName;
	private JTextField jtfTableName;
	private JTextField jtfColumnName;
	private JTextField jtfDataPrecision;
	private JTextField jtfConstraintsName;
	private JTextArea jtaQueryView;
	private JComboBox<String > jcbConstraints;
	private JComboBox<String> jcbDataType;
	private JTextArea queryView;
	
	public work0109View() {
		setLayout(null);
		btnAddTableName= new JButton("추가");
		btnAddEtc= new JButton("추가");
		btnCreateTable = new JButton("테이블생성");
		btnClearAll= new JButton("초기화");
		jlbTableName = new JLabel("테이블명");
		jlbColunmName = new JLabel("컬럼명");
		jlbDataType = new JLabel("테이터형");
		jlbDataPrecision = new JLabel("크기");
		jlbConstraints = new JLabel("제약사항");
		jlbConstraintsName = new JLabel("제약사항명");
		jtfTableName = new JTextField();
		jtfColumnName = new JTextField();
		jtfDataPrecision = new JTextField();
		jtfConstraintsName = new JTextField();
		jtaQueryView = new JTextArea();
		jcbConstraints = new JComboBox<String>();
		jcbDataType = new JComboBox<String>();
		
		jlbTableName.setBounds(10,10,70,40);
		add(jlbTableName);

		jtfTableName.setBounds(100,15,100,30);
		add(jtfTableName);
		
		btnAddTableName.setBounds(230,15,70,30);
		add(btnAddTableName);
		
		jlbColunmName.setBounds(10,65,70,40);
		add(jlbColunmName);
		
		jtfColumnName.setBounds(100,70,100,30);
		add(jtfColumnName);
		
		jlbDataType.setBounds(230,65,70,40);
		add(jlbDataType);
		
		jcbDataType.setBounds(300,70,100,30);
		String[] listDataTyte= {" ","varchar2","char","number","date"};
		for(int i=0;i<listDataTyte.length;i++) {
			jcbDataType.addItem(listDataTyte[i]);
		}
		add(jcbDataType);
		
		jlbDataPrecision.setBounds(420,65,70,40);
		add(jlbDataPrecision);
		
		jtfDataPrecision.setBounds(470,70,100,30);
		add(jtfDataPrecision);
		
		jlbConstraints.setBounds(10,110,70,40);
		add(jlbConstraints);
		
		jcbConstraints.setBounds(100,110,100,30);
		String[] listConstrains = {" ", "primary key","unique","not null","null"};
		for(int i=0;i<listConstrains.length;i++) {
			jcbConstraints.addItem(listConstrains[i]);
		}
		add(jcbConstraints);
		
		jlbConstraintsName.setBounds(220,105,70,40);
		add(jlbConstraintsName);
		
		jtfConstraintsName.setBounds(290,110,200,30);
		add(jtfConstraintsName);
		
		btnAddEtc.setBounds(500,105,70,40);
		add(btnAddEtc);
		
		jtaQueryView.setBounds(10,160,560,450);
		jtaQueryView.setEditable(false);
		add(jtaQueryView);
		
		btnCreateTable.setBounds(350,620,100,30);
		add(btnCreateTable);
		
		btnClearAll.setBounds(460,620,100,30);
		add(btnClearAll);
		
		////이벤트추가/////
		work0109Evt we = new work0109Evt(this);
		btnAddTableName.addActionListener(we);
		btnAddEtc.addActionListener(we);
		btnCreateTable.addActionListener(we);
		btnClearAll.addActionListener(we);
		jcbConstraints.addItemListener(we);
		jcbDataType.addItemListener(we);
		addWindowListener(we);
		/////////////////
		setBounds(100,100,600,700);
		setVisible(true);
		
		
		
		
	}
	
	
	
	public JTextField getJtfTableName() {
		return jtfTableName;
	}



	public JTextField getJtfColumnName() {
		return jtfColumnName;
	}



	public JTextField getJtfDataPrecision() {
		return jtfDataPrecision;
	}



	public JTextField getJtfConstraintsName() {
		return jtfConstraintsName;
	}



	public JTextArea getJtaQueryView() {
		return jtaQueryView;
	}


	public JButton getBtnAddTableName() {
		return btnAddTableName;
	}



	public void setBtnAddTableName(JButton btnAddTableName) {
		this.btnAddTableName = btnAddTableName;
	}



	public JButton getBtnAddEtc() {
		return btnAddEtc;
	}



	public void setBtnAddEtc(JButton btnAddEtc) {
		this.btnAddEtc = btnAddEtc;
	}



	public JButton getBtnCreateTable() {
		return btnCreateTable;
	}



	public void setBtnCreateTable(JButton btnCreateTable) {
		this.btnCreateTable = btnCreateTable;
	}



	public JButton getBtnClearAll() {
		return btnClearAll;
	}



	public void setBtnClearAll(JButton btnClearAll) {
		this.btnClearAll = btnClearAll;
	}

	

	public void setJtaQueryView(JTextArea jtaQueryView) {
		this.jtaQueryView = jtaQueryView;
	}

	

	public JComboBox<String> getJcbConstraints() {
		return jcbConstraints;
	}
	
	
	
	public void setJcbConstraints(JComboBox<String> jcbConstraints) {
		this.jcbConstraints = jcbConstraints;
	}



	public JComboBox<String> getJcbDataType() {
		return jcbDataType;
	}



	public void setJcbDataType(JComboBox<String> jcbDataType) {
		this.jcbDataType = jcbDataType;
	}



	public static void main(String[] args) {
		new work0109View();
	}

}
