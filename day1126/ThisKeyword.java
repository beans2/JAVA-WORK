package day1126;

/**
 * method를 호출하는 객체의 주소로 변경되어 사용되는 this.
 * @author owner
 */
public class ThisKeyword {
	int i;
	/**
	 * parameter의 이름과 instance 변수의 이름이 같을 때 
	 * this를 사용하지 않고 parameter의 값을 인스턴스 변수로 저장할 때. 
	 */
	public void useInstance(int i,ThisKeyword t) {
		t.i=i; //파라메터(stack) 변수의 값을 인스턴스(heap) 변수에 할당 하겠습니다.
		System.out.println("전달받은 객체" +t);
	}//useInstance	 
	/**
	 *파라미터의 이름과 인스턴스 이름이 같을 때마다 객체를 넘기고 받아서 사용하려면 코딩시
	 *불편함이 따라온다. 개선하기 위해 this가 제공
	 * @param i
	 */
	public void useThis(int i){
		//this는 method를 호출하는 객체의 주소로 변환되는 키워드
		//매개변수로 객체를 받을 필요가 없다.
		this.i=i;
		System.out.println("method를 호출한 객체의 주소 " + this);
	}//useThis
	
	public static void test() {
//		this.i=10;//static method안에서는 this keyword를 사용할 수 없다.
		System.out.println("static method");
	}
	
	public static void main(String[] args) {
		ThisKeyword tk= new ThisKeyword();
		System.out.println("생성된 객체"+tk);
		tk.useInstance(300, tk);
		System.out.println("전달한 객체의 인스턴스 변수의 값 "+tk.i);
		System.out.println("++++++++++++++++++++++++++++++");
		tk.useThis(900);
		System.out.println("this를 사용하여 변경한 인스턴스 변수의 값 "+tk.i);
		
		ThisKeyword.test();
	}//main

}//class
