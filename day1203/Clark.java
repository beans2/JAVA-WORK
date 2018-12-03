package day1203;

/**
 *����� ����Ư¡�� Person���� �����ٰ� ����ϰ� �ڽŸ��� Ư¡��
 *������ Ŭ����.
 * @author owner
 */
public final class Clark extends Person implements Fly{
	public int power;
	/**
	 * �⺻������: ��ü�� �����Ǹ� power�� 9�� �����ȴ�.
	 */
	public Clark() {
		super(3,1,1);
		power = 9;
	}
	/**
	 * �ԷµǴ� ���� ������ ���� ���� ��ȭ�� �ް��ϰ� ��ȭ�Ѵ�.
	 * @param stone ��������
	 * @return ���Ǻ�ȭ
	 */
	public String power(String stone) {
		String result="";
		
		if(stone.equals("Ŭ���䳪��Ʈ")) {
			power = 0;
			result="���� ����~(_-_)~";
		}else if(stone.equals("���̾Ƹ��")) {
			power =10;
			result = "�����մϴ�. ~m(^0^)m~";
		}else {
			power=12;
			result = "������. �Ѥ�+";
		}
		return result;
	}	
		@Override
		public String eat(){
			return getName()+" ��(��) ������ ���� �Դ´�.";
		}
		
		@Override
		public String eat(String menu, int price) {
			return getName()+" ��(��) �����������"+menu+"�� ������"+price+"�� ���� ��Դ´�";
		}//eat
		@Override
		public String speed(String speed) {
			return getName()+"�� "+speed+"�� ����";
		}//speed
		public String height(String height) {
			return getName()+"�� "+height+" ����";
		}//height
		
		@Override		
		public String[] language(String lang) {
			String[] tempLang= getLanguage();
			
			int idx=0;
			for(int i=0; i<tempLang.length;i++) {
				if(tempLang[i]!=null) {
					//������ �� �����Ѵٸ� ���� �ε����� ��´�.
					if(lang.equals(tempLang[i])) {
						//�Էµ� �� �̹� �����Ѿ���� �ݺ����� �������� 
						//�ش� �濡 ��� �� �ִ� �ε����� ������.
						break;	
					}//end if
					idx++;
				}//end if
			}//end for
			//������ �߰��ǰ� �ִٸ� �����.: upsert
			tempLang[idx]=lang;
			return tempLang;
			
		}//language

}//class
