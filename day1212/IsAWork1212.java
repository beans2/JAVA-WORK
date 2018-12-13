package day1212;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.List;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("serial")
public class IsAWork1212 extends Frame implements ActionListener,ItemListener {
	private List list;
	private TextField tfName;
	private TextField tfAge;
	private TextField tfAddr;
	private Button btnAdd;
	private Button btnDel;
	private Button btnAlt;
	private Button btnCls;
	
	
	public IsAWork1212() {
		////////////////////컴포넌트/////////////////////////////////
		Label lblName = new Label("이름");
		Label lblAge = new Label("나이");
		Label lblAddr = new Label("주소");
		Label lblList = new Label("List");
		
		list = new List();
		
		tfName = new TextField();
		tfAge = new TextField();
		tfAddr = new TextField();
		
		btnAdd = new Button("추가");
		btnDel = new Button("삭제");
		btnAlt = new Button("변경");
		btnCls = new Button("닫기");
		
		///////////////////////////////배치//////////////////////////////////
		
		setLayout(null);
		lblName.setBounds(30,60,40,20);
		add(lblName);
		lblAge.setBounds(30,100,40,20);
		add(lblAge);
		lblAddr.setBounds(30,140,40,20);
		add(lblAddr);
		lblList.setBounds(240,30,40,20);
		add(lblList);
		
		tfName.setBounds(70,60,80,20);
		add(tfName);
		tfAge.setBounds(70,100,80,20);
		add(tfAge);
		tfAddr.setBounds(70,140,80,20);
		add(tfAddr);
		
		list.setBounds(230,60,200,100);
		add(list);
		
		btnAdd.setBounds(60, 200, 80, 40);
		add(btnAdd);
		btnDel.setBounds(150, 200, 80, 40);
		add(btnDel);
		btnAlt.setBounds(240, 200, 80, 40);
		add(btnAlt);
		btnCls.setBounds(330, 200, 80, 40);
		add(btnCls);
		////////////////////////////이벤트////////////////////////////////////////////
		btnAdd.addActionListener(this);
		btnDel.addActionListener(this);
		btnAlt.addActionListener(this);
		btnCls.addActionListener(this);

		
		
		////////////////////////////////윈도우크기//////////////////////////////////
		
		setBounds(100,100,500,300);
		
		///////////////////////////////고정///////////////////////////////////////
		setResizable(false);
		//////////////////////////////가시화//////////////////////////////////
		setVisible(true);
		
		/////////////////////////////////윈도우 닫기////////////////////////////////////
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
		
	}//DesignWork1212

	@Override
	public void actionPerformed(ActionEvent ae) {
		// 추가/삭제/변경/닫기 버튼이 눌린다면

		if (ae.getSource() == btnAdd) { //추가버튼이 눌렸을 때
//			if (!(dw.getTfName().getText().isEmpty()) || !(dw.getTfAge().getText().isEmpty())
//					|| !(dw.getTfAddr().getText().isEmpty())) {
			if (!(tfName.getText().equals("")) || !(tfAge.getText().equals(""))  //공백입력이 아니라면
					|| !(tfAddr.getText().equals(""))) {
				add(); //추가작업
			}
		}
		if (ae.getSource() == btnDel) { //삭제버튼이 눌렸을 때
			delete(); //삭제작업
		}
		if (ae.getSource() == btnAlt) { //변경버튼이 눌렸을 때
			alter(); //변경작업
		}
		if (ae.getSource() == btnCls) { //닫기버튼이 눌렸을 때
			close();//닫기작업
		}
	}


	@Override
	public void itemStateChanged(ItemEvent e) {
		listselect();
	}
	
	private void listselect() { //리스트가 선택되었을 때 메소드
		String info = list.getSelectedItem();
		String[] naa = info.toString().split("/");
		tfName.setText(naa[0]);
		tfAge.setText(naa[1]);
		tfAddr.setText(naa[2]);
		
	}

	private void add() {//추가메소드

		StringBuilder list1 = new StringBuilder();
		list1.append(tfName.getText()).append("/").append(tfAge.getText()).append("/")
				.append(tfAddr.getText());
		list.add(list.toString());
		tfName.setText("");
		tfAge.setText("");
		tfAddr.setText("");
	}


	private void delete() {//삭제메소드
//		List list = dw.getList();
		String info = list.getSelectedItem();
		list.remove(info);
		tfName.setText("");
		tfAge.setText("");
		tfAddr.setText("");
	}

	private void alter() {//변경메소드
		StringBuilder str = new StringBuilder();
		str.append(tfName.getText()).append("/").append(tfAge.getText()).append("/")
				.append(tfAddr.getText());
		int info = list.getSelectedIndex();
//		dw.getList().add(str.toString(), info);
		list.remove(info);
		list.add(str.toString(), info);
		tfName.setText("");
		tfAge.setText("");
		tfAddr.setText("");
	}

	private void close() {//닫기메소드
		dispose();
	}
	
	
	public static void main(String[] args) {
		new DesignWork1212();
	}
}
