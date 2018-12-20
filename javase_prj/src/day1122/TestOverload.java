package day1122;

/**
 *다형성: method Overload<br>
 * 하나의 클래스에서 같은 이름의 method를 여러개 작성하는 것<br>
 * 규칙) 접근지정자 반환형 method명은 같게 만들고,
 * 			매개변수만 다르게 작성
 * @author owner
 */
public class TestOverload {
	
	/**
	 * ★을 하나 출력하는 일
	 */
	public void printStar() {
		System.out.println("★");
	}//printStar
	/**
	 * 입력되는 값에 따라 ★을 여러개 출력하는 일
	 * @param count 출력할 별의 개수
	 */
	public void printStar(int count) {
		for(int i=0;i<count;i++) {
			System.out.println("☆");			
		}
	}
	/**
	 * 구구단 3단을 출력하는 method
	 */
	public void printGugudan() {
		int i=3;
			System.out.println("구구단 3단 출력입니다");
			for(int j=2;j<10;j++) {
				System.out.println(i+" * "+j+" = "+i*j);
			}
	}//printGugudan
	/**
	 * 입력하는 단이 2~9단 사이일 때 해당 단부터 9단까지를 출력하는 method
	 * @param dan 구구단을 시작할 단 매개변수
	 */
	public void printGugudan(int dan) {	
		System.out.println(dan+" 단 부터 9단까지의 출력입니다.");
		System.out.println();
		for(int i=dan;i<10;i++) {
			for(int j=1;j<10;j++) {
				System.out.println(i+" * "+j+" = "+i*j);
			}
		}//end for
	}
	
	public static void main(String[] args) {
		TestOverload to = new TestOverload();
		//별 1개 출력
		to.printStar();
		//별 5개 출력
		to.printStar(5);
		
		//구구단 3단을 출력하는 method
		
		//입력하는 단이 2~9단 사이일 때 해당 단부터 9단까지를 출력하는 method
		to.printGugudan();
		System.out.println("--------------------------");
		int i= Integer.parseInt(args[0]);
		if(i>1&&i<10) {
			to.printGugudan(i);
		}
	}//main
}//class
