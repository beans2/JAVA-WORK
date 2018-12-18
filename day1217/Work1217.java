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
				JOptionPane.showMessageDialog(this, "�߸��Է��ϼ̽��ϴ�");
			}
		}//end while		
	}//Work1217

	public void selectDialog() { // �޴����� ���̾�α� â
		selectMenu = JOptionPane.showInputDialog("�޴�����\n 1.�Է� 2.��� 3.����");
	}//selectDialog

	public void inputDialog() { // �����Է� ���̾�α� â

		inputData = JOptionPane.showInputDialog("�������Է� \n ��)�̸�, �ڹ�����, ����Ŭ����");
		String[] check = inputData.split(",");
		if (check.length != 3) {
			JOptionPane.showMessageDialog(this, "�Էµ������� ���´� \n��ȣ,�̸�,�ּ�,�̸��� �̾�� �մϴ�.", "�Է¿���",
					JOptionPane.ERROR_MESSAGE);
			return;
		} // end if
		inputToList();
	}//inputDialog

	public void outputNotDataMessage() { // ������ ���� �޽��� ���̾�α� â
		JOptionPane.showMessageDialog(null, "�����Ͱ� �����ϴ�");
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
		jta.append("��ȣ �̸� �ڹ� ����Ŭ ���� ���\n");
		jta.append(String.valueOf(s));
		JScrollPane jsp;
		jsp = new JScrollPane(jta);
		JOptionPane.showMessageDialog(null,jsp);
	}//showList
	
	public static void main(String[] args) {
		new Work1217();
	}// main
}
