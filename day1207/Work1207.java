package day1207;

import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

/**
 *숙제 1.<br>
 *main method의 arguments로 날짜를 여러개 입력 받아 입력받은 날짜의
 *요일을 저장하고 출력하는 method 를 작성하세요.<br>
 *예) java Test 4 12 30 32 35 15 4 <br>
 *출력) 4 화<br>
 *12 수<br>
 *15 토<br>
 *30 일 <br>
 * @author owner
 */
public class Work1207 {
	//Map 출력을 위한 인스턴스변수선언
	Map<Integer, String> dayOfWeek = new HashMap<Integer, String>(); 
	
	//생성자 
	public Work1207() { 
	}
	//값을 구해서 Map에 저장하는 메소드
	public void storeDay(String day) {
		
		//입력받은 String을 공백에 맞게 구분해주기
		StringTokenizer stk= new StringTokenizer(day, " ");
		
		//입력받은 값을 Set에 저장 //31일 이상의 요일은 거르기
		Set<String> inputDay = new HashSet<String>();
		String temp =" ";
		while(stk.hasMoreTokens()) {
			temp =stk.nextToken();
			if(Integer.parseInt(temp) <31) {
				inputDay.add(temp);				
			}//end if
		}//end while
		
		//값 하나씩 확인해서 요일부여
		Calendar cal = Calendar.getInstance();//캘린더
		Iterator<String> ita = inputDay.iterator();
		
		//날짜를 입력받은 날로 바꾸고 그에 맞는 요일을 구하기
		//그리고 인스턴스 변수로 선언한 Map에 저장
		String[] weekTitle = {"일","월","화","수","목","금","토"};
		int i =0;
		int day_of_week=0;
		int inpday = 0;
		while(ita.hasNext()) { //맵에 값저장
			inpday =Integer.parseInt(ita.next());
			cal.set(Calendar.DAY_OF_MONTH,inpday);
			day_of_week = cal.get(Calendar.DAY_OF_WEEK);
			dayOfWeek.put(inpday,weekTitle[day_of_week-1]);
			i++;
		}//end while
	}//storeDay
	
	//storeDay에서 가공한 데이터를 이용해 값을 출력하는 메소드
	public void printDay(Map dayOfWeek){
		
		Set<String> day = dayOfWeek.keySet(); 
		Integer[] key = new Integer[dayOfWeek.size()];
		day.toArray(key);
		int temp=0;
		
		//작은 수가 앞으로 오도록 정렬(오름차순)
		for(int i=0; i<dayOfWeek.size();i++) {
			for(int j=0; j<dayOfWeek.size();j++) {
				if(key[i]<key[j]) {
					temp = key[i];
					key[i] = key[j];
					key[j] = temp;
				}//end if
			}//end for
		}//end for
		
		//키와 키에 따른 값 출력
		for(int i=0; i<dayOfWeek.size(); i++) { 
			System.out.println(key[i]+" "+dayOfWeek.get(key[i]));
		}
	}//printDay
			
	public static void main(String[] args) {
	Work1207 wk = new Work1207();
	wk.storeDay("4 12 30 32 35 15 4");
	wk.printDay(wk.dayOfWeek);
	}

}
