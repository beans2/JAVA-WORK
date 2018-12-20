package day1123;

/**
 * ����� ��üȭ�ؼ� ���� Ŭ����<br>
 * �����Ư¡: ��߱���, ���� ����, ����Ŀ<br>
 * ������Ư¡: ������
 * @author owner
 *
 */
public class Ramen {
	private String name,thickness,maker;
	private int soupnum;
	
	public Ramen() {
		this("�ʱ���","����","���",3);
	}
	public Ramen(String name, String thickness, String maker, int soupnum) {
		this.name = name;
		this.thickness = thickness;
		this.maker = maker;
		this.soupnum = soupnum;
	}
	
	/**
	 * ������ ��鰴ü�� �̸��� �����ϴ� �� 
	 * @param name ����̸�
	 */
	public void setName(String name) {
		this.name=name;
	}//setName
	
	/**
	 * ������ ��鰴ü�� ��߱��⸦ �����ϴ� ��<br>
	 * ���� "����", "�߰�", "����"�� �ƴ� ���� �Էµȴٸ�<br>
	 * "�߰�"���� ��������
	 * @param thickness ��߱���
	 */
	public void setThickness(String thickness) {
		if(!(thickness.equals("����")||thickness.equals("�߰�")
			||thickness.equals("����"))) {
			thickness = "�߰�";
		}
		this.thickness=thickness;
	
	}//setThickness
	
	/**
	 * ������ ��� ��ü�� ����Ŀ�� �����ϴ� ��
	 * @param maker
	 */
	public void setMaker(String maker) {
		this.maker=maker;
	}//setMaker
	
	/**
	 * ������ ��� ��ü�� ���������� �����ϴ� ��
	 * @param soupnum
	 */
	public void setSoupnum(int soupnum) {
		this.soupnum=soupnum;
	}//setSoupnum
	
	/**
	 * ������ ��鰴ü�� �̸��� ��ȯ�ϴ� ��
	 * @return ����̸�
	 */
	public String getName() {
		return name;
	}//getName
	
	/**
	 * ������ ��鰴ü�� ��߱��⸦ ��ȯ�ϴ� ��
	 * @return ��߱���
	 */ 
	public String getThickness() {
		return thickness;
	}//getThickness
	
	/**
	 * ������ ��鰴ü�� ����Ŀ�� ��ȯ�ϴ� ��
	 * @return ����Ŀ
	 */
	public String getMaker() {
		return maker;
	}//getMaker
	
	/**
	 * ������ ��鰴ü�� ���������� ��ȯ�ϴ� ��
	 * @return ��������
	 */
	public int getSoupnum() {
		return soupnum;
	}//getSoupnum
	
	/**
	 * ������Ư¡<br>
	 * ������ ��鰴ü�� ���� ���� ����
	 * @return ���
	 */
	public String boil() {
		return name+"����� ���� ���̴�";
	}
	/**
	 * ������ ��鰴ü�� ������ϴ� �ð�(��)�� �˷��ִ� ���� ����
	 * @param time ���� �ð�
	 * @return ���
	 */
	public String boil(String time) {
		return name+"�����"+time+" �������Ѵٰ� �����ִ�";
	}
	
	
}
