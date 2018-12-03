package day1203;

/**
 *����� �߻�ȭ�Ͽ� ���� Ŭ����<br>
 *�����Ư¡: ��,��,��, �̸�<br>
 *������Ư¡: �Դ´�<br>
 *
 *��üȭ)Person ��ü��=new Person();<br>
 *		������ ��ü�� �Դ� ���� �� �� �ִ�.<br>
 *
 *person�� �Ϲ� Ŭ�������� abstract Ŭ������ ���� <br>
 *��� ����� ������ �Դ� �ϰ� �ۿ��� ��Դ� ��, �� �ݵ�� ������.
 * @author owner
 */
public abstract class Person { 
	private String name; //�̸�
	private int eye, nose, mouse;//��,��,��
	private String[] language;// ����� ����ϴ� ���
	
	/**
	 * ���Ŭ������ �⺻ ������<br>
	 * ��2�� , ��1��, ��1���� ���� ��� ��ü�� ����
	 */
	public Person() {
		this(2,1,1);
//		eye=2;
//		nose=1;
//		mouse =1;
	}//person
	/**
	 * �� 2��, ��1�� ,��1���� �ƴ� ����� ��ü�� ������ �� ����ϴ� ������
	 * �� �߰��� �� �ֵ��� 
	 * @param eye ���Ǽ�
	 * @param nose ���Ǽ�
	 * @param mouse ���Ǽ�
	 */
	public Person(int eye, int nose, int mouse) {
		this.eye=eye;
		this.nose=nose;
		this.mouse =mouse;
		language = new String[10];
	}
	
	/**
	 * ������ ��� ��ü�� �̸��� �����ϴ� ��
	 * @param name �̸�
	 */
	public void setName(String name) {
		this.name = name;
	}//name
	/**
	 * ������ ��� ��ü�� ���� �����ϴ� ��<br>
	 * ������ ���� ������ �ִ� 3������ ������ �� �ִ�.<br>
	 * 3���� �Ѿ�� 2���� �����Ѵ�
	 * @param eye ���� ����
	 */
	public void setEye(int eye) {
		if(eye>3) {
			eye=2;
		}
		this.eye= eye;			
	}//eye
	/**
	 * ������ ��� ��ü�� �ڸ� �����ϴ� ��.
	 * @param nose ���� ����
	 */
	public void setNose(int nose) {
		this.nose= nose;
	}//nose
	/**
	 * ������ ��� ��ü�� ���� ������ �����ϴ� ��.
	 * @param mouse ���� ����
	 */
	public void setMouse(int mouse) {
		this.mouse= mouse;
	}//mouse
	
	/**
	 * ������ ��� ��ü�� �̸��� ��ȯ�ϴ� ��.
	 * @return ���� ��ü�� �̸�
	 */
	public String getName() {
		return name;
	}
	/**
	 * ������ �����ü�� ������ �ִ� ���� ������ ��ȯ�ϴ� ��
	 * @return ���� ����
	 */
	public int getEye() {
		return eye;
	}//eye
	/**
	 * ������ ��� ��ü�� �������ִ� ���� ���� ��ȯ�ϴ� ��
	 * @return ���� ����
	 */
	public int getNose() {
		return nose;
	}//nose
	/**
	 * ������ ��� ��ü�� ������ �ִ� ���� ���� ��ȯ�ϴ� ��
	 * @return ���� ����
	 */
	public int getMouse() {
		return mouse;
	}//mouse
	
	public String[] getLanguage() {
		return language;
	}//
	
	/**
	 * ������ Ư¡<br>
	 * ������ �����ü�� ������ ���� �Դ� �� ����.
	 * @return ���
	 */
	public abstract String eat() ;
	/**
	 * method overload :������ -���� �̸��� method�� ������ �����ϴ� ���.
	 * ������ �����ü�� �Ĵ翡�� �ֹ��� ������ �Դ� ���� ����
	 * @param menu ������ ����
	 * @param price ������ ����
	 * @return ���
	 */
	public abstract String eat(String menu,int price);
	

	/**
	 * ����� �� ������ �� �� �ִ�.
	 * @return �Ҽ��ִ� ���
	 */
	public abstract String[] language(String lang);
	
}//class
