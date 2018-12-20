package day1126;

/**
 *this르 사용한 생성자호출 
 * @author owner
 */
public class ThisConstructor {
	public ThisConstructor(){
//		this(26);
		System.out.println("기본생성자");
	}//ThisConstructor
	public ThisConstructor(int i){
		this();
		System.out.println("인자있는 생성자");
//		this(); //생성자의 첫번째 줄어섬나 사용가능.
	}//ThisConstructor
	public static void main(String[] args) {
		new ThisConstructor(22); 
	}

}
