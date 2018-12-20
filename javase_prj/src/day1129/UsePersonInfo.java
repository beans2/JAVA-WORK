package day1129;

public class UsePersonInfo {
	private int countS;
	private int sumAge;
	private String oldName;
	private String oldGender;
	private PersonInfo[] personData1= new PersonInfo[7] ;
	public UsePersonInfo() {
		PersonInfo pi= new PersonInfo();
		PersonInfo[] personData = new PersonInfo[7];
		PersonInfo pi1= new PersonInfo();
		PersonInfo pi2= new PersonInfo();
		PersonInfo pi3= new PersonInfo();
		PersonInfo pi4= new PersonInfo();
		PersonInfo pi5= new PersonInfo();
		PersonInfo pi6= new PersonInfo();
		PersonInfo pi7= new PersonInfo();
		personData[0]=pi1;
		personData[1]=pi2;
		personData[2]=pi3;
		personData[3]=pi4;
		personData[4]=pi5;
		personData[5]=pi6;
		personData[6]=pi7;
		//번호부여
		pi1.setNum(1);
		pi2.setNum(2);
		pi3.setNum(3);
		pi4.setNum(4);
		pi5.setNum(5);
		pi6.setNum(6);
		pi7.setNum(7);
		//이름부여
		pi1.setName("이재찬");
		pi2.setName("이재현");
		pi3.setName("김정운");
		pi4.setName("정택성");
		pi5.setName("정택순");
		pi6.setName("김건하");
		pi7.setName("이재순");
		//주소부여
		pi1.setAddr("서울시 강남구 역삼동");
		pi2.setAddr("서울시 동대문구 답십리동");
		pi3.setAddr("수원시 영통구 영통동");
		pi4.setAddr("서울시 구로구 구로동");
		pi5.setAddr("서울시 동작구 상도동");
		pi6.setAddr("경기도 부천시 부천동");
		pi7.setAddr("서울시 광진구 광나루동");
		//나이부여
		pi1.setAge(28);
		pi2.setAge(27);
		pi3.setAge(26);
		pi4.setAge(27);
		pi5.setAge(29);
		pi6.setAge(26);
		pi7.setAge(27);
		//성별부여
		pi1.setGender("남자");
		pi2.setGender("남자");
		pi3.setGender("남자");
		pi4.setGender("남자");
		pi5.setGender("여자");
		pi6.setGender("남자");
		pi7.setGender("여자");
		
		PersonInfo getInfo = null;
		int count=0; //서울시거주자 카운터
		int max=0; //최고령자
		for(int i=0; i<personData.length;i++) {
			getInfo= personData[i];
			setPiArray(personData);//배열에저장
			if(getInfo.getAddr().contains("서울시")==true) { //서울시거주자 count 하기
				count++;
				setCountSeoul(count);//서울시 거주자 구하기
			}
			setSumAge(getInfo.getAge()); //나이합 구하기
			if(max<getInfo.getAge()) {//최고령자 구하기
				max=getInfo.getAge();
				setOldPerson(getInfo.getName(),getInfo.getGender());
			}	
		}//end for

	}
	public void setPiArray(PersonInfo[] array) { //배열을 입력하는 method
		for(int i=0; i<personData1.length;i++) {
			personData1[i]= array[i];
		}
	}
	public void	 printPiArray() { //배열을 출력하는 method
		for(int i=0; i<personData1.length;i++) {
			System.out.println(personData1[i].getNum()+", "+personData1[i].getName()+", "
					+personData1[i].getAddr()+", "+personData1[i].getAge()+", "+personData1[i].getGender());
		}	
	}
	
	//////////////////end get////////////////////////
	
	public void setCountSeoul(int count) { //서울시 거주자 명 구하기
		countS = count;
	}	

	public void printCountSeoul() { //카운트 출력
		System.out.printf("서울시 거주자 %d명\n",countS);
	}
	
	////////////////////end count///////////////////
	public void setSumAge(int age) { //나이 합 구하기
		sumAge+=age; 
	}

	public void printSumAge() { //나이합 출력
		System.out.printf("나이 합 %d 살\n",sumAge);
	}
	///////////////////end 나이합///////////////////
	public void setOldPerson(String name, String gender) { //최고령자 구하기
		oldName=name;
		oldGender=gender;
	}
	public void printOldPerson() { //최고령자 출력

		System.out.printf("최고령자 \"%s(%s)\"\n",oldName,oldGender);
	}
	public static void main(String[] args) {
		UsePersonInfo upi= new UsePersonInfo();
		upi.printPiArray();
		upi.printCountSeoul();
		upi.printSumAge();
		upi.printOldPerson();
	}

}
