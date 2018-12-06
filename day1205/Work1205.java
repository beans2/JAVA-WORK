package day1205;

import java.util.StringTokenizer;

public class Work1205 {

	public Work1205() { // 생성자

	}// Work1205

	/**
	 * 
	 * 2018-12-05 숙제<br>
	 * 1. 1~45 사이의 수 중에서 무작위로 하나를 뽑아 6개의 세트를 만들어 배열로 반환하는 method를 만들고, 호출하여 출력할 것.
	 * (단, 중복된 수는 배열에 입력되지 않아야 한다.)<br>
	 * 
	 * @return 로또번호
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
			} // 중복제거
		} // end for
		for(int i=0;i<rottoNum.length;i++) {
			System.out.print(rottoNum[i]+" ");
		}
		System.out.println();
		return rottoNum;
	}// lotto

	public String[] cutStr() {
		String names = "이재찬,이재현.공선의,정택성~이재현!최지우.김희철,이재찬,이재찬,정택성.공선의";
		StringTokenizer stk2 = new StringTokenizer(names, ",.~! ");
//		System.out.println("토큰의 수: " +stk2.countTokens());
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
		int[] lot = new int[6]; // 로또값 확인
		lot = wk.lotto();
		System.out.print("로또 값: ");
//		for(int k=0; k<100;k++) {
//			for (int i = 0; i < 6; i++) {
//				wk.lotto();
//				lot = wk.lotto();
//				System.out.print(lot[i] + " ");
//			}		
//			System.out.println();
//		}
		wk.cutStr();
		String[] str = new String[11];// 토큰이 잘 들어갔는지 확인
		str = wk.cutStr();
		for (int i = 0; i < 11; i++) {
			System.out.print(str[i] + " ");
		}

	}

}
