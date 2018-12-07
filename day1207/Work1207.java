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
		
		//입력받은 값을 Set에 저장(중복제거) //31일 이상의 요일은 거르기(if)
		Set<String> inputDay = new HashSet<String>();
		String temp =" ";
		while(stk.hasMoreTokens()) {
			temp =stk.nextToken();
			if(Integer.parseInt(temp) <31) {
				inputDay.add(temp);				
			}//end if
		}//end while
		
		Calendar cal = Calendar.getInstance();//캘린더 생성
		Iterator<String> ita = inputDay.iterator(); //set안의 값을 검색하기 위한 이터레이터
		
		//캘린더 사용해서 이터레이터로 받아온 날로 바꾸고 그에 맞는 요일을 구해서
		//인스턴스 변수로 선언한 Map에 저장(While 안 반복)
		String[] weekTitle = {"일","월","화","수","목","금","토"}; //DAY_OF_WEEK 숫자형 반환을 요일 변환하기 위해 요일을 저장한 배열
		int day_of_week=0; //요일에 대한 인덱스 받는 지역변수
		int inpday = 0; // 날짜를 저장할 지역변수
		while(ita.hasNext()) { 
			inpday =Integer.parseInt(ita.next());
			cal.set(Calendar.DAY_OF_MONTH,inpday);
			day_of_week = cal.get(Calendar.DAY_OF_WEEK);
			dayOfWeek.put(inpday,weekTitle[day_of_week-1]);
		}//end while
	}//storeDay
	
	//storeDay에서 가공한 데이터를 이용해 값을 출력하는 메소드
	public void printDay(Map dayOfWeek){
		//key 저장할 배열 생성
		Set<String> day = dayOfWeek.keySet();  //Map안의 모든 키를 day라는 1차원배열 set에 저장
		Integer[] key = new Integer[dayOfWeek.size()]; //key를 저장할 Integer형 배열 생성
		day.toArray(key); //set안의 모든 키들을 key 배열에 저장
		
		//작은 수가 앞으로 오도록 정렬(오름차순)
		int temp=0;
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
