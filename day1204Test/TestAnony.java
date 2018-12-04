package day1204Test;

/**
 * 인터페이스가 method의 매개변수일 때 간단하게 사용하는 방법.<br>
 * 
 * @author owner
 */
public class TestAnony {
	public void mixMsg(AnonyInter ai) {
		System.out.println(ai.getMsg()+" "+ai.getName());
	}
	public static void main(String[] args) {
		//1.구현 클래스의 객체화
		AnonyImpl an= new AnonyImpl();
		//2. mixMsg를 출력하기 위해 객체화
		TestAnony ta= new TestAnony();
		//3. 메소드 호출
		ta.mixMsg(an);
		
		/////////////////////////////////////anonymous 사용////////////////////////////////////////////
		ta.mixMsg(new AnonyInter() {
			
			@Override
			public String getName() {
				return "최홍만임다";
			}
			
			@Override
			public String getMsg() {
				return "안녕하쇼"+test();
			}
			public String test() {
				return "자식매소드입니다";
			}
		});

	
		
	}//main

}//class
