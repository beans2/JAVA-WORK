package day0423;

public class TestService {
	private TestDAO td;//������ ���Թ��� ��ü�� ����� �� �ֵ��� instance������ ����
	
	 //interface�� ������ ���� ������ ������� �ȴ�.
	public TestService(TestDAO td) {
		this.td=td;
		System.out.println("������ ������ ����");
	}//TestService
	
	public TestService() {
		System.out.println("�⺻ �����ڸ� ����Ͽ� ��ü ����");
	}
	
	//method ������ ����: �ݵ�� �⺻ �����ڰ� �����ؾ��Ѵ�.
	public void setTd(TestDAO td) {
		this.td=td;
	}//setTd
	
	public TestDAO getTd() {
		return td;
	}//getTd
}
