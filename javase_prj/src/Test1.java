
/*2016�� 1�� 1���� �ݿ����Դϴ�. 
2016�� a�� b���� ���� �����ϱ��? 
�� �� a ,b�� �Է¹޾� 2016�� a�� b���� ���� �������� �����ϴ� �Լ�, 
solution�� �ϼ��ϼ���. ������ �̸��� 
�Ͽ��Ϻ��� ����ϱ��� ���� SUN,MON,TUE,WED,THU,FRI,SAT�Դϴ�. 
���� ��� a=5, b=24��� 5�� 24���� ȭ�����̹Ƿ� ���ڿ� TUE�� ��ȯ�ϼ���.

���� ����
2016���� �����Դϴ�.
2016�� a�� b���� ������ �ִ� ���Դϴ�.
 (13�� 26���̳� 2�� 45�ϰ��� ��¥�� �־����� �ʽ��ϴ�)
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