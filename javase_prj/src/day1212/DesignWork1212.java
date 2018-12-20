package day1212;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.List;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("serial")
public class DesignWork1212 extends Frame{
	private List list;
	private TextField tfName;
	private TextField tfAge;
	private TextField tfAddr;
	private Button btnAdd;
	private Button btnDel;
	private Button btnAlt;
	private Button btnCls;
	
	
	public DesignWork1212() {
		////////////////////������Ʈ/////////////////////////////////
		Label lblName = new Label("�̸�");
		Label lblAge = new Label("����");
		Label lblAddr = new Label("�ּ�");
		Label lblList = new Label("List");
		
		list = new List();
		
		tfName = new TextField();
		tfAge = new TextField();
		tfAddr = new TextField();
		
		btnAdd = new Button("�߰�");
		btnDel = new Button("����");
		btnAlt = new Button("����");
		btnCls = new Button("�ݱ�");
		///////////////////////////////��ġ//////////////////////////////////
		
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
		////////////////////////////�̺�Ʈ////////////////////////////////////////////
		EvtWork1212 ew = new EvtWork1212(this);
		btnAdd.addActionListener(ew);
		btnDel.addActionListener(ew);
		btnAlt.addActionListener(ew);
		btnCls.addActionListener(ew);
		list.addItemListener(ew);
		tfAddr.addKeyListener(ew);
//		tfAddr.addFocusListener(ew);
		
		////////////////////////////////������ũ��//////////////////////////////////
		
		setBounds(100,100,500,300);
		
		///////////////////////////////����///////////////////////////////////////
		setResizable(false);
		//////////////////////////////����ȭ//////////////////////////////////
		setVisible(true);
		
		////////////////////////////////////////////////////////////////////////
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
		
	}//DesignWork1212
	
	////////////////////////////getter///////////////////////////////////////
	public List getList() {
		return list;
	}
	
	public TextField getTfName() {
		return tfName;
	}
	
	public TextField getTfAge() {
		return tfAge;
	}
	
	public TextField getTfAddr() {
		return tfAddr;
	}
	
	public Button getBtnAdd() {
		return btnAdd;
	}
	
	public Button getBtnDel() {
		return btnDel;
	}

	public Button getBtnAlt() {
		return btnAlt;
	}
	
	
	public Button getBtnCls() {
		return btnCls;
	}
	//////////////////////main/////////////////////////////////
	public static void main(String[] args) {
		new DesignWork1212();
	}
}
