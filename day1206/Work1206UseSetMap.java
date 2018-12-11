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
 * 숙제 :<br>
 * 1. 아래의 데이터를 처리하는 프로그램을 작성하세요. 백인재,이봉현,이재찬,정택성,이재현,김정운 의 데이터가 존재하고, 점수는 0~100점
 * 사이로 발생할수있습니다.<br>
 * 
 * 프로그램이 실행되면 위의 사람중에 2명이상 성적처리 대상자 이고 n명의 이름과 점수를 저장하여 출력하는 일을 하는 프로그램 작성.
 * 중복이름은 들어갈 수 없다.<br>
 * 
 * Use Map, Set<br>
 * 
 * 출력 예 ) 
 * 이재찬 89<br> 
 * 정택성 77<br> 
 * 김정운 90 <br>
 * 총점 xx점<br>
 */
public class Work1206UseSetMap {
	public Work1206UseSetMap() {
//		List<String> listName = new ArrayList<String>();
		Set<String> setName = new HashSet<String>();
		String[] stringName = {"백인재","이봉현","이재찬","정택성","이재현","김정운","백인재","이재찬","정택성"};
		for(int i=0; i<stringName.length;i++) {
			setName.add(stringName[i]);			
		}
		System.out.println(setName);
		
		Random r = new Random(); //random score 을 value로
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
