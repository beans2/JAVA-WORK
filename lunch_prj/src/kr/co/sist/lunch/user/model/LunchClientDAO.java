package kr.co.sist.lunch.user.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.sist.lunch.user.vo.LunchDetailVO;
import kr.co.sist.lunch.user.vo.LunchListVO;

/**
 * 도시락 주문자에 대한 DB처리
 * @author owner
 */
public class LunchClientDAO {
	private static LunchClientDAO lc_dao;
	
	private LunchClientDAO() {
		//1. 
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}//LunchClientDAO
	
	public static LunchClientDAO getInstance() {
		if(lc_dao==null) {
			lc_dao = new LunchClientDAO();
		}//end if
		return lc_dao;
	}//getInstance
	
	private Connection getConn() throws SQLException{
		//2.
		Connection con =null;
		
		String url = "jdbc:oracle:thin:@211.63.89.157:1521:orcl";
		String id ="scott";
		String pass ="tiger";
		con = DriverManager.getConnection(url, id, pass);
		return con;
		
	}//getConn
	
	/**
	 * DB에 추가된 모든 도시락 목록 조회
	 * @return
	 * @throws SQLException
	 */
	public List<LunchListVO> selectLunchList()throws SQLException{
		List<LunchListVO> list = new ArrayList<LunchListVO>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			//1.
			//2.
			con = getConn();
			//3.
			String selectLunch = "	select lunch_code, lunch_name, img, spec from lunch order by lunch_code desc";
			pstmt = con.prepareStatement(selectLunch);
			//4.
			rs = pstmt.executeQuery();
			LunchListVO llv = null;
			while(rs.next()) {
				llv = new LunchListVO(rs.getString("img"), rs.getString("lunch_code"), rs.getString("lunch_Name"), rs.getString("spec"));
				list.add(llv);
			}//end while
			//5.
		}finally {
			//6.
			if(rs!=null) {rs.close();}
			if(pstmt!=null) {pstmt.close();}
			if(con!=null) {con.close();}
		}
		
		return list;
	}//selectLunchList
	
	public LunchDetailVO selectDetailLunch(String lunchCode)throws SQLException{
		LunchDetailVO ldvo = null;
		
		Connection con =null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		try {
		//1.
		//2.
			con= getConn();
		//3.
			String selectLunch = "select img,lunch_name, spec, price from lunch where lunch_code=?";
			pstmt = con.prepareStatement(selectLunch);
		//4.
			pstmt.setString(1, lunchCode);
		//5.
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ldvo = new LunchDetailVO(lunchCode, rs.getString("lunch_name"), rs.getString("spec"),rs.getString("img"), rs.getInt("price"));
			}
			
		}finally {
			//6.
			if(rs!=null) {rs.close();}
			if(pstmt!=null) {pstmt.close();}
			if(con!=null) {con.close();}
		}
		
		
		return ldvo;
	}//selectDetailLunch
	
	public static void main(String[] args) {
		try {
			System.out.println(LunchClientDAO.getInstance().selectDetailLunch("L_000002"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}//class
