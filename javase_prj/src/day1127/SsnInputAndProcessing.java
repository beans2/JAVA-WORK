package day1127;

/**
 * 숙제1 <br>
 * 주민번호 입력받아 처리하는 프로그램 작성 <br>
 * 각 작업은 method 정의하고 호출하여 결과를 받아서 처리 <br>
 * 1-1. 생성자는 주민번호를 받아 instance 변수에 할당한다. <br>
 * -인스턴스 변수의 값을 사용<br>
 * 1-2. 주민번호의 길이체크하여 14자가 아니면 false 반환 <br>
 * 1-3. 주민번호 6번째 자리가'-'이 아니면 false반환<br>
 * 1-4. 주민번호의 유효성검증하여 유효하면 true/그렇지 않으면 false 반환<br>
 * 유효성검증 - 각 자리에 234567892345를 곱한 값을 더하여 11로 나눈 나머지값을 얻고 11에서 그 값을 빼고<br>
 * 10으로 나눈 나머지가 주민번호의 끝자리와 같다면 true /그렇지 않으면 false<br>
 * 1-5. 생년월일 반환하는 일. "1988-11-11"<br>
 * 1-6. 나이를 반환하는 일 31<br>
 * 1-7. 성별을 반환 남,여<br>
 * 1-8. 내국인/외국인 반환 (1,2,3,4 -내국인 / 5,6,7,8 -외국인)<br>
 * 1-9. 띠를 반환 "양띠"
 * 
 * @author owner
 */
public class SsnInputAndProcessing {
	String ssn = new String();

	/**
	 * 1-1. 생성자는 주민번호를 받아 instance 변수에 할당한다.
	 * 
	 * @param ssn
	 */
	public SsnInputAndProcessing() {

	};

	public SsnInputAndProcessing(String ssn) {
		this.ssn = ssn;
	}// end 1-1 SsnInputAndProcessing

	/**
	 * 1-2. 주민번호의 길이체크하여 14자가 아니면 false 반환
	 * 
	 * @return 체크값이 올바른지에 대한 true/flase
	 */
	public boolean ssnLengthCheck() {
		boolean flag = true;
		if (ssn.length() != 14) {
			flag = false;
		}
		return flag;
	}// end 1-2 ssnLengthCheck

	/**
	 * 1-3. 주민번호 6번째 자리가'-'이 아니면 false반환
	 * 
	 * @return 체크값이 올바른지에 대한 true/flase
	 */
	public boolean ssnSixCharCheck() {
		boolean flag = true;
		if (ssn.indexOf("-") != 6) {
			flag = false;
		}
		return flag;
	}// end 1-3 ssnSixCharCheck

	/**
	 * 1-4. 주민번호의 유효성검증하여 유효하면 true/그렇지 않으면 false 반환<br>
	 * 유효성검증 - 각 자리에 234567892345를 곱한 값을 더하여 11로 나눈 나머지값을 얻고 11에서 그 값을 빼고<br>
	 * 10으로 나눈 나머지가 주민번호의 끝자리와 같다면 true /그렇지 않으면 false
	 * 
	 * @return 주민번호의 유효성에대한 true/false
	 */
	public boolean SsnValidCheck() {
		boolean flag = false;
		int sum = 0;
		int checknum = 0;
		int[] ssnnum = new int[13];
		String tempssn = ssn.replaceAll("-", "");

		for (int i = 0; i < 13; i++) {
			ssnnum[i] = tempssn.charAt(i) - 48;
//				System.out.print(ssnnum[i]); // 주민번호 값 잘 들어간지 확인
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
	 * 1-5. 생년월일 반환하는 일. "1988-11-11"
	 * 
	 * @param ssn 주민번호
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
	 * 1-6. 나이를 반환하는 일
	 * 
	 * @return 나이
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
	 * 1-7. 성별을 반환 남,여
	 * 
	 * @return 성별 (남/여)
	 */
	public char returnGender() {
		char validnum = ssn.charAt(7);
		char gender = ' ';
		if (validnum == '1' || validnum == '3' || validnum == '5' || validnum == '7' || validnum == '9') {
			gender = '남';
		} else {
			gender = '여';
		}
		return gender;
	}// end returnGender
	
	/**
	 * 1-8. 내국인/외국인 반환 (1,2,3,4 -내국인 / 5,6,7,8 -외국인)
	 * @return 내국인/외국인 반환
	 */
	public String returnNational() {
		String nation = "";
		char validnum = ssn.charAt(7);
		if (validnum == '1' || validnum == '2' || validnum == '3' || validnum == '4' || validnum == '9') {
			nation = "내국인";
		} else {
			nation = "외국인";
		}
		return nation;
	}//end returnNational
	
	/**
	 * 1-9. 띠를 반환 "양띠"
	 * @return 띠
	 */
	public String returnTti() {
//		String tti = "";
		String year =returnBrith().substring(0, 4);
		//System.out.println(year);
//		int birth=Integer.parseInt(year)%12;
		int check=Integer.parseInt(year)%12;
		String [] animal = {"원숭이띠", "닭띠","개띠","돼지띠","쥐띠","소띠","호랑이띠","토끼띠","용띠","뱀띠","말띠","양띠"};
		return animal[check];
//		switch(Integer.parseInt(year)%12) {
//		case 0 :
//			tti =  "원숭이띠"; break;
//		case 1 :
//			tti = "닭띠"; break;
//		case 2 :
//			tti = "개띠"; break;
//		case 3 :
//			tti = "돼지띠"; break;
//		case 4 :
//			tti = "쥐띠"; break;
//		case 5 :
//			tti = "소띠"; break;
//		case 6 : 
//			tti = "호랑이띠";  break;
//		case 7 :
//			tti = "토끼띠"; break;
//		case 8 :
//			tti = "용띠"; break;
//		case 9 :
//			tti = "뱀띠"; break;
//		case 10 :
//			tti = "말띠"; break;
//		default :
//			tti = "양띠";
//		}
//		
//		return tti;
	}//end returnTti
	public static void main(String[] args) {
		String ssn = "921111-2343243";
		SsnInputAndProcessing siap = new SsnInputAndProcessing(ssn);
		if (siap.ssnLengthCheck() && siap.ssnSixCharCheck() && siap.SsnValidCheck()) {
			System.out.println("올바른 주민번호입니다");
			System.out.println(siap.returnBrith());
			System.out.println(siap.returnAge());
			System.out.println(siap.returnGender());
			System.out.println(siap.returnNational());
			System.out.println(siap.returnTti());
		} else {
			System.out.println("올바른주민번호가 아닙니다");
		} // 올바른 주민번호인지 확인
//		System.out.println(siap.ssn);
	}

}
