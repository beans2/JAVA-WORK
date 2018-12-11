package day1206;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 * ���� :<br>
 * 1. �Ʒ��� �����͸� ó���ϴ� ���α׷��� �ۼ��ϼ���. ������,�̺���,������,���ü�,������,������ �� �����Ͱ� �����ϰ�, ������ 0~100��
 * ���̷� �߻��Ҽ��ֽ��ϴ�.<br>
 * 
 * ���α׷��� ����Ǹ� ���� ����߿� 2���̻� ����ó�� ����� �̰� n���� �̸��� ������ �����Ͽ� ����ϴ� ���� �ϴ� ���α׷� �ۼ�.
 * �ߺ��̸��� �� �� ����.<br>
 * 
 * Use Map, Set<br>
 * 
 * ��� �� ) 
 * ������ 89<br> 
 * ���ü� 77<br> 
 * ������ 90 <br>
 * ���� xx��<br>
 */
public class Work1206UseSetMap {
	public Work1206UseSetMap() {
//		List<String> listName = new ArrayList<String>();
		Set<String> setName = new HashSet<String>();
		String[] stringName = {"������","�̺���","������","���ü�","������","������","������","������","���ü�"};
		for(int i=0; i<stringName.length;i++) {
			setName.add(stringName[i]);			
		}
		System.out.println(setName);
		
		Random r = new Random(); //random score �� value��
		Integer[] randScore = new Integer[setName.size()]; 
		for(int i=0;i<setName.size();i++) {
			randScore[i] = r.nextInt(99);			
		}
		Map<String, Integer> result = new HashMap<String,Integer>();
		Iterator<String> ita= setName.iterator();
		
		int num =0;
		Random n = new Random();
		num = n.nextInt(4)+2; 
		System.out.println(num);
		
		Set<Integer> index = new HashSet<Integer>();
		Iterator<Integer> ita2 = index.iterator();
		Integer[] ranindex = new Integer[setName.size()]; 
		int k =0;
		while(index.size()==setName.size()) {
			index.add(n.nextInt(6));
		}
		System.out.println(index);
		for(int i=0; i<num;i++) {
			result.put(ita.next(), randScore[i]);
		}
		System.out.println(result);
		
		
	}//Work1206UseSetMap

	public static void main(String[] args) {
		new Work1206UseSetMap();
	}

}
