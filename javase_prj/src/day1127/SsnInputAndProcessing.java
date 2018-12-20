package day1127;

/**
 * ����1 <br>
 * �ֹι�ȣ �Է¹޾� ó���ϴ� ���α׷� �ۼ� <br>
 * �� �۾��� method �����ϰ� ȣ���Ͽ� ����� �޾Ƽ� ó�� <br>
 * 1-1. �����ڴ� �ֹι�ȣ�� �޾� instance ������ �Ҵ��Ѵ�. <br>
 * -�ν��Ͻ� ������ ���� ���<br>
 * 1-2. �ֹι�ȣ�� ����üũ�Ͽ� 14�ڰ� �ƴϸ� false ��ȯ <br>
 * 1-3. �ֹι�ȣ 6��° �ڸ���'-'�� �ƴϸ� false��ȯ<br>
 * 1-4. �ֹι�ȣ�� ��ȿ�������Ͽ� ��ȿ�ϸ� true/�׷��� ������ false ��ȯ<br>
 * ��ȿ������ - �� �ڸ��� 234567892345�� ���� ���� ���Ͽ� 11�� ���� ���������� ��� 11���� �� ���� ����<br>
 * 10���� ���� �������� �ֹι�ȣ�� ���ڸ��� ���ٸ� true /�׷��� ������ false<br>
 * 1-5. ������� ��ȯ�ϴ� ��. "1988-11-11"<br>
 * 1-6. ���̸� ��ȯ�ϴ� �� 31<br>
 * 1-7. ������ ��ȯ ��,��<br>
 * 1-8. ������/�ܱ��� ��ȯ (1,2,3,4 -������ / 5,6,7,8 -�ܱ���)<br>
 * 1-9. �츦 ��ȯ "���"
 * 
 * @author owner
 */
public class SsnInputAndProcessing {
	String ssn = new String();

	/**
	 * 1-1. �����ڴ� �ֹι�ȣ�� �޾� instance ������ �Ҵ��Ѵ�.
	 * 
	 * @param ssn
	 */
	public SsnInputAndProcessing() {

	};

	public SsnInputAndProcessing(String ssn) {
		this.ssn = ssn;
	}// end 1-1 SsnInputAndProcessing

	/**
	 * 1-2. �ֹι�ȣ�� ����üũ�Ͽ� 14�ڰ� �ƴϸ� false ��ȯ
	 * 
	 * @return üũ���� �ùٸ����� ���� true/flase
	 */
	public boolean ssnLengthCheck() {
		boolean flag = true;
		if (ssn.length() != 14) {
			flag = false;
		}
		return flag;
	}// end 1-2 ssnLengthCheck

	/**
	 * 1-3. �ֹι�ȣ 6��° �ڸ���'-'�� �ƴϸ� false��ȯ
	 * 
	 * @return üũ���� �ùٸ����� ���� true/flase
	 */
	public boolean ssnSixCharCheck() {
		boolean flag = true;
		if (ssn.indexOf("-") != 6) {
			flag = false;
		}
		return flag;
	}// end 1-3 ssnSixCharCheck

	/**
	 * 1-4. �ֹι�ȣ�� ��ȿ�������Ͽ� ��ȿ�ϸ� true/�׷��� ������ false ��ȯ<br>
	 * ��ȿ������ - �� �ڸ��� 234567892345�� ���� ���� ���Ͽ� 11�� ���� ���������� ��� 11���� �� ���� ����<br>
	 * 10���� ���� �������� �ֹι�ȣ�� ���ڸ��� ���ٸ� true /�׷��� ������ false
	 * 
	 * @return �ֹι�ȣ�� ��ȿ�������� true/false
	 */
	public boolean SsnValidCheck() {
		boolean flag = false;
		int sum = 0;
		int checknum = 0;
		int[] ssnnum = new int[13];
		String tempssn = ssn.replaceAll("-", "");

		for (int i = 0; i < 13; i++) {
			ssnnum[i] = tempssn.charAt(i) - 48;
//				System.out.print(ssnnum[i]); // �ֹι�ȣ �� �� ���� Ȯ��
		} // end for
		
		for (int i = 0; i < 12; i++) {
			if (i > 7) {
				sum += ssnnum[i] * (i - 6);
			} else {
				sum = sum + ssnnum[i] * (i + 2);
			}
		} // end for
		checknum = (11 - (sum % 11)) % 10;
		if (ssnnum[12] == checknum) {
			flag = true;
		}
		return flag;
	}// end SsnValidCheck

