package day1212;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("serial")
public class CompareEventTest extends Frame implements ActionListener{
	private Button buttenA;
	private Button buttenB;
	private TextField tf;
	public CompareEventTest() {
		super("버튼비교");
		buttenA = new Button("A");
		buttenB = new Button("B");
		tf = new TextField();
		
		setLayout(null);
		buttenA.setBounds(100,100,50,50);
		buttenB.setBounds(200,100,50,50);
		tf.setBounds(100,200,150,50);
		add(buttenA);
		add(buttenB);
		add(tf);
		
		buttenA.addActionListener(this);
		buttenB.addActionListener(this);
		//////////////////////////
		setBounds(50,50,400,400);
		
		setVisible(true);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
		
		
	}
	public static void main(String[] args) {
		new CompareEventTest();
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==buttenA) {
			tf.setText("ㅋㅋㅋ");
		}else if(ae.getSource()==buttenB){
			tf.setText("0_0");
		}
	}

}
