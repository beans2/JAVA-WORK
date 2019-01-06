package day0104;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Statement 객체를 사용하여 CRUD를 구현하는 클래스
 * CRUD(Create Read Update Delete)의 약자.
 * @author owner
 */
public class UseStatementCRUD {
	/**
	 * VO를 입력받아 VO의 값을 CP_DEPT테이블에 추가
	 * @param cdvo 부서번호, 부서명, 위치를 가진 VO
	 * @throws SQLException 
	 */
	public void insertCpDept(CpDeptVO cdvo) throws SQLException{
		//1.드라이버로딩
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}//end catch
		Connection con = null;
		Statement stmt = null;
		
		try {
		//2.Connection 얻기
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
			String id = "scott";
			String pwd = "tiger";
			
			con = DriverManager.getConnection(url, id, pwd);
		//3.쿼리문 생성객체 얻기
			stmt = con.createStatement();
		//4.쿼리수행 후 결과 얻기
//			String insertCpdept = "insert into cp_dept(deptno,dname,loc) valuse("+
//						cdvo.getDeptno()+",'"+cdvo.getDname()+"','"+cdvo.getLoc()+"')";
			StringBuilder insertCpDept = new StringBuilder();
			insertCpDept.append("insert into cp_dept(deptno,dname,loc) values(")
			.append(cdvo.getDeptno())
			.append(",'")
			.append(cdvo.getDname())
			.append("','")
			.append(cdvo.getLoc())
			.append("')");
			
			int cnt = stmt.executeUpdate(insertCpDept.toString());
			System.out.println(cnt);
		}finally {
			//5. 연결끊기
			if(stmt!=null) {stmt.close();}//end if
			if(con!=null) {con.close();}//end if
		}//end finally
		
	}//insertCpDept
	public boolean updateCpDept(CpDeptVO cdvo) throws SQLException{
		boolean flag = false;
		
		//1. 드라이버로딩
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}//end catch
		Connection con = null;
		Statement stmt = null;
		try {
		//2. Connection 얻기
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
			String id ="scott";
			String pwd ="tiger";
			con = DriverManager.getConnection(url, id, pwd);
			
		//3. 쿼리문 생성객체얻기
			stmt = con.createStatement();
		//4. 쿼리 수행 후 결과 얻기
			StringBuilder updateCpDept = new StringBuilder();
			updateCpDept
			.append("update cp_dept set ")
			.append("dname='").append(cdvo.getDname()).append("', ")
			.append("loc='").append(cdvo.getLoc()).append("' ") 
			.append("where deptno=").append(cdvo.getDeptno());
			
			int cnt = stmt.executeUpdate(updateCpDept.toString());
			//테이블의 구조상 부서번호는 PK이므로 한행만 변경된다.
			if(cnt!=0) {
				flag = true;
			}//end if
			
			
		}finally {	
		//5. 연결끊기
			if(stmt!=null) {stmt.close();}//end if
			if(con!=null) {con.close();}//end if
		}//end finally
		
		return flag;
	}//updateCpDept
	public boolean deleteCpDept(int deptno) throws SQLException{
		boolean flag = false;
		//1.드라이버로딩
			try {
				Class.forName("oracle.jdbc.OracleDriver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}//end catch
		
		Connection con = null;
		Statement stmt = null;
		try {
		//2.Connection 얻기
			String url ="jdbc:oracle:thin:@127.0.0.1:1521:orcl";
			String id ="scott";
			String pass ="tiger";
			con = DriverManager.getConnection(url, id, pass);
		//3.쿼리문 생성객체 얻기
			stmt = con.createStatement();
		//4. 쿼리 수행 후 결과 얻기
			StringBuilder deleteCpDept = new StringBuilder();
			deleteCpDept.append("delete from cp_dept where deptno=").append(deptno);
			
			int cnt = stmt.executeUpdate(deleteCpDept.toString());
			
			if(cnt ==1) {
				flag=true;
			}//end if
		}finally {
			//5. 연결끊기
			if(stmt!=null) {stmt.close();}
			if(con!=null) {con.close();}
		}
		return flag;
	}//deleteCpDept
	
	public List<CpDeptVO> selectAllCpDept() throws SQLException{
		List<CpDeptVO> list = new ArrayList<CpDeptVO>();
		//1. 드라이버로딩
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
		//2. Connection얻기
		String url="jdbc:oracle:thin:@127.0.0.1:1521:orcl";	
		String id="scott";	
		String pass="tiger";	
		
		con= DriverManager.getConnection(url, id, pass);
		//3. 쿼리문 생성객체얻기
		stmt = con.createStatement();
		//4. 쿼리문 수행 후 결과얻기
		String selectCpDept = "select deptno,dname,loc from cp_dept";
		
		rs=stmt.executeQuery(selectCpDept);
		CpDeptVO cdvo = null;
		
		while(rs.next()) { //조회된 레코드가 존재한다면 
//			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
			cdvo= new CpDeptVO(rs.getInt("deptno"),rs.getString("dname"),
					rs.getString("loc"));
			//같은 이름으로 생성된 cdvo객체를 사라지지 않도록 관리하기 위해 List에 추가
			list.add(cdvo);
			
		}//end while
		
		}finally {
			//.5.연결끊기
			if(rs!=null) {rs.close();}
			if(stmt!=null) {stmt.close();}
			if(con!=null) {con.close();}
		}
		
		return list;
	}//selectAllCpDept
	
	public OneCpDeptVO selectCpDept(int deptno) throws SQLException {
		OneCpDeptVO ocdvo = null;
		//1.드라이버 로딩
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection con = null;
		Statement stmt = null;
		ResultSet rs= null;
		
		try {
		//2. Connection 얻기
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
			String id="scott";
			String pass = "tiger";
			con = DriverManager.getConnection(url, id, pass);
		//3. 쿼리문 생성객체얻기
			stmt = con.createStatement();
		//4. 쿼리문 수행 후 결과얻기
			StringBuilder selectCpDept = new StringBuilder();
			selectCpDept.append("select dname,loc from cp_dept where deptno=")
			.append(deptno);
			
			rs=stmt.executeQuery(selectCpDept.toString());
			
			if(rs.next()) {//조회된 레코드가 존재 한다면
//				ocdvo = new OneCpDeptVO(rs.getString("dname"), rs.getString("loc"))
				ocdvo = new OneCpDeptVO(rs.getString("dname"), rs.getString("loc"));
			}//end while
			
		}finally {
			//5. 연결끊기			
			if(rs!=null) {rs.close();}
			if(stmt!=null) {stmt.close();}
			if(con!=null) {con.close();}
		}
		return ocdvo;
	}//selectCpDept
	/**
	 * CP_DEPT 테이블의 모든 부서번호를 조회
	 * @return
	 * @throws SQLException
	 */
	public List<Integer> selectAllCpDeptNo() throws SQLException{
		
		List<Integer> list = new ArrayList<>();
		//1.드라이버 로딩
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection con = null;
		Statement stmt = null;
		ResultSet rs= null;
		try {
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
			String id = "scott";
			String pass = "tiger";
		//2.connection 얻기
			con = DriverManager.getConnection(url, id, pass);
		//3.쿼리문 생성객체 얻기
			stmt = con.createStatement();
		//4.쿼리문 수행 후 결과얻기
			StringBuilder selectCpDept = new StringBuilder();
			selectCpDept.append("select deptno from cp_dept");
			rs = stmt.executeQuery(selectCpDept.toString());
			
		while(rs.next()) {
			list.add(rs.getInt("deptno"));
		}
			
		}catch(SQLException se){
			//5.연결끊기	
			if(rs!=null) {rs.close();}
			if(stmt!=null) {stmt.close();}
			if(con!=null) {con.close();}
		}
		return list;
	}//selectAllCpDeptNo
	
}
