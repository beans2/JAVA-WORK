package day1203;

/**
 *구현클래스(자식클래스)에서 반드시 구현해야하는 일의 목록만 정의하는 interface 사용법.(구현의 강제성)
 * @author owner
 */
//intetface는 부모를 여러개 가질 수 있다.
public interface SuperInterface extends InterA,InterB{
	//constant: 변수를 상수처럼 사용.
//	int i // 변수는 작성할 수 없다
	public static final int FLAG_VALUE=12;
	
	//추상method구성
	//일반 method는 가질 수 없다,
//	public void test() {
//		
//	}
	//인터페이스간 상속에는 추상method를 Override 하지 않는다.
	//abstract을 사용하지 않아도 된다.
	public void methodA();
	//abstract를 사용해도 된다.
	public abstract void methodB(int i);
}//intetface
