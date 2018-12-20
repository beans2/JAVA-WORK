package day1211;

import java.awt.Choice;
import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class HasAWork1211 implements ItemListener {
	private HasAWork1211Design workDesign;
	public HasAWork1211(HasAWork1211Design workDesign) {
		this.workDesign= workDesign;
	}
	public void itemStateChanged(ItemEvent e) {
		workDesign.choice = new Choice();
		String choiceColor = workDesign.choice.getSelectedItem(); //���̽����� ����
		if(choiceColor=="������") {         //������ ���� ��
			workDesign.tf.setForeground(Color.BLACK); //���� ���� �ؽ�Ʈ�ʵ� ���ڻ� ����
		}else if(choiceColor=="�Ķ���") {
			workDesign.tf.setForeground(Color.BLUE);
		}else if(choiceColor=="������") {
			workDesign.tf.setForeground(Color.RED);
		}else if(choiceColor=="���") {
			workDesign.tf.setForeground(Color.GREEN);
		}else if(choiceColor=="��ȫ��") {
			workDesign.tf.setForeground(Color.MAGENTA);
		}		
	}//itemStateChanged
}
