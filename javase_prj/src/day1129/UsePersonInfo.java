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
		//��ȣ�ο�
		pi1.setNum(1);
		pi2.setNum(2);
		pi3.setNum(3);
		pi4.setNum(4);
		pi5.setNum(5);
		pi6.setNum(6);
		pi7.setNum(7);
		//�̸��ο�
		pi1.setName("������");
		pi2.setName("������");
		pi3.setName("������");
		pi4.setName("���ü�");
		pi5.setName("���ü�");
		pi6.setName("�����");
		pi7.setName("�����");
		//�ּҺο�
		pi1.setAddr("����� ������ ���ﵿ");
		pi2.setAddr("����� ���빮�� ��ʸ���");
		pi3.setAddr("������ ���뱸 ���뵿");
		pi4.setAddr("����� ���α� ���ε�");
		pi5.setAddr("����� ���۱� �󵵵�");
		pi6.setAddr("��⵵ ��õ�� ��õ��");
		pi7.setAddr("����� ������ �����絿");
		//���̺ο�
		pi1.setAge(28);
		pi2.setAge(27);
		pi3.setAge(26);
		pi4.setAge(27);
		pi5.setAge(29);
		pi6.setAge(26);
		pi7.setAge(27);
		//�����ο�
		pi1.setGender("����");
		pi2.setGender("����");
		pi3.setGender("����");
		pi4.setGender("����");
		pi5.setGender("����");
		pi6.setGender("����");
		pi7.setGender("����");
		
		PersonInfo getInfo = null;
		int count=0; //����ð����� ī����
		int max=0; //�ְ����
		for(int i=0; i<personData.length;i++) {
			getInfo= personData[i];
			setPiArray(personData);//�迭������
			if(getInfo.getAddr().contains("�����")==true) { //����ð����� count �ϱ�
				count++;
				setCountSeoul(count);//����� ������ ���ϱ�
			}
			setSumAge(getInfo.getAge()); //������ ���ϱ�
			if(max<getInfo.getAge()) {//�ְ���� ���ϱ�
				max=getInfo.getAge();
				setOldPerson(getInfo.getName(),getInfo.getGender());
			}	
		}//end for

	}
	public void setPiArray(PersonInfo[] array) { //�迭�� �Է��ϴ� method
		for(int i=0; i<personData1.length;i++) {
			personData1[i]= array[i];
		}
	}
	public void	 printPiArray() { //�迭�� ����ϴ� method
		for(int i=0; i<personData1.length;i++) {
			System.out.println(personData1[i].getNum()+", "+personData1[i].getName()+", "
					+personData1[i].getAddr()+", "+personData1[i].getAge()+", "+personData1[i].getGender());
		}	
	}
	
	//////////////////end get////////////////////////
	
	public void setCountSeoul(int count) { //����� ������ �� ���ϱ�
		countS = count;
	}	

	public void printCountSeoul() { //ī��Ʈ ���
		System.out.printf("����� ������ %d��\n",countS);
	}
	
	////////////////////end count///////////////////
	public void setSumAge(int age) { //���� �� ���ϱ�
		sumAge+=age; 
	}

	public void printSumAge() { //������ ���
		System.out.printf("���� �� %d ��\n",sumAge);
	}
	///////////////////end ������///////////////////
	public void setOldPerson(String name, String gender) { //�ְ���� ���ϱ�
		oldName=name;
		oldGender=gender;
	}
	public void printOldPerson() { //�ְ���� ���

		System.out.printf("�ְ���� \"%s(%s)\"\n",oldName,oldGender);
	}
	public static void main(String[] args) {
		UsePersonInfo upi= new UsePersonInfo();
		upi.printPiArray();
		upi.printCountSeoul();
		upi.printSumAge();
		upi.printOldPerson();
	}

}
