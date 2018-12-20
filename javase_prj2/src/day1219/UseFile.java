package day1219;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.plaf.synth.SynthSpinnerUI;

/**
 * File클래스
 * -파일의 정보얻기
 * -디렉토리 생성
 * -파일 삭제
 * @author owner
 */
public class UseFile {

	public UseFile() {
		String path = "c:/dev/temp/java_read.txt";
		//1.생성
		File file= new File(path);
		System.out.println(file); //그냥 출력하면 파일의 경로가 출력됨
		if(file.exists()) {//파일이 존재할 때
			System.out.println("절대경로: "+file.getAbsolutePath());
			try {
				System.out.println("규범경로: "+file.getCanonicalPath());
			} catch (IOException e) {
				e.printStackTrace();
			}//end catch
			System.out.println("경로: "+file.getPath());
			System.out.println("폴더명: "+file.getParent()); //폴더의 경로
			System.out.println("파일명: "+file.getName()); //파일이름
			
			System.out.println(file.isFile()?"파일":"디렉토리");
			System.out.println(file.isDirectory()?"디렉토리":"파일");
			
			System.out.println("파일길이: "+file.length());
			System.out.println("실행"+(file.canExecute()?"가능":"불가능"));
			System.out.println("읽기"+(file.canRead()?"가능":"불가능"));
			System.out.println("쓰기"+(file.canWrite()?"가능":"불가능"));
			System.out.println(file.isHidden()?"숨김파일":"일반파일");
			Date d = new Date(file.lastModified());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a HH:mm:ss");
			System.out.println("마지막수정일: "+sdf.format(d));
			
			
		}else {
			System.out.println("경로를 찾을 수 없습니다.");
		}
	}
	public static void main(String[] args) {
		new UseFile();
	}

}
