package kr.co.sist.memo.view;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.TextArea;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import kr.co.sist.memo.evt.MemoHelpEvt;

@SuppressWarnings("serial")
public class MemoHelp extends Dialog{
	private JavaMemo jm;
	private TextArea taHelp;
	private Button btnOk;
	public MemoHelp(JavaMemo jm){
		super(jm,"�޸��� ����",true);
		this.jm = jm;
		
		taHelp = new TextArea("�޸��� ����\n"+"�� �޸����� Java�� ����������� ������ �ڵ� ���� �� ������ �� �� �ֽ��ϴ�. \n"
				+ "��, �� �ڵ带 ����Ͽ� �������� ������ �ҽ������� ��Ģ���� �մϴ�. GNU\n"+"�ۼ���: ���ü�\n"+"version: 1.0");
		btnOk = new Button("Ȯ��");
		
		setLayout(null);		
		taHelp.setBounds(20,30,470,330);
		taHelp.setEditable(false);
		add(taHelp);
		btnOk.setBounds(215,360,50,30);
		add(btnOk);
		
		MemoHelpEvt mhe = new MemoHelpEvt(this);
		btnOk.addActionListener(mhe);
		
		setBounds(jm.getX()+50,jm.getY()+50,500,400);
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				dispose();
			}
		});
		setVisible(true);
		
		
	}//HelpFormat
	public static void main(String[] args) {
		new JavaMemo();
	}
	public Button getBtnOk() {
		return btnOk;
	}

}
