package day1128;

/**
 * �л��� oracle, java, JDBC ���� ������ ó���ϴ� ���α׷�
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
	 * ������ ������ ��Ű�� ��
	 * 
	 * @param score
	 */
	public void addTotal(int score) {
		total += score;
	}// setTotal

	/**
	 * ������ ��� ��
	 * 
	 * @return
	 */
	public int getTotal() {
		return total;
	}// getTotal

	/**
	 * ���������� �ʱ�ȭ
	 */
	public void resetTotal() {
		total = 0;
	}// resetTotal
		//////////////////////////////////

	/**
	 * ��հ��� ���ϱ�
	 * 
	 * @param score
	 */
	public void setAverage(int scorelength) {
		average = total / (double) scorelength;
	}// setAverage

	/**
	 * ��հ��� ��ȯ�ϱ�
	 * 
	 * @return ��հ�
	 */
	public double getAverage() {
		return average;
	}

	///////////////////////////////////
	public void addsubTotal(int score) {
		subtotal += score;
	}// setTotal

	/**
	 * ���������� ��� ��
	 * 
	 * @return
	 */
	public int getsubTotal() {
		return subtotal;
	}// getTotal

	/**
	 * ������������ ����
	 * 
	 * @return
	 */
	public void addSubAllTotal() {
		allsubtotal += subtotal;
	}

	/**
	 * ���������� ��ȯ
	 * 
	 * @return ����������
	 */
	public int getSubAllTotal() {
		return allsubtotal;
	}

	/**
	 * ��� �������� ���
	 * 
	 * @param score ������ ��
	 */
	public double setSubAllAverage(int scorelength) {
		allsubaverage = (double) allsubtotal / scorelength;
		return allsubaverage;
	}

	/**
	 * �������������� �ʱ�ȭ
	 */
	public void resetsubTotal() {
		subtotal = 0;
	}// resetTotal
		////////////////////////////////////////

	/**
	 * ���� ��հ��� ���ϱ�
	 * 
	 * @param score
	 */
	public void setsubAverage(int scorelength) {
		subaverage = subtotal / (double) scorelength;
	}// setAverage

	/**
	 * ���� ��հ��� ��ȯ�ϱ�
	 * 
	 * @return ������հ�
	 */
	public double getsubAverage() {
		return subaverage;
	}

	/**
	 * �ְ����� ���ϴ� method
	 * 
	 * @param score ���� ����
	 * @return �ְ���
	 */
	public int MaxScore(int score) {
		if (max < score) {
			max = score;
		}
		return max;
	}

	/**
	 * �ְ����� ����
	 */
	public void resetMaxScore() {
		max = 0;
	}

	/**
	 * �ְ��� ����� �̸�,����,��ȣ
	 * @param score �������
	 * @return �ְ�������� �̸�, ����,��ȣ
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
	 * �ڹ������� �������� ���ϴ� method
	 * @param score ��� �л��� score
	 */
	public void asc(int[][] score) {
		int temp=0;
		System.out.println("�ڹ������� ��������: ");
		for(int i=0; i<score.length-1;i++) {
			for(int j=i+1;j<score.length;j++) {
				if(score[i][1]>score[j][1]) { //�չ��� ���� �޹溸�� �۴ٸ�
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
	 * 1.�� �л��� ����� ���Ͽ� ���(��� �Ҽ����� ���ڸ� ������ ���).
	 * 
	 * @param total
	 */
	public String[] nameData() {
		String[] name = { "������", "������", "���ü�", "������", "������", "�����" };
		return name;
	}// nameData

	public int[][] scoreData() {
		int[][] score = { { 85, 86, 81 }, { 95, 91, 100 }, { 89, 71, 59 }, { 97, 96, 91 }, { 78, 74, 77 },
				{ 100, 95, 68 } };
		return score;
	}

	public String[] subjectData() {
		String[] subject = { "Oracle", "Java", "JDBC" }; // ����2
		return subject;
	}

	////////////////////////////////////////////////
	public void printScore(String[] subject, String[] name, int[][] score) {
		// ���� - ��� ���� �մ��� �Ű������� ��ȯ���� ����Ͽ�
		// method�� �����Ͽ� ȣ���Ͽ� ����Ѵ�.
		// 1.�� �л��� ����� ���Ͽ� ���(��� �Ҽ����� ���ڸ� ������ ���).
		System.out.println("��ȣ\t�̸�\tOracle\tJava\tJDBC\t����\t���");
		System.out.println("-------------------------------------------------------");

		for (int i = 0; i < score.length; i++) {// ��
			System.out.printf("%d\t%s\t", i + 1, name[i]);
			for (int j = 0; j < score[i].length; j++) {// ��
				System.out.printf("%d\t", score[i][j]);
				addTotal(score[i][j]);
				setAverage(score[i].length);// ����1. ��ձ��ϴ� method

			} // end for
			System.out.print(getTotal() + "\t");
			System.out.printf("%.2f\n", getAverage());// ����1. ����� ����ϴ� method
			resetTotal();

		} // end for
		System.out.println("-------------------------------------------------------");
		// 2. �� ����� ������ ������ ����
		System.out.println("��������-----------------------------------------------");
		for (int j = 0; j < score[0].length; j++) {
			for (int i = 0; i < score.length; i++) {
				addsubTotal(score[i][j]);
			}
			System.out.printf("%s�� ����: ", subject[j]);
			System.out.printf("%d\n", getsubTotal());
			addSubAllTotal();
			resetsubTotal();
		}
		System.out.printf("��ü ����: %d\n", getSubAllTotal());
		// 3. �� ����� ��հ� ��ü ���(��ü����� �Ҽ����� ���ڸ����� ���)
		System.out.println("�������-----------------------------------------------");
		for (int j = 0; j < score[0].length; j++) {
			for (int i = 0; i < score.length; i++) {
				addsubTotal(score[i][j]);
				setsubAverage(score[0].length);
			}
			System.out.printf("%s�� ���: ", subject[j]);
			System.out.printf("%.2f\n", getsubAverage());
			resetsubTotal();
		}
		System.out.printf("��ü ���: %.2f\n", setSubAllAverage(score.length*score[0].length));
		System.out.println("-----------------------------------------------------------");
		// 4. �� ����� �ְ������� ���
		int[] max = new int[3];
		for (int j = 0; j < score[0].length; j++) {
			for (int i = 0; i < score.length; i++) {
				max[j] = MaxScore(score[i][j]);
			}
			resetMaxScore();
		}
		for (int i = 0; i < subject.length; i++) {
			System.out.printf("�ְ� ���� %s : [%d ]\n", subject[i], max[i]);
		}
		System.out.println("-----------------------------------------------------------");

		// 5. �ϵ��л��� �̸��� ����, ��ȣ
		topScoreStu(score, name);
		System.out.printf("TOP �̸� [%s ]  ����[%s ]  ��ȣ[%s ] \n ",topStudent[0],topStudent[1],topStudent[2]);
		
		// 6. �ڹ������� �������� �����Ͽ� ���.
		System.out.println("");
		asc(score);

	}// printScore

	// ����2.
	/*
	 * 2���� �迭�� ������ �������� ����� �Ʒ��� ���� ���� �־� ����ϴ� method �ۼ�. 
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
		// ó��
		sp2.printScore(subject, name, score);
		sp2.makeArray();
	}
}
