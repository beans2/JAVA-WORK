package day0107;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsePreparedStatementDAO {
	public UsePreparedStatementDAO() {
		
	}//UsePreparedStatementDAO
	
	public void insertCpEmp2(CpEmp2VO cevo) throws SQLException{
		
	}//insertCpEmp2
	
	public boolean updateCpEmp2(CpEmp2VO cevo)throws SQLException{
		boolean flag =false;
		
		return flag;
	}//updateCpEmp2
	public boolean deleteCpEmp2(int empno)throws SQLException{
		boolean flag =false;
		
		return flag;
	}//updateCpEmp2
	public List<CpEmp2AllVO> selectAllCpEmp2()throws SQLException{
		List<CpEmp2AllVO> list = new ArrayList<CpEmp2AllVO>();
		
		return list;
	}//selectAllCpEmp2
	
	public CpEmp2OneVO selectOneCpEmp2(int empno)throws SQLException{
		CpEmp2OneVO cevo = null;
		
		return cevo;
	
	}
	
}//class
