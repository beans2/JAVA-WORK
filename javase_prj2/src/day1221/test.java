package day1221;

import java.util.ArrayList;
import java.util.List;

public class test {
	public int[] solution(int[] arr, int divisor) {
	      int[] answer = {};
	      ArrayList<Integer> al = new ArrayList<Integer>();
	      ArrayList<Integer> ans = new ArrayList<Integer>();
	      for(int i=0;i<arr.length;i++) {
	    	  if(arr[i]%divisor==0) {
	    		  al.add(i);
	    	  }//end if
	      }//end for
	      System.out.println(al);
	      if(al.size()==0) {
	    	  answer[0] = -1;
	      }else {
	    	  for(int i=0;i<al.size();i++) {
	    		  ans.add(arr[al.get(i)]);
	    	  }//end for
	      }//end else
	      System.out.println(ans);
//	      ans.toArray(answer);
	      
	      return answer;
	  }//solutions
	public static void main(String[] args) {
		test tt = new test();
		int[] arr= {5,9,7,10};
		tt.solution(arr,5);
	}
}
