package day0313;

/**
 * scope�Ӽ��� ���� �ٸ��� �����Ǵ� ��ü.
 * @author owner
 *
 */
public class CounterVO {
	private int cnt;
	
	public CounterVO() {
		System.out.println("CountVO");
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt += cnt;
	}
	
	
}
