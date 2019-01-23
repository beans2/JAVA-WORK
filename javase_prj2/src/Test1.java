
public class Test1 {
	 /**
	  * 
	  * 
	  * 
	 * @param number
	 * @param k
	 * @return
	 */
	public String solution(String number, int k) {
	        String answer = "";
	        char[] cutStr = new char[number.length()];
	        int index = number.length()-k;
	        //1,2//1,3//1,4//2,3//2,4//3,4
	        for(int i=0;i<cutStr.length;i++) {
	        	cutStr[i] = number.charAt(i);
	        	System.out.println(cutStr[i]);
	        }
	        
	        
	        
	        return answer;
	    }
	public static void main(String[] args) {
	   Test1 t1 = new Test1();
	   t1.solution("1949", 2);
	}
}
