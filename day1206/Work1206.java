package day1206;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

public class Work1206 {
	/**
	 * ���� :<br>
	 * 1. �Ʒ��� �����͸� ó���ϴ� ���α׷��� �ۼ��ϼ���. ������,�̺���,������,���ü�,������,������ �� �����Ͱ� �����ϰ�, ������ 0~100��
	 * ���̷� �߻��Ҽ��ֽ��ϴ�.<br>
	 * 
	 * ���α׷��� ����Ǹ� ���� ����߿� 2���̻� ����ó�� ����� �̰� n���� �̸��� ������ �����Ͽ� ����ϴ� ���� �ϴ� ���α׷� �ۼ�.
	 * �ߺ��̸��� �� �� ����.<br>
	 * 
	 * ��� �� ) 
	 * ������ 89<br> 
	 * ���ü� 77<br> 
	 * ������ 90 <br>
	 * ���� xx��<br>
	 */
	
	
	
	public Work1206() {
		Random ranScore = new Random(); //Score ����
		
		List<String> student = new ArrayList<String>();//Student List�� �� ����
		student.add("������");
		student.add("�̺���");
		student.add("������");
		student.add("���ü�");
		student.add("������");
		student.add("������");
		
		List<String> score = new ArrayList<String>();//Score List�� ���� ���� ����
		for(int i=0; i<student.size();i++) {
			score.add(String.valueOf(ranScore.nextInt(99)+1));
		}
		
		int[] randomNum = new int[student.size()];//���� �ε��� �����
		for(int i=0; i<student.size();i++) {			
			randomNum[i] = (int)(Math.random()*(student.size()));
			for(int j=0; j<i;j++) {
				if(randomNum[i]==randomNum[j]) {
					i--;
					break;
				}//end if
			}//end for
		}//end for
		
		int rand = (int)(Math.random()*(student.size()-1)+2);//2�̻��� n�� ����� ���� �ε���
		int totalScore = 0;
		for(int i=0; i<rand;i++) {
			System.out.println(student.get(randomNum[i])+" "+score.get(randomNum[i])); //���� �ε����� �ش��ϴ� �л��� ���(�л� ����)
			totalScore +=Integer.parseInt(score.get(randomNum[i])); //���� ���ϱ�
		}//end for
		System.out.println("����: "+totalScore);
	}// Work1206

	public static void main(String[] args) {
		new Work1206();
	}

}
