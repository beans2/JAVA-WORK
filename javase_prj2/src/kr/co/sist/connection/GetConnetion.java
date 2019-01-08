package kr.co.sist.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Singleton pattern 으로 만드는 클래스<br>
 * DB Connection 을 반환하는 일.
 * @author owner
 */
public class GetConnetion {
	private static GetConnetion gc;
	
	private GetConnetion() {
		
	}
	
	public static GetConnetion getInstance() {
		if(gc ==null) {
			gc = new GetConnetion();
		}//end if
		return gc;
	}//getInstance
	
	public Connection getConn(String url, String id, String pass) throws SQLException{
		Connection con =null;
		//1. 드라이버 로딩
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}//end catch
		//2. Connection얻기
		con = DriverManager.getConnection(url, id, pass);
		return con;
	}//getConn
	
	
}//class
