package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import login.vo.AddressVO;
import login.vo.LoginVO;
import login.vo.UserInfoVO;

public class LoginDAO {
	private static LoginDAO l_dao;
	
	private LoginDAO() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static LoginDAO getInstance() {
		if(l_dao==null) {
			l_dao = new LoginDAO();
		}
		return l_dao;
	}
	
	private Connection getConn() throws SQLException{
		Connection con =null;
		
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String id ="scott";
		String pass ="tiger";
		con = DriverManager.getConnection(url, id, pass);
		return con;
	}
	
	public void insertUserInfo(UserInfoVO uivo)throws SQLException{
		
		Connection con =null;
		PreparedStatement pstmt = null;
		try {
		//1.
		//2.
			con= getConn();
		//3.
			String insertUserInfo = "insert into simple_login(id, name, password,tel,email, address, ssn, question, answer) values(?,?,?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(insertUserInfo);
		//4.
			pstmt.setString(1, uivo.getId());
			pstmt.setString(2, uivo.getName());
			pstmt.setString(3, uivo.getPassword());
			pstmt.setString(4, uivo.getTel());
			pstmt.setString(5, uivo.getEmail());
			pstmt.setString(6, uivo.getAddress());
			pstmt.setString(7, uivo.getSsn());
			pstmt.setString(8, uivo.getQuestion());
			pstmt.setString(9, uivo.getAnswer());
		//5.
			pstmt.executeUpdate();
			
		}finally {
			//6.
			if(pstmt!=null) {pstmt.close();}
			if(con!=null) {con.close();}
		}
	}
	
	public String login(LoginVO lvo)throws SQLException{
		
		String name = "";
		Connection con = null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		//1.
		//2.
		con = getConn();
		//3.
		String selectName = "select name from simple_login where id =? and password=?";
		pstmt=con.prepareStatement(selectName);
		//4.
		pstmt.setString(1, lvo.getId());
		pstmt.setString(2, lvo.getPw());
		//5./
		rs= pstmt.executeQuery();
		
		if(rs.next()) {
			name = rs.getString("name");
		//end if
		}
				
		if(rs!=null) {rs.close();}
		if(pstmt!=null) {pstmt.close();}
		if(rs!=null) {rs.close();}
		
		//6.
		return name;
		
	}//login
	
	public List<UserInfoVO> selectUserList() throws SQLException, InterruptedException{
		List<UserInfoVO> list = new ArrayList<UserInfoVO>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			//1.
			//2.
			con = getConn();
			//3.
			String selectUser = "	select id, name, password, tel, email, address, ssn, question, answer "
					+ "from simple_login order by id";
			pstmt = con.prepareStatement(selectUser);
			//4.
			rs = pstmt.executeQuery();
			UserInfoVO uivo = null;
			while(rs.next()) {
				uivo = new UserInfoVO(
						rs.getString("id"),rs.getString("name"), rs.getString("password"), 
						rs.getString("tel"), rs.getString("email"),rs.getString("address"),
						rs.getString("ssn"), rs.getString("question"),rs.getString("answer"));
				list.add(uivo);
			}//end while
			//5.
		}finally {
			//6.
			if(rs!=null) {rs.close();}
			if(pstmt!=null) {pstmt.close();}
			if(con!=null) {con.close(); Thread.sleep(200); }
		}
		
		return list;
	}//selectLunchList
	
	
	
	public List<AddressVO> selectAddress(String dong) throws SQLException {
		List<AddressVO> list= new ArrayList<AddressVO>();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConn();
			String selectAddress = "select zipcode,sido,gugun,dong,nvl(bunji,' ') bunji from zipcode where dong like '%'||?||'%'	";
			pstmt = con.prepareStatement(selectAddress);
			pstmt.setString(1, dong);
			rs = pstmt.executeQuery();
			AddressVO av = null;
			while(rs.next()) {
				av = new AddressVO(rs.getString("zipcode"),rs.getString("sido"), rs.getString("gugun"), rs.getString("dong"), rs.getString("bunji"));

				list.add(av);
			}//end while
		}finally {
			//6.
			if(rs!=null) {rs.close();}
			if(pstmt!=null) {pstmt.close();}
			if(con!=null) {con.close();}
		}
		return list;
	}
	
	public boolean searchId(String id) throws SQLException {
		String searchId ="";
		boolean flag = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConn();
			String selectId = "select id from simple_login where id = ?	";
			pstmt = con.prepareStatement(selectId);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				searchId = rs.getString("id");
			}//end while
		}finally {
			//6.
			if(rs!=null) {rs.close();}
			if(pstmt!=null) {pstmt.close();}
			if(con!=null) {con.close();}
		}
		if(searchId.equals("")) {
			flag = true;
		}
		return flag;
	}
	
	
	
//	public static void main(String[] args) {
//		LoginDAO l_dao = new LoginDAO();
//		try {
//			System.out.println(l_dao.selectUserList());
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
}
