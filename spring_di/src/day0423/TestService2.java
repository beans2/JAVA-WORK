package day0423;

public class TestService2 {
	private TestDAO td;//������ ���Թ��� ��ü�� ����� �� �ֵ��� instance������ ����
	private TestDAO2 td2;
	
	 //interface�� ������ ���� ������ ������� �ȴ�.
	public TestService2(TestDAO td, TestDAO2 td2) {
		this.td=td;
		this.td2=td2;
		System.out.println("�Ű������� �������� ������ ������ ����");
	}//TestService2
	
}
