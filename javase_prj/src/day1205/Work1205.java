package day1205;

import java.util.StringTokenizer;

public class Work1205 {

	public Work1205() { // ������

	}// Work1205

	/**
	 * 
	 * 2018-12-05 ����<br>
	 * 1. 1~45 ������ �� �߿��� �������� �ϳ��� �̾� 6���� ��Ʈ�� ����� �迭�� ��ȯ�ϴ� method�� �����, ȣ���Ͽ� ����� ��.
	 * (��, �ߺ��� ���� �迭�� �Էµ��� �ʾƾ� �Ѵ�.)<br>
	 * 
	 * @return �ζǹ�ȣ
	 */
	public int[] lotto() {
		int[] rottoNum = new int[6];

		for (int i = 0; i < rottoNum.length; i++) {
			rottoNum[i] = (int) (Math.random()*45+1);
			for (int j = 0; j < i; j++) {
				if (rottoNum[i] == rottoNum[j]) {
					i--;
					break;
				}
			} // �ߺ�����
		} // end for
		for(int i=0;i<rottoNum.length;i++) {
			System.out.print(rottoNum[i]+" ");
		}
		System.out.println();
		return rottoNum;
	}// lotto

	public String[] cutStr() {
		String names = "������,������.������,���ü�~������!������.����ö,������,������,���ü�.������";
		StringTokenizer stk2 = new StringTokenizer(names, ",.~! ");
//		System.out.println("��ū�� ��: " +stk2.countTokens());
		int tokenNum = stk2.countTokens();
//		System.out.println(tokenNum);
		String[] cutting = new String[tokenNum];
//		System.out.println(cutting.length);
		for (int i = 0; i < tokenNum; i++) {
			cutting[i] = stk2.nextToken();
//			System.out.println(cutting[i]);
		}
//		System.out.println(tokenNum);
		return cutting;
	}

	public static void main(String[] args) {
		Work1205 wk = new Work1205();
//		wk.lotto();
		int[] lot = new int[6]; // �ζǰ� Ȯ��
		lot = wk.lotto();
		System.out.print("�ζ� ��: ");
//		for(int k=0; k<100;k++) {
//			for (int i = 0; i < 6; i++) {
//				wk.lotto();
//				lot = wk.lotto();
//				System.out.print(lot[i] + " ");
//			}		
//			System.out.println();
//		}
		wk.cutStr();
		String[] str = new String[11];// ��ū�� �� ������ Ȯ��
		str = wk.cutStr();
		for (int i = 0; i < 11; i++) {
			System.out.print(str[i] + " ");
		}

	}

}
