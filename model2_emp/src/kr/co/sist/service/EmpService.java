package kr.co.sist.service;

import java.sql.SQLException;
import java.util.List;

import kr.co.sist.dao.Model2DAO;
import kr.co.sist.vo.EmpVO;

public class EmpService {
	/**
	 * 업무로직 처리, DAO단의 클래스를 사용
	 * @param deptno
	 * @return
	 */
	public List<EmpVO> searchEmp(int deptno){
		List<EmpVO> list= null;
		
		Model2DAO m_dao=Model2DAO.getInstance();
		
		try {
			list=m_dao.selectEmpList(deptno);
			
			for(EmpVO ev:list) { //사원명에 "님" 을 붙인다.
				ev.setEname(ev.getEname()+"님");
			}//end for
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}//searchEmp
}
