package day1211;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
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
		tf = new TextField("오늘은 화요일");
		choice= new Choice();
		String[] color= {"색선택","검은색","파란색","빨간색","녹색","심홍색"	};
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
		String[] color= {"검은색","파란색","빨간색","녹색","심홍색"	};
		String choiceColor = choice.getSelectedItem();
		if(color[0]==choiceColor) {
			tf.setForeground(Color.BLACK);
		}else if(color[1]==choiceColor) {
			tf.setForeground(Color.BLUE);
		}else if(color[2]==choiceColor) {
			tf.setForeground(Color.RED);
		}else if(color[3]==choiceColor) {
			tf.setForeground(Color.GREEN);
		}else if(color[4]==choiceColor) {
			tf.setForeground(Color.MAGENTA);
		}		
	}

}
