package day1206;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

public class Work1206 {
	/**
	 * 숙제 :<br>
	 * 1. 아래의 데이터를 처리하는 프로그램을 작성하세요. 백인재,이봉현,이재찬,정택성,이재현,김정운 의 데이터가 존재하고, 점수는 0~100점
	 * 사이로 발생할수있습니다.<br>
	 * 
	 * 프로그램이 실행되면 위의 사람중에 2명이상 성적처리 대상자 이고 n명의 이름과 점수를 저장하여 출력하는 일을 하는 프로그램 작성.
	 * 중복이름은 들어갈 수 없다.<br>
	 * 
	 * 출력 예 ) 
	 * 이재찬 89<br> 
	 * 정택성 77<br> 
	 * 김정운 90 <br>
	 * 총점 xx점<br>
	 */
	
	
	
	public Work1206() {
		Random ranScore = new Random(); //Score 랜덤
		
		List<String> student = new ArrayList<String>();//Student List에 값 저장
		student.add("백인재");
		student.add("이봉현");
		student.add("이재찬");
		student.add("정택성");
		student.add("이재현");
		student.add("김정운");
		
		List<String> score = new ArrayList<String>();//Score List에 난수 점수 저장
		for(int i=0; i<student.size();i++) {
			score.add(String.valueOf(ranScore.nextInt(99)+1));
		}
		
		int[] randomNum = new int[student.size()];//랜덤 인덱스 만들기
		for(int i=0; i<student.size();i++) {			
			randomNum[i] = (int)(Math.random()*(student.size()));
			for(int j=0; j<i;j++) {
				if(randomNum[i]==randomNum[j]) {
					i--;
					break;
				}//end if
			}//end for
		}//end for
		
		int rand = (int)(Math.random()*(student.size()-1)+2);//2이상의 n명 출력을 위한 인덱스
		int totalScore = 0;
		for(int i=0; i<rand;i++) {
			System.out.println(student.get(randomNum[i])+" "+score.get(randomNum[i])); //랜덤 인덱스에 해당하는 학생을 출력(학생 섞기)
			totalScore +=Integer.parseInt(score.get(randomNum[i])); //총점 구하기
		}//end for
		System.out.println("총점: "+totalScore);
	}// Work1206

	public static void main(String[] args) {
		new Work1206();
	}

}
