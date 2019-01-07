package day0107;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsePreparedStatementDAO {
	public UsePreparedStatementDAO() {
		
	}//UsePreparedStatementDAO
	
	private Connection getConn() throws SQLException{
		Connection con = null;
		//1. 드라이버 로딩
		try {
			Class.forName("oracle.jdbc.OravleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}//end catch
		//2.
		String url="jdbc:oracle:thin:@127.0.0.1:1521:orcl";
		String id= "scott";
		String pass = "tiger";
		
		con= DriverManager.getConnection(url, id, pass);
		
		return con;
	}//getConn
	
	public void insertCpEmp2(CpEmp2VO cevo) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt =null;
		
		try {
		//1. 드라이버 로딩
		//2. 커넥션얻기
			con=getConn();
		//3. 쿼리문 생성객체얻기:PreparedStatement객체는 실행되는 쿼리문을 알고 있다.
			String insertCpEmp="insert into cp_emp2(empno, ename, hiredate, sal) values(?,?,sysdate,?)";
			pstmt=con.prepareStatement(insertCpEmp);
		//4. 바인드변수에 값 넣기
			pstmt.setInt(1, cevo.getEmpno());
			pstmt.setString(2, cevo.getEname());
			pstmt.setInt(3, cevo.getSal());
			
		//5. 쿼리수행 후 결과얻기
			pstmt.executeUpdate();
			
		}finally {
			//6. 연결끊기
				if(pstmt !=null) {pstmt.close();}
				if(con !=null) {con.close();}
				
		} //end finally
	}//insertCpEmp2
	
//	public static void main(String[] args) {
//		UsePreparedStatementDAO u = new UsePreparedStatementDAO();
//		CpEmp2VO c = new CpEmp2VO(9876,3000,"김희철");
//		try {
//			u.insertCpEmp2(c);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//	}//main
	
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
