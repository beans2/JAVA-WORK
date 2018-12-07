package day1207;

import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

/**
 *���� 1.<br>
 *main method�� arguments�� ��¥�� ������ �Է� �޾� �Է¹��� ��¥��
 *������ �����ϰ� ����ϴ� method �� �ۼ��ϼ���.<br>
 *��) java Test 4 12 30 32 35 15 4 <br>
 *���) 4 ȭ<br>
 *12 ��<br>
 *15 ��<br>
 *30 �� <br>
 * @author owner
 */
public class Work1207 {
	//Map ����� ���� �ν��Ͻ���������
	Map<Integer, String> dayOfWeek = new HashMap<Integer, String>(); 
	
	//������ 
	public Work1207() { 
	}
	//���� ���ؼ� Map�� �����ϴ� �޼ҵ�
	public void storeDay(String day) {
		
		//�Է¹��� String�� ���鿡 �°� �������ֱ�
		StringTokenizer stk= new StringTokenizer(day, " ");
		
		//�Է¹��� ���� Set�� ���� //31�� �̻��� ������ �Ÿ���
		Set<String> inputDay = new HashSet<String>();
		String temp =" ";
		while(stk.hasMoreTokens()) {
			temp =stk.nextToken();
			if(Integer.parseInt(temp) <31) {
				inputDay.add(temp);				
			}//end if
		}//end while
		
		//�� �ϳ��� Ȯ���ؼ� ���Ϻο�
		Calendar cal = Calendar.getInstance();//Ķ����
		Iterator<String> ita = inputDay.iterator();
		
		//��¥�� �Է¹��� ���� �ٲٰ� �׿� �´� ������ ���ϱ�
		//�׸��� �ν��Ͻ� ������ ������ Map�� ����
		String[] weekTitle = {"��","��","ȭ","��","��","��","��"};
		int i =0;
		int day_of_week=0;
		int inpday = 0;
		while(ita.hasNext()) { //�ʿ� ������
			inpday =Integer.parseInt(ita.next());
			cal.set(Calendar.DAY_OF_MONTH,inpday);
			day_of_week = cal.get(Calendar.DAY_OF_WEEK);
			dayOfWeek.put(inpday,weekTitle[day_of_week-1]);
			i++;
		}//end while
	}//storeDay
	
	//storeDay���� ������ �����͸� �̿��� ���� ����ϴ� �޼ҵ�
	public void printDay(Map dayOfWeek){
		
		Set<String> day = dayOfWeek.keySet(); 
		Integer[] key = new Integer[dayOfWeek.size()];
		day.toArray(key);
		int temp=0;
		
		//���� ���� ������ ������ ����(��������)
		for(int i=0; i<dayOfWeek.size();i++) {
			for(int j=0; j<dayOfWeek.size();j++) {
				if(key[i]<key[j]) {
					temp = key[i];
					key[i] = key[j];
					key[j] = temp;
				}//end if
			}//end for
		}//end for
		
		//Ű�� Ű�� ���� �� ���
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