	/**
	 * 1-5. ������� ��ȯ�ϴ� ��. "1988-11-11"
	 * 
	 * @param ssn �ֹι�ȣ
	 */
	public String returnBrith() {
		String birth = new String();
		if(ssn.charAt(7)=='1'||ssn.charAt(7)=='2'||ssn.charAt(7)=='5'||ssn.charAt(7)=='6') {
			birth = "19".concat(ssn.substring(0, 2)) + "-" + ssn.substring(2, 4) + "-" + ssn.substring(4, 6);			
		}else if(ssn.charAt(7)=='0'||ssn.charAt(7)=='9'){
			birth = "18".concat(ssn.substring(0, 2)) + "-" + ssn.substring(2, 4) + "-" + ssn.substring(4, 6);	
		}else {
			birth = "20".concat(ssn.substring(0, 2)) + "-" + ssn.substring(2, 4) + "-" + ssn.substring(4, 6);	
		}
		return birth;
	}// end returnBrith

	/**
	 * 1-6. ���̸� ��ȯ�ϴ� ��
	 * 
	 * @return ����
	 */
	public int returnAge() {
		int age = 0;
		if(ssn.charAt(7)=='1'||ssn.charAt(7)=='2'||ssn.charAt(7)=='5'||ssn.charAt(7)=='6') {
			age = 2019 - Integer.parseInt("19" + ssn.substring(0, 2));			
		}else if(ssn.charAt(7)=='0'||ssn.charAt(7)=='9'){
			age = 2019 - Integer.parseInt("18" + ssn.substring(0, 2));	
		}else {
			age = 2019 - Integer.parseInt("20" + ssn.substring(0, 2));
		}
		
		return age;
	}// end returnAge

	/**
	 * 1-7. ������ ��ȯ ��,��
	 * 
	 * @return ���� (��/��)
	 */
	public char returnGender() {
		char validnum = ssn.charAt(7);
		char gender = ' ';
		if (validnum == '1' || validnum == '3' || validnum == '5' || validnum == '7' || validnum == '9') {
			gender = '��';
		} else {
			gender = '��';
		}
		return gender;
	}// end returnGender
	
	/**
	 * 1-8. ������/�ܱ��� ��ȯ (1,2,3,4 -������ / 5,6,7,8 -�ܱ���)
	 * @return ������/�ܱ��� ��ȯ
	 */
	public String returnNational() {
		String nation = "";
		char validnum = ssn.charAt(7);
		if (validnum == '1' || validnum == '2' || validnum == '3' || validnum == '4' || validnum == '9') {
			nation = "������";
		} else {
			nation = "�ܱ���";
		}
		return nation;
	}//end returnNational
	
	/**
	 * 1-9. �츦 ��ȯ "���"
	 * @return ��
	 */
	public String returnTti() {
//		String tti = "";
		String year =returnBrith().substring(0, 4);
		//System.out.println(year);
//		int birth=Integer.parseInt(year)%12;
		int check=Integer.parseInt(year)%12;
		String [] animal = {"�����̶�", "�߶�","����","������","���","�Ҷ�","ȣ���̶�","�䳢��","���","���","����","���"};
		return animal[check];
//		switch(Integer.parseInt(year)%12) {
//		case 0 :
//			tti =  "�����̶�"; break;
//		case 1 :
//			tti = "�߶�"; break;
//		case 2 :
//			tti = "����"; break;
//		case 3 :
//			tti = "������"; break;
//		case 4 :
//			tti = "���"; break;
//		case 5 :
//			tti = "�Ҷ�"; break;
//		case 6 : 
//			tti = "ȣ���̶�";  break;
//		case 7 :
//			tti = "�䳢��"; break;
//		case 8 :
//			tti = "���"; break;
//		case 9 :
//			tti = "���"; break;
//		case 10 :
//			tti = "����"; break;
//		default :
//			tti = "���";
//		}
//		
//		return tti;
	}//end returnTti
	public static void main(String[] args) {
		String ssn = "921111-2343243";
		SsnInputAndProcessing siap = new SsnInputAndProcessing(ssn);
		if (siap.ssnLengthCheck() && siap.ssnSixCharCheck() && siap.SsnValidCheck()) {
			System.out.println("�ùٸ� �ֹι�ȣ�Դϴ�");
			System.out.println(siap.returnBrith());
			System.out.println(siap.returnAge());
			System.out.println(siap.returnGender());
			System.out.println(siap.returnNational());
			System.out.println(siap.returnTti());
		} else {
			System.out.println("�ùٸ��ֹι�ȣ�� �ƴմϴ�");
		} // �ùٸ� �ֹι�ȣ���� Ȯ��
//		System.out.println(siap.ssn);
	}

}
