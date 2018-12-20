package day1204;

/**
 * 내부클래스를 static 변수처럼 사용할 수 있는 중첩클래스.
 * @author owner
 */
public class NestedOuter {
	
	int i;
	static int j;
	
	public NestedOuter() {
		System.out.println("바깥 클래스의 생성자");
	}//NestedOuter
	
	public void outInstMethod() {
		System.out.println("바깥 클래스의 인스턴스 method");
	}//outInstMethod
	
	public static void outStatMethod() {
		System.out.println("바깥 클래스의 static method");
	}//outStatMethod
	
	//////////////////Nested class 시작///////////////////////////////////////////////////////////////
	static class NestedInner{
//		int in_i;//intstance 변수 //만들 수는 있으나 권장하지 않음
		static int in_j; //static 변수
		
//		public NestedInner() {
//		}
		public void inMethod() {
			System.out.println("안쪽 클래스의 instance method");
		}//inMethod
		
		public static void inStatMethod() {
			System.out.println("안쪽 클래스의 static method");
			System.out.println("바깥 클래스의 자원 사용. i = 사용불가, j="+NestedOuter.j);
//			outInstMethod(); // instance method 이므로 사용할 수 없다.
			NestedOuter.outStatMethod();
		}
	}//class
	//////////////////Nested class 끝///////////////////////////////////////////////////////////////////

	public static void main(String[] args) {
		//static 영역을 사용할 때에는 객체화없이 클래스명.변수명, 
		//클래스명.method명 으로 사용한다.
		NestedInner.inStatMethod();
	}//main

}//class
