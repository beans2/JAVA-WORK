package day1211;

import java.awt.Choice;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *
 * @author owner
 */
@SuppressWarnings("serial")
public class HasAWork1211Design extends Frame  {
	
	TextField tf;//itemStateChanged ���� ����ϱ� ���� �ν��Ͻ���������
	Choice choice;

	public HasAWork1211Design() {
		
		////////////�󺧼���///////////////////////
		Label label = new Label("Label");
		/////////////�ؽ�Ʈ�ʵ弳��///////////////////
		tf = new TextField("������ ȭ����");
		//////////////���̽� ����/////////////////////
		choice= new Choice();
		String[] color= {"������","������","�Ķ���","������","���","��ȫ��"	};
		for(int i=0; i<color.length;i++) {
			choice.add(color[i]);			
		};
		////////////�̺�Ʈ���//////////////
		HasAWork1211 haw = new HasAWork1211(this);
		choice.addItemListener(haw);
		
		////////////��ġ///////////////////
		label.setBounds(50,50,40,30);
		add(label);
		tf.setBounds(50,80,100,50);
		add(tf);
		choice.setBounds(200,60,80,30);
		add(choice);
		//////////////�����켳��//////////////////
		setLayout(null);
		setBounds(100,100,400,250);
		///////////////����ں���/����///////////////
		setResizable(false);
		setVisible(true);
		//////////////�ݱⰡ�ɼ���//////////////////
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				dispose();
			}
		});
		
	}//Work1211
	public static void main(String[] args) {
		new Work1211();
	}

}
