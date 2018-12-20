package day1220;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

import javax.swing.JOptionPane;

/**
 * 8bit stream 과 16bit stream을 사용하여 문자열 데이터를 File에 기록
 * @author owner
 */
public class UseFileOutputStream2 {
	public UseFileOutputStream2() throws IOException{
		String data = "오지고요 지리고요 고요고요 고요한밤이고요";
		//1. File객체 생성 : 파일이 존재한다면 덮어 쓸것인지를 판단.
		File file = new File("c:/dev/temp/java_write2.txt");
		
		boolean flag = false;//파일이 없을 때
		if(file.exists()) { //파일이 존재할때
			boolean[] temp = {false, true, true}; //예,아니오,취소
			flag = temp[JOptionPane.showConfirmDialog(null,"덮어쓰는부분?ㅇㅈ?")];
		}//end if
		//2.스트림 생성
		if(!flag) {
			BufferedWriter bw=null;	
			try {
//				//파일을 생성하는 스트림: FileNotFoundException 발생 -> 폴더가 없을 때
//				FileOutputStream fos = new FileOutputStream(file); 
//				//3. 문자열을 쓰기위한 스트림을 연결(속도가 느리다.)
//				OutputStreamWriter osw = new OutputStreamWriter(fos);
//				//4. 느린 속도를 개선하기 위한 스트림 연결.
//				bw = new BufferedWriter(osw);
//				
//				bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
				
				////////////////////16bit만 사용//////////////////////////////
				bw= new BufferedWriter(new FileWriter(file));
				
				bw.write(data); //스트림에 데이터를 기록
				bw.flush();//목적지 파일로 분출
				System.out.println("파일에 기록 완료!!!");
			}finally {
				//스트림 객체가 생성되어있다면 연결 끊기
//				if(bw!=null) {bw.close();}//end if
			}
		}//end if
		
		
		
	}//UseFileOutputStream2
	public static void main(String[] args) {
		try {
			new UseFileOutputStream2();
		} catch (IOException e) {
			e.printStackTrace();
		}//end catch
	}//main

}//class
