
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
	public void plusAndMinus() {
		int sum=0, cnt=1;
		
		for(int i=1;i<101;i++) {
			if(i%2==0) {
				cnt=-i;
			}else {
				cnt=i;
			}
			sum+=cnt;
			System.out.print(cnt+"  ");
		}
		System.out.println(sum);
	}
	
	public void sosu() {
		int cnt=0; 
		int sosu=1;
		for(int i=1;i<101;i++) {
			for(int j=1;j<101;j++) {
				if(i%j==0) {
					cnt++;
				}
			}
			if(cnt==2) {
				sosu=i;
			}
			cnt=0;
		}
		System.out.println("가장 큰 소수: "+sosu);
	}
	public boolean sosu(int num) {
		boolean sosuFlag=false;
		int cnt=0;
		for(int i=1; i<=num; i++) {
			if(num%i==0) {
				cnt++;
			}
		}
		if(cnt==2) {
			sosuFlag=true;
		}
		return sosuFlag;
	}
	
	public void soinsu(int num) {
		int mod=2, i=0, cnt=0;
		int[] storage= new int[200];
		if(sosu(num)) {
			System.out.println("소수입니다.");
			return;
		}
		while(true) {
			if((num%mod)==0) {
				num=num/mod;
				storage[i]=mod;
				i++;
			}else {
				mod++;
				storage[i]=num;
			}
			if(num/mod==1) {
				break;
			}
		}//end while
		for(int j=0; j<=storage.length;j++) {
			if(storage[j]!=0) {
				System.out.print(storage[j]+" ");
				System.out.print("*");
			}
		}
	}
	
	public void gongbae() {
		int A[]= {21,17,4,51,24,75,40,27,48,72};
		for(int i=0; i<A.length;i++) {
			if(A[i]%3==0) {
				if(A[i]%4==0) {
					System.out.println(A[i]);
				}
			}
		}//end for
	}

	public static void main(String[] args) {
		Test1 t1 = new Test1();
		t1.gongbae();
	}

}