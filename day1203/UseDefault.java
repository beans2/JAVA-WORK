package day1203;

/**
 *default method : �������̽����� ����(�ڹ��ڵ�)�� ����� �� �ִ� method
 *default method�� ȣ���ҷ��� ���� Ŭ������ is a ������ ��üȭ�� �ؾ߸� �Ѵ�.
 * @author owner
 */
public interface UseDefault {
	public void test();
	
	public default void temp() {
		System.out.println("����ó�� �ڵ� ����");
	}//temp
}//interface
