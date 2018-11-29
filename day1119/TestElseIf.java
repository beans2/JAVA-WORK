package day1119;

/**
 * else ~if : 연관된 여러 조건을 비교할 때.<br>
 * 문법)if(조건식){<br>
 * 조건에 맞을 때 수행할 문장<br>
 * }else if(조건식){<br>
 * 조건에 맞을 때 수행 문장;<br>
 * }else if(조건식){<br>
 * 조건에 맞을 때 수행 문장;<br>
 * }else if(조건식){<br>
 * 조건에 맞을 때 수행 문장;<br>
 * .<br>
 * .<br>
 * .<br>
 * <br>
 * }else{<br>
 * 모든 조건에 맞지 않을 때 수행문장;<br>
 * }
 * 
 * @author owner
 */
public class TestElseIf {

	public static void main(String[] args) {
		/*
		 * int i=Integer.parseInt(args[0]);
		 * 
		 * System.out.println(i+"는(은)"); if(i < 0) { System.out.println("0보다 작아서 실패");
		 * }else if(i>100) { System.out.println("100보다 커서 실패"); }else {
		 * System.out.println("입력성공"); }//end else
		 */
		// 이름을 입력받아 "이재찬"이면 반장을
		// "이봉현, 박영민, 김정운, 오영근:이면 조장을
		// 그렇지 않으면 "평민"을 이름앞에 출력하세요. "직책 이름"

		/*
		 * String i = args[0];
		 * 
		 * if (i.equals("이재찬")) { System.out.println("반장 " + i); } else if
		 * (i.equals("이봉현") || i.equals("박영민") || i.equals("김정운") || i.equals("오영근")) {
		 * System.out.println("조장 " + i); } else { System.out.println("평민 " + i); }
		 */

		// 태어난 해를 입력받아 띠 구하기
		// 11- 양, 10-말, 9-뱀, 8-용, 7-토끼,6-호랑이,5-소, 4-쥐, 3-돼지,
		// 2-개, 1-닭, 0-원숭이
		int i = Integer.parseInt(args[0]);
		if (i % 12 == 11) {
			System.out.println("양");
		} else if (i % 12 == 10) {
			System.out.println("말");
		} else if (i % 12 == 9) {
			System.out.println("뱀");
		} else if (i % 12 == 8) {
			System.out.println("용");
		} else if (i % 12 == 7) {
			System.out.println("토끼");
		} else if (i % 12 == 6) {
			System.out.println("호랑이");
		} else if (i % 12 == 5) {
			System.out.println("소");
		} else if (i % 12 == 4) {
			System.out.println("쥐");
		} else if (i % 12 == 3) {
			System.out.println("돼지");
		} else if (i % 12 == 2) {
			System.out.println("개");
		} else if (i % 12 == 1) {
			System.out.println("닭");
		} else {
			System.out.println("원숭이");
		}

	}// main

}// class
