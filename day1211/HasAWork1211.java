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
		String choiceColor = workDesign.choice.getSelectedItem(); //초이스값을 저장
		if(choiceColor=="검은색") {         //저장한 값을 비교
			workDesign.tf.setForeground(Color.BLACK); //색에 따라 텍스트필드 글자색 변경
		}else if(choiceColor=="파란색") {
			workDesign.tf.setForeground(Color.BLUE);
		}else if(choiceColor=="빨간색") {
			workDesign.tf.setForeground(Color.RED);
		}else if(choiceColor=="녹색") {
			workDesign.tf.setForeground(Color.GREEN);
		}else if(choiceColor=="심홍색") {
			workDesign.tf.setForeground(Color.MAGENTA);
		}		
	}//itemStateChanged
}
