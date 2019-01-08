package day0108;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import kr.co.sist.connection.GetConnetion;

/**
 * 실행되는 조회쿼리문을 사용하여 컬럼정보를 얻을 떄 사용하는 interface
 * @author owner
 */
public class UseResultSetMetaData {

	public UseResultSetMetaData() throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ResultSetMetaData rsmd =null;
		
		try {
		//1.
		//2.
			GetConnetion gc = GetConnetion.getInstance(); 
			String url="jdbc:oracle:thin:@localhost:1521:orcl";
			String id = "scott";
			String pass = "tiger";
			con = gc.getConn(url, id, pass);
		//3.
			String selectEmp = "select * from emp";
			pstmt = con.prepareStatement(selectEmp);
		//4.
			
		//5.
			rs = pstmt.executeQuery();
			rsmd = rs.getMetaData();
			//컬럼의  정보 얻기
			
			int cnt = rsmd.getColumnCount();
			System.out.println("컬럼의 수: " +cnt);
			
			String columnName = rsmd.getColumnLabel(1);
			System.out.println("처음 컬럼의 컬럼명: " +columnName);
			
			String columnType = rsmd.getColumnTypeName(1);
			System.out.println("처음 컬럼의 데이터형: " +columnType);
			int columnPrecision = rsmd.getPrecision(1);
			System.out.println("처음 컬럼의 데이터형: " +columnPrecision);
			
			System.out.println("---------------------------------------------------");
			
			StringBuilder output = new StringBuilder();
			for(int i=1;i<cnt+1;i++) {
				output
				.append(rsmd.getColumnLabel(i)).append("\t")
				.append(rsmd.getColumnTypeName(i)).append("\t")
				.append(rsmd.getPrecision(i)).append("\n");
			}//end for
			System.out.println(output);
			
		}finally {
			//6.
			if(rs!=null) {rs.close();}
			if(pstmt!=null) {pstmt.close();}
			if(con!=null) {con.close();}
		}//end finally
	}//UseResultSetMetaData
	
	public static void main(String[] args) {
		try {
			new UseResultSetMetaData();
		} catch (SQLException se) {
			se.printStackTrace();
		}//end catch
	}//main

}//class
