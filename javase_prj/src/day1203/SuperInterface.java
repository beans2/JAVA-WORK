package day1203;

/**
 *����Ŭ����(�ڽ�Ŭ����)���� �ݵ�� �����ؾ��ϴ� ���� ��ϸ� �����ϴ� interface ����.(������ ������)
 * @author owner
 */
//intetface�� �θ� ������ ���� �� �ִ�.
public interface SuperInterface extends InterA,InterB{
	//constant: ������ ���ó�� ���.
//	int i // ������ �ۼ��� �� ����
	public static final int FLAG_VALUE=12;
	
	//�߻�method����
	//�Ϲ� method�� ���� �� ����,
//	public void test() {
//		
//	}
	//�������̽��� ��ӿ��� �߻�method�� Override ���� �ʴ´�.
	//abstract�� ������� �ʾƵ� �ȴ�.
	public void methodA();
	//abstract�� ����ص� �ȴ�.
	public abstract void methodB(int i);
}//intetface
