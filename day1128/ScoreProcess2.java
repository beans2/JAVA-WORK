package day1128;

/**
 * 학생의 oracle, java, JDBC 과목 점수를 처리하는 프로그램
 * 
 * @author owner
 */
public class ScoreProcess2 {
	private int total;
	private int subtotal;
	private int allsubtotal;
	private double average;
	private double subaverage;
	private double allsubaverage;
	private String[] topStudent =new String[3];
	private int max;

	public ScoreProcess2() {

	}// ScoreProcess2()

	/**
	 * 정수를 누적합 시키는 것
	 * 
	 * @param score
	 */
	public void addTotal(int score) {
		total += score;
	}// setTotal

	/**
	 * 점수를 얻는 일
	 * 
	 * @return
	 */
	public int getTotal() {
		return total;
	}// getTotal

	/**
	 * 총합점수를 초기화
	 */
	public void resetTotal() {
		total = 0;
	}// resetTotal
		//////////////////////////////////

	/**
	 * 평균값을 구하기
	 * 
	 * @param score
	 */
	public void setAverage(int scorelength) {
		average = total / (double) scorelength;
	}// setAverage

	/**
	 * 평균값을 반환하기
	 * 
	 * @return 평균값
	 */
	public double getAverage() {
		return average;
	}

	///////////////////////////////////
	public void addsubTotal(int score) {
		subtotal += score;
	}// setTotal

	/**
	 * 과목점수를 얻는 일
	 * 
	 * @return
	 */
	public int getsubTotal() {
		return subtotal;
	}// getTotal

	/**
	 * 모든과목점수의 총합
	 * 
	 * @return
	 */
	public void addSubAllTotal() {
		allsubtotal += subtotal;
	}

	/**
	 * 모든과목점수 반환
	 * 
	 * @return 모든과목점수
	 */
	public int getSubAllTotal() {
		return allsubtotal;
	}

	/**
	 * 모든 과목점수 평균
	 * 
	 * @param score 과목의 수
	 */
	public double setSubAllAverage(int scorelength) {
		allsubaverage = (double) allsubtotal / scorelength;
		return allsubaverage;
	}

	/**
	 * 과목총합점수를 초기화
	 */
	public void resetsubTotal() {
		subtotal = 0;
	}// resetTotal
		////////////////////////////////////////

	/**
	 * 과목 평균값을 구하기
	 * 
	 * @param score
	 */
	public void setsubAverage(int scorelength) {
		subaverage = subtotal / (double) scorelength;
	}// setAverage

	/**
	 * 과목 평균값을 반환하기
	 * 
	 * @return 과목평균값
	 */
	public double getsubAverage() {
		return subaverage;
	}

	/**
	 * 최고점을 구하는 method
	 * 
	 * @param score 비교할 점수
	 * @return 최고점
	 */
	public int MaxScore(int score) {
		if (max < score) {
			max = score;
		}
		return max;
	}

	/**
	 * 최고점을 리셋
	 */
	public void resetMaxScore() {
		max = 0;
	}

	/**
	 * 최고점 사람의 이름,총점,번호
	 * @param score 모든점수
	 * @return 최고점사람의 이름, 총점,번호
	 */
	public void topScoreStu(int[][] score,String[] name) {
		int max=0;
		for(int i=0;i<score.length;i++) {
			for(int j=0;j<score[i].length;j++) {
				if(max<score[i][j]) {
					max=score[i][j];
					topStudent[0]=name[i];
					topStudent[1]=String.valueOf(max);
					topStudent[2]=String.valueOf(i+1);
					}
				}
		}
	}
	
	/**
	 * 자바점수의 오름차순 구하는 method
	 * @param score 모든 학생의 score
	 */
	public void asc(int[][] score) {
		int temp=0;
		System.out.println("자바점수의 오름차순: ");
		for(int i=0; i<score.length-1;i++) {
			for(int j=i+1;j<score.length;j++) {
				if(score[i][1]>score[j][1]) { //앞방의 값이 뒷방보다 작다면
					temp=score[i][1];
					score[i][1]=score[j][1];
					score[j][1]=temp;
				}//end if
			}//end for
		}//end for
		for(int i=0; i<score.length;i++) {
			System.out.printf("%d\t",score[i][1]);
		}
		System.out.println();
	}

	/////////////////////////////////////
	/**
	 * 1.각 학생의 평균을 구하여 출력(출력 소수이하 한자리 까지만 출력).
	 * 
	 * @param total
	 */
	public String[] nameData() {
		String[] name = { "김정운", "이재현", "정택성", "노진경", "최지우", "김건하" };
		return name;
	}// nameData

