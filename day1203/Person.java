package day1203;

/**
 *사람을 추상화하여 만든 클래스<br>
 *명사적특징: 눈,코,입, 이름<br>
 *동사적특징: 먹는다<br>
 *
 *객체화)Person 객체명=new Person();<br>
 *		생성된 객체로 먹는 일을 할 수 있다.<br>
 *
 *person을 일반 클래스에서 abstract 클래스로 변경 <br>
 *모든 사람의 집에서 먹는 일과 밖에서 사먹는 일, 언어를 반드시 가진다.
 * @author owner
 */
public abstract class Person { 
	private String name; //이름
	private int eye, nose, mouse;//눈,코,입
	private String[] language;// 사람이 사용하는 언어
	
	/**
	 * 사람클래스의 기본 생성자<br>
	 * 눈2개 , 코1개, 입1개를 가진 사람 객체를 생성
	 */
	public Person() {
		this(2,1,1);
//		eye=2;
//		nose=1;
//		mouse =1;
	}//person
	/**
	 * 눈 2개, 코1개 ,입1개가 아닌 사람의 객체를 생성할 때 사용하는 생성자
	 * 언어를 추가할 수 있도록 
	 * @param eye 눈의수
	 * @param nose 코의수
	 * @param mouse 입의수
	 */
	public Person(int eye, int nose, int mouse) {
		this.eye=eye;
		this.nose=nose;
		this.mouse =mouse;
		language = new String[10];
	}
	
	/**
	 * 생성된 사람 객체에 이름을 설정하는 일
	 * @param name 이름
	 */
	public void setName(String name) {
		this.name = name;
	}//name
	/**
	 * 생성된 사람 객체의 눈을 설정하는 일<br>
	 * 설정할 눈의 갯수는 최대 3개까지 설정할 수 있다.<br>
	 * 3개가 넘어가면 2개로 설정한다
	 * @param eye 눈의 갯수
	 */
	public void setEye(int eye) {
		if(eye>3) {
			eye=2;
		}
		this.eye= eye;			
	}//eye
	/**
	 * 생성된 사람 객체의 코를 설정하는 일.
	 * @param nose 코의 갯수
	 */
	public void setNose(int nose) {
		this.nose= nose;
	}//nose
	/**
	 * 생성된 사람 객체의 입의 갯수를 설정하는 일.
	 * @param mouse 입의 갯수
	 */
	public void setMouse(int mouse) {
		this.mouse= mouse;
	}//mouse
	
	/**
	 * 생성된 사람 객체에 이름을 반환하는 일.
	 * @return 현재 객체의 이름
	 */
	public String getName() {
		return name;
	}
	/**
	 * 생성된 사람객체가 가지고 있는 눈의 갯수를 반환하는 일
	 * @return 눈의 갯수
	 */
	public int getEye() {
		return eye;
	}//eye
	/**
	 * 생성된 사람 객체가 가지고있는 코의 개수 반환하는 일
	 * @return 코의 갯수
	 */
	public int getNose() {
		return nose;
	}//nose
	/**
	 * 생성된 사람 객체가 가지고 있는 입의 개수 반환하는 일
	 * @return 입의 개수
	 */
	public int getMouse() {
		return mouse;
	}//mouse
	
	public String[] getLanguage() {
		return language;
	}//
	
	/**
	 * 동사적 특징<br>
	 * 생성된 사람객체가 집에서 밥을 먹는 일 구현.
	 * @return 결과
	 */
	public abstract String eat() ;
	/**
	 * method overload :다형성 -같은 이름의 method를 여러개 정의하는 방법.
	 * 생성된 사람객체가 식당에서 주문한 음식을 먹는 일을 구현
	 * @param menu 음식의 종류
	 * @param price 음식의 가격
	 * @return 결과
	 */
	public abstract String eat(String menu,int price);
	

	/**
	 * 사람은 언어를 여러개 할 수 있다.
	 * @return 할수있는 언어
	 */
	public abstract String[] language(String lang);
	
}//class
