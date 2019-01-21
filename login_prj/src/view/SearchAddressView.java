package view;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import login.controller.SearchAddressController;

@SuppressWarnings("serial")
public class SearchAddressView extends JDialog{
	private JTextField jtfDong;
	private DefaultTableModel dtmZip;
	private JButton jbSearch, jbOk,jbCancel;
	private JTable jtZip;

	
	public SearchAddressView(LoginView lv, SignUpView suv) {
		super(suv,"search Zipcode",true);
		jtfDong = new JTextField();
		String[] columnNames = {"우편번호", "시도", "구군", "동", "번지"} ;
		dtmZip = new DefaultTableModel(columnNames,0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		jtZip = new JTable(dtmZip);
		jtZip.getTableHeader().setReorderingAllowed(false);
		jtZip.getTableHeader().setResizingAllowed(false);
		jbSearch = new JButton("검색");
		jbOk = new JButton("선택");
		jbCancel = new JButton("취소");
		JLabel jlDong = new JLabel("동 검색");
		
		setLayout(null);
		
		jlDong.setBounds(60,30,80,30);
		add(jlDong);
		
		jtfDong.setBounds(130,30,300,30);
		add(jtfDong);

		JScrollPane jsp = new JScrollPane(jtZip);
		jsp.setBounds(20,70,540,300);
		add(jsp);
		
		jbSearch.setBounds(445,30,80,30);
		add(jbSearch);
		jbOk.setBounds(200,390,80,30);
		add(jbOk);
		jbCancel.setBounds(290,390,80,30);
		add(jbCancel);

		//이벤트
		SearchAddressController sac = new SearchAddressController(lv, suv,this);
		jbSearch.addActionListener(sac);
		jbOk.addActionListener(sac);
		jbCancel.addActionListener(sac);
		
		
		setBounds(suv.getX()+50, suv.getY()+50, 600,500);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		
	}
	

	public JTable getJtZip() {
		return jtZip;
	}


	public JTextField getJtfDong() {
		return jtfDong;
	}


	public DefaultTableModel getDtmZip() {
		return dtmZip;
	}


	public JButton getJbSearch() {
		return jbSearch;
	}


	public JButton getJbOk() {
		return jbOk;
	}


	public JButton getJbCancel() {
		return jbCancel;
	}
	
}
