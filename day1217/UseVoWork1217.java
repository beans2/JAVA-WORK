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
public class UseVoWork1217 extends JFrame {
	private String selectMenu;
	private String inputData;
	private ArrayList<DataVO> listData = new ArrayList<DataVO>();
	private JTextArea jta;
	private JScrollPane jsp;
	private int count = 1;

	public UseVoWork1217() {

			jta = new JTextArea(10, 40);
			jta.setEditable(false);
			jta.append("번호 이름 자바 오라클 총점 평균\n");
		while(true) {
			selectDialog();
			if (selectMenu.equals("1".trim())) {
				inputDialog();
				
			} else if (selectMenu.equals("2".trim())) {
				if (listData.isEmpty()) {
					outputNotDataMessage();
					return;
				} else {
					showList();
				}
			} else if (selectMenu.equals("3".trim())) {
//				closeWindow();
				break;
			} else {
				JOptionPane.showMessageDialog(this, "잘못입력하셨습니다");
				selectDialog();
			}
		}		
	}//end while


	public void selectDialog() { // 메뉴선택 다이얼로그 창
		selectMenu = JOptionPane.showInputDialog("메뉴선택\n 1.입력 2.출력 3.종료");
	}

	public void inputDialog() { // 점수입력 다이얼로그 창

		inputData = JOptionPane.showInputDialog("데이터입력 \n 예)이름, 자바점수, 오라클점수");
		String[] check = inputData.split(",");
		
		DataVO dataVo = new DataVO();
		
		dataVo.setName(check[0]);
		dataVo.setJavaScore(Integer.parseInt(check[1]));
		dataVo.setOracleScore(Integer.parseInt(check[2]));
		
		listData.add(dataVo);
		listData.get(0).getName();
		listData.get(1).getJavaScore();
		
		if (check.length != 3) {
			JOptionPane.showMessageDialog(this, "입력데이터의 형태는 \n번호,이름,주소,이메일 이어야 합니다.", "입력오류",
					JOptionPane.ERROR_MESSAGE);
			return;
		} // end if
		inputToList();
	}

	public void outputNotDataMessage() { // 데이터 없는 메시지 다이얼로그 창
		JOptionPane.showMessageDialog(null, "데이터가 없습니다");
	}

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
			System.out.println(sum);
			avg = sum / 2;
			System.out.println(avg);
			list.add(String.valueOf(sum+"   "));
			list.add(String.valueOf(avg+"   "));
			list.add("\n");
			System.out.println(list);
		}
	}

	public void showList() {
		StringTokenizer stk = new StringTokenizer(list.toString(),",.[.]");
		StringBuffer s= new StringBuffer();
		System.out.println(stk.countTokens());
		while(stk.hasMoreTokens()){
			s.append(stk.nextToken());
        }
		System.out.println(s);
		jta.append(String.valueOf(s));
		jsp = new JScrollPane(jta);
		JOptionPane.showMessageDialog(null,jsp);
		selectDialog();
	}

	public void closeWindow() {
		dispose();
	}

	public static void main(String[] args) {
		new Work1217();
	}// main
}
