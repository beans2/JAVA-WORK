package day1221;

import java.io.Serializable;

/**
 * 데이터를 가지고 있는 클래스로 직렬화 대상 클래스
 * @author owner
 */
public class UserData implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1433112021624942952L; //내보낸 코드의 변형이 있을 수 있으므로 검증하기 위해 사용한다. 
	private int age;
	private/* transient*/ double weight;
	private /*transient*/ String name;
	
	//transient: 직렬화를 방지 키워드(값이 JVM외부로 전달 되지 않는다.) 
	public UserData() {
	}
	public UserData(int age, double weight, String name) {
		super();
		this.age = age;
		this.weight = weight;
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "UserData [age=" + age + ", weight=" + weight + ", name=" + name + "]";
	}
}//class
