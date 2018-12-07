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
		
		//�Է¹��� ���� Set�� ����(�ߺ�����) //31�� �̻��� ������ �Ÿ���(if)
		Set<String> inputDay = new HashSet<String>();
		String temp =" ";
		while(stk.hasMoreTokens()) {
			temp =stk.nextToken();
			if(Integer.parseInt(temp) <31) {
				inputDay.add(temp);				
			}//end if
		}//end while
		
		Calendar cal = Calendar.getInstance();//Ķ���� ����
		Iterator<String> ita = inputDay.iterator(); //set���� ���� �˻��ϱ� ���� ���ͷ�����
		
		//Ķ���� ����ؼ� ���ͷ����ͷ� �޾ƿ� ���� �ٲٰ� �׿� �´� ������ ���ؼ�
		//�ν��Ͻ� ������ ������ Map�� ����(While �� �ݺ�)
		String[] weekTitle = {"��","��","ȭ","��","��","��","��"}; //DAY_OF_WEEK ������ ��ȯ�� ���� ��ȯ�ϱ� ���� ������ ������ �迭
		int day_of_week=0; //���Ͽ� ���� �ε��� �޴� ��������
		int inpday = 0; // ��¥�� ������ ��������
		while(ita.hasNext()) { 
			inpday =Integer.parseInt(ita.next());
			cal.set(Calendar.DAY_OF_MONTH,inpday);
			day_of_week = cal.get(Calendar.DAY_OF_WEEK);
			dayOfWeek.put(inpday,weekTitle[day_of_week-1]);
		}//end while
	}//storeDay
	
	//storeDay���� ������ �����͸� �̿��� ���� ����ϴ� �޼ҵ�
	public void printDay(Map dayOfWeek){
		//key ������ �迭 ����
		Set<String> day = dayOfWeek.keySet();  //Map���� ��� Ű�� day��� 1�����迭 set�� ����
		Integer[] key = new Integer[dayOfWeek.size()]; //key�� ������ Integer�� �迭 ����
		day.toArray(key); //set���� ��� Ű���� key �迭�� ����
		
		//���� ���� ������ ������ ����(��������)
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
