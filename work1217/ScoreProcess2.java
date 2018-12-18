package work1217;

import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import static java.lang.Integer.parseInt;

/**
 * 
 * @author owner
 */
@SuppressWarnings("serial")
public class ScoreProcess2  {
	private ArrayList<ScoreVO> listStu;
	private int totalScore;
	
	

	public static final int INPUT_DATA = 1;
	public static final int VIEW_DATA = 2;
	public static final int EXIT = 3;
	
	public ScoreProcess2() {
		listStu = new ArrayList<ScoreVO>();
	}

	/**
	 * 선택메뉴제공
	 */
	public void inputMenu() {
		String selectMenu = "", inputResult = "";
		boolean exitFlag = false;
		do {
			selectMenu = JOptionPane.showInputDialog("메뉴선택\n1.입력 2.출력 3.종료");
			try {
				switch (parseInt(selectMenu)) {
				case INPUT_DATA:
					inputResult = "데이터의 갯수가 맞지 않거나, 점수는 숫자형태여야합니다.";
					if (inputData()) {
						inputResult = "추가 성공";
					} // end if
					JOptionPane.showMessageDialog(null, inputResult);
					break;
				case VIEW_DATA:
					printData(); 
					break;
				case EXIT:
					exitFlag = true;
					break;
				default:
					JOptionPane.showMessageDialog(null, "메뉴는 1,2,3 중 하나이어야합니다");
				}//endswitch2
			} catch (NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null, "메뉴는 숫자 이어야 합니다.");
			}

		} while (!exitFlag);

	}// inputMenu

	/**
	 * 정보처리할 데이터를 입력받기
	 * 
	 * @return
	 */
	public boolean inputData() {
		boolean flag = false;

		String inputData = JOptionPane.showInputDialog("데이터입력\n예)이름,자바점수,오라클점수");
		try {
			String[] data = inputData.replaceAll(" ", " ").split(",");
			if (data.length == 3) {// 입력형식에 맞을 때
				// 자바점수와 오라클 점수는 숫자 이어야한다.
				try {
					ScoreVO sv = new ScoreVO(data[0], parseInt(data[1]), parseInt(data[2]));
					listStu.add(sv); // 정제된 데이터를 list에 추가
					flag = true; // 실행결과를 저장
				} catch (NumberFormatException nfe) {
					flag = false;
				}
			} // end if
		} catch (NullPointerException npe) {
//			npe.printStackTrace();
		}

		return flag;
	}// inputData

	/**
	 * 입력정보를 출력하는 일
	 */
	public void printData() {
		if(listStu.size()==0) {
			JOptionPane.showMessageDialog(null,"출력할 데이터가 없습니다.");
			return;
		}//end if
		
		StringBuilder viewData = new StringBuilder();
		viewData
		.append("----------------------------------------------------------\n")
		.append("번호\t이름\t자바\t오라클\t총점\t평균\n").
		append("-----------------------------------------------------------\n");
		int tempTotal =0;
		ScoreVO sv =null;
		for(int i=0; i<listStu.size();i++) {
			sv=listStu.get(i);
			tempTotal = sv.getJavaScore() + sv.getOracleScore();
			viewData.append(i+1)
			.append("\t").append(sv.getName())
			.append("\t").append(sv.getJavaScore())
			.append("\t").append(sv.getOracleScore())
			.append("\t").append(tempTotal)
			.append("\t").append(tempTotal/2.0).append("\n");
			
			//한 학생의 자바점수와 오라클 점수를 더한 값을 누적합
			totalScore +=tempTotal;
			tempTotal=0; //한 학생의 총점변수를 초기화			
		}//end for
		viewData.append("-----------------------------------------------------------\n")
		.append("\t\t\t\t총점").append(totalScore).append("\t평균")
		.append(String.format("%.2f", totalScore/(double)(listStu.size()*2)));
		totalScore = 0;
		JTextArea jta = new JTextArea(15,50);
		jta.append(viewData.toString()); //화면을 구성한 데이터를 JTA에 붙여준다.
		JScrollPane jsp = new JScrollPane(jta);
		JOptionPane.showMessageDialog(null, jsp);
				
	}// printData

	public static void main(String[] args) {
		ScoreProcess2 sp = new ScoreProcess2();
		sp.inputMenu();
	}// main
}
