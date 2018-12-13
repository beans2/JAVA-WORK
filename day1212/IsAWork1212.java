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
		btnAdd.addActionListener(this);
		btnDel.addActionListener(this);
		btnAlt.addActionListener(this);
		btnCls.addActionListener(this);

		
		
		////////////////////////////////������ũ��//////////////////////////////////
		
		setBounds(100,100,500,300);
		
		///////////////////////////////����///////////////////////////////////////
		setResizable(false);
		//////////////////////////////����ȭ//////////////////////////////////
		setVisible(true);
		
		/////////////////////////////////������ �ݱ�////////////////////////////////////
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
		
	}//DesignWork1212

	@Override
	public void actionPerformed(ActionEvent ae) {
		// �߰�/����/����/�ݱ� ��ư�� �����ٸ�

		if (ae.getSource() == btnAdd) { //�߰���ư�� ������ ��
//			if (!(dw.getTfName().getText().isEmpty()) || !(dw.getTfAge().getText().isEmpty())
//					|| !(dw.getTfAddr().getText().isEmpty())) {
			if (!(tfName.getText().equals("")) || !(tfAge.getText().equals(""))  //�����Է��� �ƴ϶��
					|| !(tfAddr.getText().equals(""))) {
				add(); //�߰��۾�
			}
		}
		if (ae.getSource() == btnDel) { //������ư�� ������ ��
			delete(); //�����۾�
		}
		if (ae.getSource() == btnAlt) { //�����ư�� ������ ��
			alter(); //�����۾�
		}
		if (ae.getSource() == btnCls) { //�ݱ��ư�� ������ ��
			close();//�ݱ��۾�
		}
	}


	@Override
	public void itemStateChanged(ItemEvent e) {
		listselect();
	}
	
	private void listselect() { //����Ʈ�� ���õǾ��� �� �޼ҵ�
		String info = list.getSelectedItem();
		String[] naa = info.toString().split("/");
		tfName.setText(naa[0]);
		tfAge.setText(naa[1]);
		tfAddr.setText(naa[2]);
		
	}

	private void add() {//�߰��޼ҵ�

		StringBuilder list1 = new StringBuilder();
		list1.append(tfName.getText()).append("/").append(tfAge.getText()).append("/")
				.append(tfAddr.getText());
		list.add(list.toString());
		tfName.setText("");
		tfAge.setText("");
		tfAddr.setText("");
	}


	private void delete() {//�����޼ҵ�
//		List list = dw.getList();
		String info = list.getSelectedItem();
		list.remove(info);
		tfName.setText("");
		tfAge.setText("");
		tfAddr.setText("");
	}

	private void alter() {//����޼ҵ�
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

	private void close() {//�ݱ�޼ҵ�
		dispose();
	}
	
	
	public static void main(String[] args) {
		new DesignWork1212();
	}
}
