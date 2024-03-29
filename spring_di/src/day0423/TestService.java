package day0423;

public class TestService {
	private TestDAO td;//의존성 주입받은 객체를 사용할 수 있도록 instance변수로 선언
	
	 //interface를 의존성 주입 받으면 약결합이 된다.
	public TestService(TestDAO td) {
		this.td=td;
		System.out.println("생성자 의존성 주입");
	}//TestService
	
	public TestService() {
		System.out.println("기본 생성자를 사용하여 객체 생성");
	}
	
	//method 의존성 주입: 반드시 기본 생성자가 존재해야한다.
	public void setTd(TestDAO td) {
		this.td=td;
	}//setTd
	
	public TestDAO getTd() {
		return td;
	}//getTd
}
