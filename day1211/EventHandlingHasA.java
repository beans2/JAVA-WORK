package day1211;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *Has a 관계로 이벤트 처리
 * @author owner
 */
//1. 이벤트 처리 객체를 구현
public class EventHandlingHasA implements ActionListener{
	//EventHandlingHasA는 Design을 가지고 있다.
	private Design design;
	
	public EventHandlingHasA(Design design) {
		this.design = design;
	}//EventHandlingHasA
	
	@Override
	//3. abstract method Override
	public void actionPerformed(ActionEvent ae) {
		//이벤트가 발생했을 때 처리할 코드
		System.out.println("전달받은 Design 객체"+design);
		design.dispose();
	}//actionPerformed
	
}//class
