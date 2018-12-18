package day1217;

import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * 
 * @author owner
 */
@SuppressWarnings("serial")
public class Work1217 extends JFrame {
	private String selectMenu;
	private String inputData;
	private ArrayList<String> list = new ArrayList<String>();
	
	private int count = 1;
	private StringBuffer s;

	public Work1217() {

		while(true) {
			selectDialog();
			if (Integer.parseInt(selectMenu)==1) {
				inputDialog();
				
			} else if (Integer.parseInt(selectMenu)==2) {
				if (list.isEmpty()) {
					outputNotDataMessage();
				} else {
					showList();
					
				}
			} else if (Integer.parseInt(selectMenu)==3) {
				break;
			} else {
				JOptionPane.showMessageDialog(this, "잘못입력하셨습니다");
			}
		}//end while		
	}//Work1217

	public void selectDialog() { // 메뉴선택 다이얼로그 창
		selectMenu = JOptionPane.showInputDialog("메뉴선택\n 1.입력 2.출력 3.종료");
	}//selectDialog

	public void inputDialog() { // 점수입력 다이얼로그 창

		inputData = JOptionPane.showInputDialog("데이터입력 \n 예)이름, 자바점수, 오라클점수");
		String[] check = inputData.split(",");
		if (check.length != 3) {
			JOptionPane.showMessageDialog(this, "입력데이터의 형태는 \n번호,이름,주소,이메일 이어야 합니다.", "입력오류",
					JOptionPane.ERROR_MESSAGE);
			return;
		} // end if
		inputToList();
	}//inputDialog

	public void outputNotDataMessage() { // 데이터 없는 메시지 다이얼로그 창
		JOptionPane.showMessageDialog(null, "데이터가 없습니다");
	}//outputNotDataMessage()

	public void inputToList() {
		String[] tempData = inputData.split(",");
		int sum = 0;
		int avg = 0;
		 
		list.add(String.valueOf(count));
		if (tempData.length == 3) {
			for (int i = 0; i < tempData.length; i++) {
				list.add(tempData[i]+"   ");
			}
			count++;

			sum += Integer.parseInt(tempData[1].trim()) + Integer.parseInt(tempData[2].trim());
			avg = sum / 2;
			list.add(String.valueOf(sum+"   "));
			list.add(String.valueOf(avg+"   "));
			list.add("\n");
		}//end if
	}// inputToList

	public void showList() {
		StringTokenizer stk = new StringTokenizer(list.toString(),",.[.]");
		s= new StringBuffer();
		while(stk.hasMoreTokens()){
			s.append(stk.nextToken());
        }
		JTextArea jta = new JTextArea();
		jta = new JTextArea(10, 40);
		jta.setEditable(false);
		jta.append("번호 이름 자바 오라클 총점 평균\n");
		jta.append(String.valueOf(s));
		JScrollPane jsp;
		jsp = new JScrollPane(jta);
		JOptionPane.showMessageDialog(null,jsp);
	}//showList
	
	public static void main(String[] args) {
		new Work1217();
	}// main
}
