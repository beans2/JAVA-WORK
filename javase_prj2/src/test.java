
/**
 * String�� �迭 seoul�� element�� Kim�� ��ġ x�� ã��, 
 * �輭���� x�� �ִٴ� String�� ��ȯ�ϴ� �Լ�, solution�� �ϼ��ϼ���. 
 * seoul�� Kim�� ���� �� ���� ��Ÿ���� �߸��� ���� �ԷµǴ� ���� �����ϴ�.
 * @author owner
 */
public class test {
	 public String solution(String[] seoul) {
	      String answer = "";
	      int i=0;
	      while(true) {
	    	  if(seoul[i].equals("Kim")) {
	    		  answer = "�輭���� "+i+"�� �ִ�.";
	    		  break;
	    	  }
	    	  i++;    	  
	      }
	      return answer;
	  }
	public static void main(String[] args) {
		String[] seoul = {"Jane","Gang","Gong","Kim"};
		test tt = new test();
		tt.solution(seoul);
	}
}
