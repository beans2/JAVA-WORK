package kr.co.sist.service;

import java.sql.SQLException;
import java.util.List;

import kr.co.sist.dao.Dao;
import kr.co.sist.vo.EmpVO;

public class ServiceImpl implements Service {
	//자식이 아닌 부모의 이름으로 객체를 저장하면 모든 자식을 받을 수 있다.
	private Dao dao;
	
	//Service객체는 업무를 처리하는데 반드시 Dao를 사용해야한다.
	//==>Service는 DAO에 의존성이 있다.(Service객체를 사용할려면 DAO를 의존성주입(DI)받아야한다.)
	public ServiceImpl(Dao dao) {
		this.dao=dao;
	}//ServiceImpl
	
	@Override
	public void addEmp(EmpVO ev) {
		try {
			//업무로직 처리
			System.out.println("추가 작업에 대한 업무로직 처리");
			dao.insertEmp(ev);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}//end catch
	}//addEmp

	@Override
	public List<EmpVO> searchEmp() {
		
		System.out.println("조회작업에 대한 업무로직 처리");
		List<EmpVO> list= null;
		try {
			list= dao.selectEmp();
		} catch (SQLException e) {
			e.printStackTrace();
		}//end catch
		return list;
	}//searchEmp

}







