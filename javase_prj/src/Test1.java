
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
		System.out.println("���� ū �Ҽ�: "+sosu);
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
			System.out.println("�Ҽ��Դϴ�.");
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