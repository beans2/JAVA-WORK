package day1218;

/**
 * ��������� ����ó�� Ŭ����
 * @author owner
 */
//1. Exception�̳� RunTimeException�� ��� �޴´�.
@SuppressWarnings("serial")
public class TobaccoException extends Exception{
	
	public TobaccoException() {
		super("��迹�� - ����� ���� ��! �׷��� �ǿ�ðڽ��ϱ�?");
	}
	public TobaccoException(String msg) {
		super(msg);
	}
	
	public static void main(String[] args) {

	}

}//class
