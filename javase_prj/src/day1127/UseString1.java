package day1127;
	
public class UseString1 {
	//�̸����� �Է¹޾� �̸����� ��ȿ���� �����Ͽ� boolean������ ����� ����� ��ȯ�ϴ� ��
	//�̸����� ��ȿ��: 5�� �̻��̸鼭 @, .�� ��ȿ �ؾ���.
	private boolean validEmail(String email){
			boolean flag=false;
			if(email.length()>5&&email.indexOf("@")!=-1&&email.indexOf(".")!=-1) {
				flag=true;
			}
			return flag;
			
	}//method
	public static void main(String[] args) {
		UseString1 us1 = new UseString1();
//		String email = "gkwl78@naver.com";
		String[] arr = {"gkwl78@naver.com","gg.nn","gkwl@na"};
		String[] msg= new String[arr.length];
		
		for(int i=0; i<arr.length;i++) {
			if(us1.validEmail(arr[i])) {
				msg[i] = "��ȿ�� ������ �̸����Դϴ�";
			}else {
				msg[i]="�̸����� �ƴմϴ�";
			}
		}
		for(int i=0; i<arr.length;i++) {
			System.out.printf("%s�� %s \n",arr[i],msg[i]);
		}
			
		
	}//main

}//class
