package day1120;

/**
 *Continue:반복문 내의 반복 실행 코드의 수행을 건너 뛰는 일<br>
 *
 * @author owner
 */
public class TestContinue {

	public static void main(String[] args) {
		//0~100 까지 홀수만 출력
		for(int i=0; i<100;i++) {
			if(i%2==0) {
				continue;
			}
			System.out.println("i= "+i);
		}
	}//main

}//class
