package day1128;

/**
 *4강의장 학생들의 성적처리 프로그램
 * @author owner
 */
public class ScoreProcess {
		
	public ScoreProcess() {
		
		String[] nameArr= {"이재찬","정택성","이재현","김건하","공선의"};
		int[] scoreArr= {89,76,99,64,50};
		int totalScore=0;// 총점 누적합
		int maxScore=0;//최고점
		int minScore=101;//최하점
		String maxScorestu=""; //최고점 받은 사람
		String minScorestu =""; //최하점 받은 사람
		int temp =0; //정렬값을 임시로 저장
		System.out.println("번호\t이름\t점수");
		System.out.println("---------------------------------------");
		for(int i=0; i<nameArr.length;i++) {
			System.out.printf("%d\t%s\t%d\n",i+1,nameArr[i],scoreArr[i]);
			totalScore+=scoreArr[i];
			
			if(maxScore<scoreArr[i]) {//최고점수가 현재 순환중인 방의 값보다 작다면
				maxScore=scoreArr[i];
				maxScorestu=nameArr[i];
				//현재 순환중인 방의 값으로 최고점수를 변경해준다.
			}//end if
			if(minScore>scoreArr[i]) {//최고점수가 현재 순환중인 방의 값보다 크다면
				minScore=scoreArr[i];
				minScorestu = nameArr[i];
				//현재 순환중인 방의 값으로 최하점수를 변경해준다.
			}//end if
		
		}//end for
		
		System.out.println("---------------------------------------");
		System.out.println("응시인원: "+nameArr.length);
		System.out.printf("총점: [%5d] 평균[%.2f] \n",totalScore,totalScore/(double)nameArr.length);
		System.out.println(totalScore/nameArr.length);
		System.out.printf("최고점 [%3d] 최하점 [%3d] 1등 : [%s] 꼴등 : [%s] \n"
				,maxScore,minScore,maxScorestu,minScorestu);
		
		for(int i=0; i<scoreArr.length-1;i++) {
			for(int j=i+1;j<scoreArr.length;j++) {
				if(scoreArr[i]<scoreArr[j]) { //앞방의 값이 뒷방보다 작다면
					temp=scoreArr[i];
					scoreArr[i]=scoreArr[j];
					scoreArr[j]=temp;
				}//end if
			}//end for
		}//end for
		
		for(int i=0; i<scoreArr.length;i++) {
			System.out.printf("%4d",scoreArr[i]);
		}
		
		
	}//ScoreProcess
	
	public static void main(String[] args) {
		new ScoreProcess();
		System.out.println("------------------------------------------");
		int birth = 1999;
		String[] zodiac = {"원숭이", "닭","개","돼지","쥐","소","호랑이","토끼","용","뱀","말","양"};
		System.out.println(zodiac[birth%12]);
	
	}//main

}//class
