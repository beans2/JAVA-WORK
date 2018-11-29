package day1122;

/**
 *숙제 
아래의 업무를 처리하는 method를 type에 알맞게 작성하고 API주석을
 설정한 후 호출하여 결과를 본 후 Java Doc을 생성해보세요.
- API주석은 어떤 형태의 method인지를 주석으로 기술할것.

1. 자신의 이름을 반환하는 method작성.
2. 나이를 입력받아 태어난 해를 반환하는  method 작성.
3. 문자를 입력받아 해당 문자의 Unicode 값을 반환하는 method 작성.
4. 숫자를 입력받아 숫자가  영문자, 숫자의 범위에 있을 때 해당 숫자의
    문자를  출력하는 일을 하는 method  작성
5. 호출하면 자신의 주소를 출력하는  method 작성.
6. 친구의 이름을 입력받아 출력하는  method 작성(친구는 n명 입니다.) 
 * @author owner
 */
	
public class Work20 {
	
	/**
	 * 1. 자신의 이름을 반환하는 method작성.
	 * @return 자신의 이름 "공선의"의 반환값
	 */
	public String returnName(){
		return "공선의"; 
	}//end method1


	/**
	 * 2. 나이를 입력받아 태어난 해를 반환하는  method 작성.
	 * @param age 자신의 나이를 입력받는 매개변수
	 * @return 반환할 태어난해의 반환값
	 */
	public int returnYear(int age) {
		int year= 2018-age+1;
		return year;
	}//end method2

	/**
	 * 3. 문자를 입력받아 해당 문자의 Unicode 값을 반환하는 method 작성.
	 * @param thing  입력받을 문자의 매개변수
	 * @return 반환할 유니코드값
	 */
	public int returnUnicode(char thing) {
		int unicode = (int)thing;
		return unicode;
	}//end method3
	
	/**
	 * 4. 숫자를 입력받아 숫자가  영문자, 숫자의 범위에 있을 때 해당 숫자의<br>
     *문자를  출력하는 일을 하는 method  작성
	 * @param num 입력받을 숫자의 매개변수
	 * @return 반환할 영문자 매개변수
	 */
	public char returnCharac(int num){
		char charac = ' ';
		if(num>=65&&num<=90) {
			charac= (char)num;
		}else {
			System.out.println("숫자가 범위내에 있지 않습니다.");
		}//end if
		return charac;
	}//end method4
	
	/**
	 * 5. 호출하면 자신의 주소를 출력하는  method 작성.
	 */
	public void returnAddr(Work20 wk) {
		System.out.println(wk);
	}//end method5
	
	/**
	 * 6. 친구의 이름을 입력받아 출력하는  method 작성(친구는 n명 입니다.) 
	 * @param name 여러명의 친구들의 이름을 입력받는 매개변수 
	 */
	public  void returnFrendsName(String ... name) {
		for(int i=0;i<name.length;i++) {
			System.out.println(name[i]);
		}
	}//end method5
	public static void main(String[] args) {
		Work20 wk= new Work20();	
		System.out.println("----------------------1번--------------------------");
		System.out.println(wk.returnName()); 
		System.out.println("----------------------2번--------------------------");
		System.out.println(wk.returnYear(27));
		System.out.println("----------------------3번--------------------------");
		System.out.println(wk.returnUnicode('A'));
		System.out.println("----------------------4번--------------------------");
		System.out.println(wk.returnCharac(68));
		System.out.println("----------------------5번--------------------------");
		wk.returnAddr(wk);
		System.out.println("----------------------6번--------------------------");
		wk.returnFrendsName("김철수","김혜자","김창렬");
	}//main

}//class
