
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

/**
 * @author owner
 *
 */
class Test1 {
	public int solution(String s) {
		int answer = 0;
		int flag=1;
	      int[] zaritsu=new int[s.length()];
	      int intgap=0;
	      char[] charater= new char[s.length()];
	      int sum=0;
	      for(int i=0;i<charater.length;i++){
	        charater[i]=s.charAt(i);
	          if(((int)charater[i]<58)&&((int)charater[i]>47)){
	        	  zaritsu[i]++;
	              for(int j=0;j<i;j++){
		              zaritsu[i]= zaritsu[i]*10;
	               }//end for
	            intgap = (5-((int)charater[i]-48))*zaritsu[i];
	            sum+=intgap;
	          }else if((int)charater[i]==56) {
	        	  flag=-1;
	          }
	      }//end for
	      System.out.println(sum);
	      answer=sum*flag;
	      return answer;
	}

	public static void main(String[] args) {
		Test1 t1 = new Test1();
		t1.solution("-1234");

	}

}