package kr.co.sist.lunch.admin.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.sist.lunch.admin.vo.AdminLoginVO;
import kr.co.sist.lunch.admin.vo.LunchVO;

public class LunchAdminDAO {
	
	private static LunchAdminDAO la_dao;
	
	private LunchAdminDAO() {
		//1. 
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}//end catch
	}//LunchAdminDAO
	
	public static LunchAdminDAO getInstance() {
		if(la_dao ==null) {
			la_dao= new LunchAdminDAO();
		}//end if
		return la_dao;
	}//getInstance
	
	private Connection getConn() throws SQLException{
		//2.
		String url = "jdbc:oracle:thin:@211.63.89.157:1521:orcl";
		String id ="scott";
		String pass ="tiger";
		Connection con = DriverManager.getConnection(url, id, pass);
		return con;
		
	}//getConn
	
	/** 
	 * ID와 PASSWARD 를 입력받아 lunch_admin에서 이름을 조회하는 일.
	 * @param alvo
	 * @return
	 * @throws SQLException
	 */
	public String login(AdminLoginVO alvo)throws SQLException{
		String adminName ="";
		
		Connection con = null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		//1.
		//2.
		con = getConn();
		//3.
		String selectName = "SELECT NAME FROM LUNCH_ADMIN WHERE ID =? AND PASS=?";
		pstmt=con.prepareStatement(selectName);
		//4.
		pstmt.setString(1, alvo.getId());
		pstmt.setString(2, alvo.getPass());
		//5./
		rs= pstmt.executeQuery();
		
		if(rs.next()) {
			adminName = rs.getString("NAME");
		//end if
		}
				
		if(rs!=null) {rs.close();}
		if(pstmt!=null) {pstmt.close();}
		if(rs!=null) {rs.close();}
		
		//6.
		return adminName;
		
	}//login
	
	/**
	 * 입력된 도시락의 코드, 이미지 , 도시락명, 단가 조회
	 * @return
	 * @throws SQLException
	 */
	public List<LunchVO> selectLunch()throws SQLException{
		List<LunchVO> list = new ArrayList<LunchVO>();
		
		//1.
		//2.
		//3.
		//4.
		//5.
		//6.
		
		return list;
	}//selectLunch
	
	public static void main(String[] args) {
		try {
			System.out.println(getInstance().login(new AdminLoginVO("1","1234")));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
