package day0107;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class StatementLogin extends JFrame{

	private JTextField jtfId;
	private JPasswordField jptPass;
	private JButton jbtLogin;
	private JButton jbtCancel;
	
	public StatementLogin() {
		super("Statement ��ü�� ����� �α���");
		jtfId = new JTextField();
		jptPass = new JPasswordField();
		jbtLogin = new JButton("�α���");
		jbtCancel = new JButton("���");
		
		setLayout(new GridLayout(3,1));
		JPanel pannel = new  JPanel();
		pannel.add(jbtLogin);
		pannel.add(jbtCancel);
		
		jtfId.setBorder(new TitledBorder("���̵�"));
		jptPass.setBorder(new TitledBorder("��й�ȣ"));		
		
		add(jtfId);
		add(jptPass);
		add(pannel);
		
		StatementLoginEvt sle = new StatementLoginEvt(this);
		jtfId.addActionListener(sle);
		jptPass.addActionListener(sle);
		jbtLogin.addActionListener(sle);
		jbtCancel.addActionListener(sle);
		
		addWindowListener(sle);
		
		setBounds(100,100,300,180);
		setVisible(true);
		setResizable(false);
			
	}//StatementLogin
	
	
	public JTextField getJtfId() {
		return jtfId;
	}


	public JPasswordField getJptPass() {
		return jptPass;
	}


	public JButton getJbtLogin() {
		return jbtLogin;
	}


	public JButton getJbtCancel() {
		return jbtCancel;
	}


	public static void main(String[] args) {
		new StatementLogin();
	}//main
}
