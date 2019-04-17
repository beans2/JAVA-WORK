package coding_test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class codint_test {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public codint_test() {
		String input = br.readLine();
		if(input!=null) {
			int inputNum= Integer.parseInt(input);
			if(inputNum<0){
				System.out.println("양의 정수를 입력해주세요.");
				return;
			}//end if
			int yacksu=0;
			Set<Integer> yak= new HashSet<Integer>();
			
			for(int i=0;i<inputNum;i++){
					if(inputNum/i==0){
						yak.add(i);	
					}//end if
			}//end if
			System.out.println(yak);
		}

	}
}

