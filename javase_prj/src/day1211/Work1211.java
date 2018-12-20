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
	
	TextField tf;//itemStateChanged 에서 사용하기 위한 인스턴스변수선언
	Choice choice;

	public Work1211() {
		
		////////////라벨설정///////////////////////
		Label label = new Label("Label");
		/////////////텍스트필드설정///////////////////
		tf = new TextField("오늘은 화요일");
		//////////////초이스 설정/////////////////////
		choice= new Choice();
		String[] color= {"색선택","검은색","파란색","빨간색","녹색","심홍색"	};
		for(int i=0; i<color.length;i++) {
			choice.add(color[i]);			
		};
		////////////이벤트등록//////////////
		choice.addItemListener(this);
		
		////////////배치///////////////////
		label.setBounds(50,50,40,30);
		add(label);
		tf.setBounds(50,80,100,50);
		add(tf);
		choice.setBounds(200,60,80,30);
		add(choice);
		//////////////윈도우설정//////////////////
		setLayout(null);
		setBounds(100,100,400,250);
		///////////////사용자보기/설정///////////////
		setResizable(false);
		setVisible(true);
		//////////////닫기가능설정//////////////////
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
	//이벤트 발생 추상메소드 오버라이딩
	@Override
	public void itemStateChanged(ItemEvent e) {
		String choiceColor = choice.getSelectedItem(); //초이스값을 저장
		if(choiceColor=="검은색") {         //저장한 값을 비교
			tf.setForeground(Color.BLACK); //색에 따라 텍스트필드 글자색 변경
		}else if(choiceColor=="파란색") {
			tf.setForeground(Color.BLUE);
		}else if(choiceColor=="빨간색") {
			tf.setForeground(Color.RED);
		}else if(choiceColor=="녹색") {
			tf.setForeground(Color.GREEN);
		}else if(choiceColor=="심홍색") {
			tf.setForeground(Color.MAGENTA);
		}		
	}//itemStateChanged

}
