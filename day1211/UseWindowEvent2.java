package day1211;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;

/**
 *XxxAdapter class�� ��� �Ǿ���ϴ� ����
 * @author owner
 */
@SuppressWarnings("serial")
public class UseWindowEvent2 extends Frame {
	public UseWindowEvent2() {
		super("������ �̺�Ʈ ����");
		
		
		setBounds(100,100,400,400);
		setVisible(true);
		
		UseWindowEvent2.WindowImpl wi = this.new WindowImpl();
		addWindowListener(wi);
		
		
	}//UseWindowEvent
	
	public static void main(String[] args) {
		new UseWindowEvent2();
	}//main
	
	//WindowAdapter class�� ��ӹ����� �ʿ��� method�� Override �ؾ��Ѵ�.
	public class WindowImpl extends WindowAdapter{
		
		@Override
		public void windowClosing(WindowEvent e) {
			System.out.println("windowClosing");
			dispose();
		}
	}
}//class
