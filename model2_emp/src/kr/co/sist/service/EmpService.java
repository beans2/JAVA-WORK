package kr.co.sist.service;

import java.sql.SQLException;
import java.util.List;

import kr.co.sist.dao.Model2DAO;
import kr.co.sist.vo.EmpVO;

public class EmpService {
	/**
	 * �������� ó��, DAO���� Ŭ������ ���
	 * @param deptno
	 * @return
	 */
	public List<EmpVO> searchEmp(int deptno){
		List<EmpVO> list= null;
		
		Model2DAO m_dao=Model2DAO.getInstance();
		
		try {
			list=m_dao.selectEmpList(deptno);
			
			for(EmpVO ev:list) { //����� "��" �� ���δ�.
				ev.setEname(ev.getEname()+"��");
			}//end for
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}//searchEmp
}
