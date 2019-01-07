package day0107;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Test0107 {
	public Test0107() {
		
	}
	
	public List<TestVO0107> selectTest(String name) throws SQLException {
		List<TestVO0107> list = new ArrayList<TestVO0107>();
		//1. 드라이버 로딩
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection con = null;
		Statement stmt = null;
		ResultSet rs =null;
		try {
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
			String id="scott";
			String pass ="tiger";
		//2. Connection 얻기
			con = DriverManager.getConnection(url, id, pass);
			
		//3. 쿼리문 수행 객체얻기
			stmt = con.createStatement();
		//4. 쿼리 수행 후 결과얻기
			StringBuilder sb =new StringBuilder();
			sb.append(" select name,age,addr ")
			.append(" from test_table_0107 ")
			.append(" where name = '").append(name).append("'");
			rs = stmt.executeQuery(sb.toString());
			
			TestVO0107 tv0107= null;
			while(rs.next()) {
				tv0107 = new TestVO0107(rs.getString("name"),rs.getInt("age"),rs.getString("addr"));
				list.add(tv0107);
			}
			for(int i=0; i<list.size();i++) {
				System.out.println(list.get(i).getName()+list.get(i).getAge()
						+list.get(i).getAddr());
			}
		//.5 연결끊기
		}finally {
			if(rs!=null) {rs.close();}
			if(stmt!=null) {stmt.close();}
			if(con!=null) {con.close();}
			
		}
		return list;
	}
	public void searchTest0107(String name) {
		try {
			List<TestVO0107> testList = selectTest(name);
			
			String rowData = new String();
			for(TestVO0107 tv0107:testList) {
				rowData = tv0107.getName()+" "+tv0107.getAge()+" "+tv0107.getAddr();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		Test0107 ts = new Test0107();
		try {
			ts.selectTest("kong");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ts.searchTest0107("kong");
	}
}
