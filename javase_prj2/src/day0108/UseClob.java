package day0108;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.co.sist.connection.GetConnetion;

public class UseClob {

	public UseClob()throws SQLException, IOException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BufferedReader br =null;
		
		try {
		//1.
		//2.
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String id = "scott";
			String pass = "tiger";
			con= GetConnetion.getInstance().getConn(url, id, pass);
		//3.
			String selectClob =
					"select subject,news,reporter,to_char(input_date,'yyyy-mm-dd')input_date from test_clob";
			pstmt = con.prepareStatement(selectClob);
		//4.
		//5.
			rs = pstmt.executeQuery();
			System.out.println("번호\t기자\t작성일\t기사내용\t기사\n");
			System.out.println("-------------------------------------------------------------------------------------");
			
			int cnt=1;
			String reporter = "", input_date ="";
			StringBuilder news=null;
			String temp ="";
			while(rs.next()) {
				reporter=rs.getString("reporter");
				input_date=rs.getString("input_date");
//				news=rs.getString("news"); //clob은 local상에서는 getString으로 얻어진다.
				
				news = new StringBuilder();
				br = new BufferedReader(rs.getClob("news").getCharacterStream());
				while((temp=br.readLine())!=null) {
					news.append(temp).append("\n");
				}//end while
				System.out.printf("%d\t%s\t%s\t%s\n",cnt++,reporter,input_date,news.toString());
			}
			
		}finally {
			//6.
			if(br!=null) {br.close();}
			if(rs!=null) {rs.close();}
			if(pstmt!=null) {pstmt.close();}
			if(con!=null) {pstmt.close();}
		}
	}// UseClob

	public static void main(String[] args) {

			try {
				new UseClob();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} // end catch
	}// main

}// class
