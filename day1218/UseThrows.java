package day1218;

import java.util.Random;

/**
 *method 내에서 발생한 예외를 method를 호출한 곳에서 처리하는 throws의 사용
 * @author owner
 */
public class UseThrows {
	public void test() throws ClassNotFoundException{
		//throws로 예외를 날리면 method안에 try~catch를 할 필요가 없다.\
		String className = "day1217.UseRuntimeException";
		Object obj =Class.forName(className);		
		if(new Random().nextBoolean()) {
			className = "java.long.Integer";
		}//end if
			

		System.out.println("클래스 로딩"+obj);
	}//test
	public static void main(String[] args) {
		UseThrows ut = new UseThrows();
		try {
			ut.test();
		} catch (ClassNotFoundException cnfe) {
			System.out.println("죄송합니다");
			cnfe.printStackTrace();
			System.out.println("정상출력");
		}
	}

}
