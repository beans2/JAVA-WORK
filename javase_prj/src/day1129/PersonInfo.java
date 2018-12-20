package day1129;

public class PersonInfo {
	private int num;
	private String name;
	private String addr;
	private int age;
	private String gender;
	private int countS;
	private int sumAge;
	private String oldName;
	private String oldGenger;
	public PersonInfo() {
		
	}
	public PersonInfo(int num, String name, String addr, int age, String gender) {
		this.num = num;
		this.name = name;
		this.addr = addr;
		this.age =age;
		this.gender = gender;
	}
	public void setNum(int num) {
		this.num= num;
	}
	public void setName(String name) {
		this.name=name;
	}
	public void setAddr(String addr) {
		this.addr=addr;
	}
	public void setAge(int age) {
		this.age=age;
	}
	public void setGender(String gender) {
		this.gender=gender;
	}
	/////////////////end set//////////////////////////
	public int getNum() {
		return num;
	}
	public String getName() {
		return name;
	}
	public String getAddr() {
		return addr;
	}
	public int getAge() {
		return age;
	}
	public String getGender() {
		return gender;
	}


}
