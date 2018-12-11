package day1211;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *
 * @author owner
 */
@SuppressWarnings("serial")
public class Work1211 extends Frame implements  ItemListener {
	Label label;
	TextField tf;
	Choice choice;

	public Work1211() {
		
		
		label = new Label("Label");
		tf = new TextField("������ ȭ����");
		choice= new Choice();
		String[] color= {"������","������","�Ķ���","������","���","��ȫ��"	};
		for(int i=0; i<color.length;i++) {
			choice.add(color[i]);			
		};
		choice.addItemListener(this);
		
		label.setBounds(50,50,40,30);
		add(label);
		tf.setBounds(50,80,100,50);
		add(tf);
		choice.setBounds(200,60,80,30);
		add(choice);
		
		setLayout(null);
		setBounds(100,100,400,250);
		setResizable(false);
		setVisible(true);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				dispose();
			}
		});
		
	}
	public static void main(String[] args) {
		new Work1211();
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		String choiceColor = choice.getSelectedItem();
		if(choiceColor=="������") {
			tf.setForeground(Color.BLACK);
		}else if(choiceColor=="�Ķ���") {
			tf.setForeground(Color.BLUE);
		}else if(choiceColor=="������") {
			tf.setForeground(Color.RED);
		}else if(choiceColor=="���") {
			tf.setForeground(Color.GREEN);
		}else if(choiceColor=="��ȫ��") {
			tf.setForeground(Color.MAGENTA);
		}		
	}

}
