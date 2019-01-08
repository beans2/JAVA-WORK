package day0107;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.SliderUI;

public class UsePreparedStatementDAO {
	public UsePreparedStatementDAO() {

	}// UsePreparedStatementDAO

	private Connection getConn() throws SQLException {
		Connection con = null;
		// 1. ����̹� �ε�
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} // end catch
			// 2.
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
		String id = "scott";
		String pass = "tiger";

		con = DriverManager.getConnection(url, id, pass);

		return con;
	}// getConn

	/**
	 * �����ȣ, �����, ������ �Է¹޾� CpEmp2���̺� �����ϴ� ��
	 * 
	 * @param cevo
	 * @throws SQLException
	 */
	public void insertCpEmp2(CpEmp2VO cevo) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			// 1. ����̹� �ε�
			// 2. Ŀ�ؼǾ��
			con = getConn();
			// 3. ������ ������ü���:PreparedStatement��ü�� ����Ǵ� �������� �˰� �ִ�.
			String insertCpEmp = "insert into cp_emp2(empno, ename, hiredate, sal) values(?,?,sysdate,?)";
			pstmt = con.prepareStatement(insertCpEmp);
			// 4. ���ε庯���� �� �ֱ�
			pstmt.setInt(1, cevo.getEmpno());
			pstmt.setString(2, cevo.getEname());
			pstmt.setInt(3, cevo.getSal());

			// 5. �������� �� ������
			pstmt.executeUpdate();

		} finally {
			// 6. �������
			if (pstmt != null) {
				pstmt.close();
			}
			if (con != null) {
				con.close();
			}

		} // end finally
	}// insertCpEmp2

	/**
	 * �����ȣ, ����� , ������ �Է¹޾� �����ȣ�� �ش��ϴ� �����, ������ �����ϴ� ��.
	 * 
	 * @param cevo
	 * @return
	 * @throws SQLException
	 */
	public boolean updateCpEmp2(CpEmp2VO cevo) throws SQLException {
		boolean flag = false;
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			// 1. ����̹� �ε�
			// 2. Connection ���
			con = getConn();
			// 3. ������ ���� ��ü ���
			String updateCpEmp2 = "update cp_emp2 set ename=?,sal=? where empno=?";
			pstmt = con.prepareStatement(updateCpEmp2);
			// 4. ���ε� ������ �� �ֱ�
			pstmt.setString(1, cevo.getEname());
			pstmt.setInt(2, cevo.getSal());
			pstmt.setInt(3, cevo.getEmpno());

			// 5. ������ ���� �� ��� ���
			int cnt = pstmt.executeUpdate();
			if (cnt != 0) {
				flag = true;
			}
		} finally {
			// 6. ���� ����
		} // end finally
		return flag;
	}// updateCpEmp2

	/**
	 * �����ȣ�� �Է¹޾� �����ȣ�� �ش��ϴ� ����� �����ϴ� ��.
	 * 
	 * @param empno
	 * @return
	 * @throws SQLException
	 */
	public boolean deleteCpEmp2(int empno) throws SQLException {
		boolean flag = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			// 1.����̹��ε�
			// 2.Connetion ���
			con = getConn();
			// 3. ������ ������ü ���
			String deleteCpEmp2 = "delete from cp_emp2 where empno=?";
			pstmt = con.prepareStatement(deleteCpEmp2);
			// 4. ���ε� ������ �� ����
			pstmt.setInt(1, empno);
			// 5. ������ ���� �� ��� ���
			int cnt = pstmt.executeUpdate();
			
			if(cnt!=0) {
				flag =true;
			}//end if
			
		} finally {
			// 6.�������
			if (pstmt != null) {
				pstmt.close();
			}
			if (con != null) {
				con.close();
			}
		}
		return flag;
	}// updateCpEmp2


	/**
	 * ��� �μ� ��������� ��ȸ
	 * @return
	 * @throws SQLException
	 */
	public List<CpEmp2AllVO> selectAllCpEmp2() throws SQLException {
		List<CpEmp2AllVO> list = new ArrayList<CpEmp2AllVO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
		//1.����̹� �ε�
		//2.Connection���
			con = getConn();
		//3. ������ ���� ��ü ���
			String selectAllCpEmp2="select empno, ename, sal, to_char(hiredate, 'yyyy-mm-dd') hiredate from cp_emp2";
			pstmt = con.prepareStatement(selectAllCpEmp2);
		//4. ���ε庯�� �� �ֱ�
		//5. ������ ���� �� ������
			rs = pstmt.executeQuery();
			CpEmp2AllVO cea_vo = null;
			while(rs.next()) {
				cea_vo = new CpEmp2AllVO(rs.getInt("empno"), rs.getInt("sal"),
						rs.getString("ename"),rs.getString("hiredate"));
	
				list.add(cea_vo);
				}//end while
		}finally {
			//6. �������	
			if(rs!=null) {rs.close();}
			if(pstmt!=null) {pstmt.close();}
			if(con!=null) {con.close();}
		}
		return list;
	}// selectAllCpEmp2
	

	/**
	 * �ԷµǴ� �����ȣ�� ������� ��ȸ
	 * @param empno
	 * @return
	 * @throws SQLException
	 */
	public CpEmp2OneVO selectOneCpEmp2(int empno) throws SQLException {
		CpEmp2OneVO cevo = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
		//1. ����̹��ε�
		//2. Connection ���
		con = getConn();
		//3. ������ ���� ��ü ���
		String selectOneCpEmp = "select ename, sal, hiredate from cp_emp2 where empno=?";
		pstmt = con.prepareStatement(selectOneCpEmp);
		//4. ���ε� ���� �� ����
		pstmt.setInt(1, empno);
		//5. ������ ���� �� ��� ���
		rs =pstmt.executeQuery();
		if(rs.next()) {
			cevo = new CpEmp2OneVO(rs.getInt("sal"),rs.getString("ename"),
					rs.getDate("hiredate")); 
		}//end if
		}finally {
			//6. ���� ����
			if(rs!=null) {rs.close();}
			if(pstmt!=null) {pstmt.close();}
			if(con!=null) {con.close();}
		}
		return cevo;
	}
	public static void main(String[] args) {
		UsePreparedStatementDAO u = new UsePreparedStatementDAO();
		try {
			System.out.println(u.selectOneCpEmp2(7521));
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}//main

}// class
