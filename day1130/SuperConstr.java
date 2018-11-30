package day1130;

public class SuperConstr {
	int i;
	public SuperConstr() {
		System.out.println("부모의 기본 생성자");
	}
	public SuperConstr(int i) {
		this();
		this.i=i;
		System.out.println("부모의 인자 생성자"+i);
	}
}
