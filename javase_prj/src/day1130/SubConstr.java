package day1130;

public class SubConstr extends SuperConstr{
	int i;
	public SubConstr() {
		this(200);
		System.out.println("�ڽ��� �⺻ ������");
	}
	public SubConstr(int i) {
		super(300);
		System.out.println("�ڽ��� ���� ������"+i);
	}

}
