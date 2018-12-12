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
	
	TextField tf;//itemStateChanged 에서 사용하기 위한 인스턴스변수선언
	Choice choice;

	public HasAWork1211Design() {
		
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
		HasAWork1211 haw = new HasAWork1211(this);
		choice.addItemListener(haw);
		
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

}
