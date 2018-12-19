
/*2016년 1월 1일은 금요일입니다. 
2016년 a월 b일은 무슨 요일일까요? 
두 수 a ,b를 입력받아 2016년 a월 b일이 무슨 요일인지 리턴하는 함수, 
solution을 완성하세요. 요일의 이름은 
일요일부터 토요일까지 각각 SUN,MON,TUE,WED,THU,FRI,SAT입니다. 
예를 들어 a=5, b=24라면 5월 24일은 화요일이므로 문자열 TUE를 반환하세요.

제한 조건
2016년은 윤년입니다.
2016년 a월 b일은 실제로 있는 날입니다.
 (13월 26일이나 2월 45일같은 날짜는 주어지지 않습니다)
*/

import java.awt.image.DataBufferUShort;
import java.util.Calendar;

/**
 * @author owner
 *
 */
class Test1 {

	public String solution(int a, int b) {
		int month = a;
		int dayOfMonth = b;
		String answer = "";
		Calendar cld = Calendar.getInstance();
		cld.set(Calendar.YEAR, 2016);
		cld.set(Calendar.MONTH,month+1);
		cld.set(Calendar.DAY_OF_MONTH,dayOfMonth);
		int c =0;
		if(cld.MONTH==2) {
			c = cld.getActualMaximum(Calendar.DAY_OF_MONTH)-2;								
		}else {
			c = cld.getActualMaximum(Calendar.DAY_OF_MONTH);					
		}
		if((month<13)&&(month>0)) {
//			System.out.println(month+"/"+dayOfMonth+"/"+c);
			if((dayOfMonth<=c)&&(dayOfMonth>0)){
				String[] dow = { "SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT" };
				System.out.println("요일"+dow[cld.get(Calendar.DAY_OF_WEEK) -1]);
				answer = dow[cld.get(Calendar.DAY_OF_WEEK)-1];			
				System.out.println(answer);
			}else {
				System.out.println("입력가능 날짜가 아닙니다.");				
			}
			}else {
			System.out.println("입력가능 달이 아닙니다.");
		}
		return answer;
	}
	public static void main(String[] args) {
		Test1 t1 = new Test1();
		t1.solution(5,24);
	}

}