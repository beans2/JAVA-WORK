package day1127;
	
public class UseString1 {
	//이메일을 입력받아 이메일의 유효성의 검증하여 boolean형으로 결과를 만들어 반환하는 일
	//이메일의 유효성: 5자 이상이면서 @, .이 유효 해야함.
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
				msg[i] = "유효한 형식의 이메일입니다";
			}else {
				msg[i]="이메일이 아닙니다";
			}
		}
		for(int i=0; i<arr.length;i++) {
			System.out.printf("%s는 %s \n",arr[i],msg[i]);
		}
			
		
	}//main

}//class
