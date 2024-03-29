package kr.co.sist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.sist.dao.ItemDAO;
import kr.co.sist.domain.ItemDomain;

@Component
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private ItemDAO i_dao;
	
	@Override
	public ItemDomain searchItem(String name) {
		System.out.println("========searchItem ȣ��========");
		return i_dao.selectItem(name);
	}//searchItem

	@Override
	public String getName() {
		String name="������";
		System.out.println("getName ///"+ name);
		return name;
	}

	@Override
	public String getAddr() {
		String addr="����� ������ ���ﵿ ű����";
		
		System.out.println("------DAO------"+i_dao.getDbName());
		System.out.println("getAddr ///"+ addr);
		return addr;
	}

	@Override
	public int getAge() {
		int age=20;
		System.out.println("getAge ///"+ age);
		return age;
	}

	@Override
	public ItemDomain searchData(String name) {
		
		return new ItemDomain("IO_O001","���ü� �ֹ���");
	}
	
}//class
