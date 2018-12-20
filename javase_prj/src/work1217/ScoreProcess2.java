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
	 * ���ø޴�����
	 */
	public void inputMenu() {
		String selectMenu = "", inputResult = "";
		boolean exitFlag = false;
		do {
			selectMenu = JOptionPane.showInputDialog("�޴�����\n1.�Է� 2.��� 3.����");
			try {
				switch (parseInt(selectMenu)) {
				case INPUT_DATA:
					inputResult = "�������� ������ ���� �ʰų�, ������ �������¿����մϴ�.";
					if (inputData()) {
						inputResult = "�߰� ����";
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
					JOptionPane.showMessageDialog(null, "�޴��� 1,2,3 �� �ϳ��̾���մϴ�");
				}//endswitch2
			} catch (NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null, "�޴��� ���� �̾�� �մϴ�.");
			}

		} while (!exitFlag);

	}// inputMenu

	/**
	 * ����ó���� �����͸� �Է¹ޱ�
	 * 
	 * @return
	 */
	public boolean inputData() {
		boolean flag = false;

		String inputData = JOptionPane.showInputDialog("�������Է�\n��)�̸�,�ڹ�����,����Ŭ����");
		try {
			String[] data = inputData.replaceAll(" ", " ").split(",");
			if (data.length == 3) {// �Է����Ŀ� ���� ��
				// �ڹ������� ����Ŭ ������ ���� �̾���Ѵ�.
				try {
					ScoreVO sv = new ScoreVO(data[0], parseInt(data[1]), parseInt(data[2]));
					listStu.add(sv); // ������ �����͸� list�� �߰�
					flag = true; // �������� ����
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
	 * �Է������� ����ϴ� ��
	 */
	public void printData() {
		if(listStu.size()==0) {
			JOptionPane.showMessageDialog(null,"����� �����Ͱ� �����ϴ�.");
			return;
		}//end if
		
		StringBuilder viewData = new StringBuilder();
		viewData
		.append("----------------------------------------------------------\n")
		.append("��ȣ\t�̸�\t�ڹ�\t����Ŭ\t����\t���\n").
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
			
			//�� �л��� �ڹ������� ����Ŭ ������ ���� ���� ������
			totalScore +=tempTotal;
			tempTotal=0; //�� �л��� ���������� �ʱ�ȭ			
		}//end for
		viewData.append("-----------------------------------------------------------\n")
		.append("\t\t\t\t����").append(totalScore).append("\t���")
		.append(String.format("%.2f", totalScore/(double)(listStu.size()*2)));
		totalScore = 0;
		JTextArea jta = new JTextArea(15,50);
		jta.append(viewData.toString()); //ȭ���� ������ �����͸� JTA�� �ٿ��ش�.
		JScrollPane jsp = new JScrollPane(jta);
		JOptionPane.showMessageDialog(null, jsp);
				
	}// printData

	public static void main(String[] args) {
		ScoreProcess2 sp = new ScoreProcess2();
		sp.inputMenu();
	}// main
}