	public int[][] scoreData() {
		int[][] score = { { 85, 86, 81 }, { 95, 91, 100 }, { 89, 71, 59 }, { 97, 96, 91 }, { 78, 74, 77 },
				{ 100, 95, 68 } };
		return score;
	}

	public String[] subjectData() {
		String[] subject = { "Oracle", "Java", "JDBC" }; // 숙제2
		return subject;
	}

	////////////////////////////////////////////////
	public void printScore(String[] subject, String[] name, int[][] score) {
		// 숙제 - 모든 일은 합당한 매개변수와 반환형을 사용하여
		// method로 정의하여 호출하여 사용한다.
		// 1.각 학생의 평균을 구하여 출력(출력 소수이하 한자리 까지만 출력).
		System.out.println("번호\t이름\tOracle\tJava\tJDBC\t총점\t평균");
		System.out.println("-------------------------------------------------------");

		for (int i = 0; i < score.length; i++) {// 행
			System.out.printf("%d\t%s\t", i + 1, name[i]);
			for (int j = 0; j < score[i].length; j++) {// 열
				System.out.printf("%d\t", score[i][j]);
				addTotal(score[i][j]);
				setAverage(score[i].length);// 숙제1. 평균구하는 method

			} // end for
			System.out.print(getTotal() + "\t");
			System.out.printf("%.2f\n", getAverage());// 숙제1. 평균을 출력하는 method
			resetTotal();

		} // end for
		System.out.println("-------------------------------------------------------");
		// 2. 각 과목당 총점과 총점의 총점
		System.out.println("과목총점-----------------------------------------------");
		for (int j = 0; j < score[0].length; j++) {
			for (int i = 0; i < score.length; i++) {
				addsubTotal(score[i][j]);
			}
			System.out.printf("%s의 총점: ", subject[j]);
			System.out.printf("%d\n", getsubTotal());
			addSubAllTotal();
			resetsubTotal();
		}
		System.out.printf("전체 총점: %d\n", getSubAllTotal());
		// 3. 각 과목당 평균과 전체 평균(전체평균은 소수이하 두자리까지 출력)
		System.out.println("과목평균-----------------------------------------------");
		for (int j = 0; j < score[0].length; j++) {
			for (int i = 0; i < score.length; i++) {
				addsubTotal(score[i][j]);
				setsubAverage(score[0].length);
			}
			System.out.printf("%s의 평균: ", subject[j]);
			System.out.printf("%.2f\n", getsubAverage());
			resetsubTotal();
		}
		System.out.printf("전체 평균: %.2f\n", setSubAllAverage(score.length*score[0].length));
		System.out.println("-----------------------------------------------------------");
		// 4. 각 과목당 최고점수를 출력
		int[] max = new int[3];
		for (int j = 0; j < score[0].length; j++) {
			for (int i = 0; i < score.length; i++) {
				max[j] = MaxScore(score[i][j]);
			}
			resetMaxScore();
		}
		for (int i = 0; i < subject.length; i++) {
			System.out.printf("최고 점수 %s : [%d ]\n", subject[i], max[i]);
		}
		System.out.println("-----------------------------------------------------------");

		// 5. 일등학생의 이름과 총점, 번호
		topScoreStu(score, name);
		System.out.printf("TOP 이름 [%s ]  총점[%s ]  번호[%s ] \n ",topStudent[0],topStudent[1],topStudent[2]);
		
		// 6. 자바점수만 오름차순 정렬하여 출력.
		System.out.println("");
		asc(score);

	}// printScore

	// 숙제2.
	/*
	 * 2차원 배열을 참조형 형식으로 만들고 아래와 같이 값을 넣어 출력하는 method 작성. 
	 * 1 1 1 1 1 1 1 1 1
	 * 1 0 0 0 0 0 0 0 1 
	 * 1 0 0 0 0 0 0 0 1 
	 * 1 0 0 0 0 0 0 0 1 
	 * 1 0 0 0 0 0 0 0 1 
	 * 1 1 1 1 1 1 1 1 1
	 * 
	 */
	public void makeArray() {
		int[][] arr= new int[6][9];
		System.out.println("--------------------------------------");
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				arr[i][j] = i==0||i==arr.length-1||j==0||j==arr[i].length-1 ? 1:0;
				System.out.print(arr[i][j]+ " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		ScoreProcess2 sp2 = new ScoreProcess2();
		String[] name = sp2.nameData();
		int[][] score = sp2.scoreData();
		String[] subject = sp2.subjectData();
		// 처리
		sp2.printScore(subject, name, score);
		sp2.makeArray();
	}
}
