package day0107;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ZipcodeViewEvt extends WindowAdapter implements ActionListener {

	private ZipcodeView zv;
	public ZipcodeViewEvt(ZipcodeView zv) {
		this.zv = zv;
	}//ZipcodeViewEvt
	
	@Override
	public void windowClosing(WindowEvent e) {
		zv.dispose();
	}//windowClosing
	
	public String blockInjection(String sql) {
		return sql.replaceAll("'", "").replaceAll("--", "");
	}
	
	
	public List<ZipcodeVO> selectZipcode(String dong) throws SQLException{
		List<ZipcodeVO> list = new ArrayList<ZipcodeVO>();
		//1. 드라이버 로딩
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
			String id ="scott";
			String pass ="tiger";
		//2. Connection 얻기
			con = DriverManager.getConnection(url, id, pass);
		//3. 쿼리문 생성 객체 얻기
			stmt = con.createStatement();
		//4. 쿼리 수행 후 결과얻기
			StringBuilder selectZipcode = new StringBuilder();
			selectZipcode
			.append(" select zipcode,sido,gugun,dong,nvl(bunji,' ') bunji ")
			.append(" from zipcode ")
			.append(" where dong like '").append(blockInjection(dong)).append("%'");
			//select zipcode,sido,gugun,dong,bunji from zipcode where dong like 'dong%'
			rs = stmt.executeQuery(selectZipcode.toString());
			
			ZipcodeVO zv =null;
			while(rs.next()) { //조회된 레코드가 존재한다면
				//VO에 값을 할당하고
				zv = new ZipcodeVO(rs.getString("zipcode"), rs.getString("sido"), rs.getString("gugun"), rs.getString("dong")
						,rs.getString("bunji"));
				//같은 이름의 객체를 여러개 관리하기 위해 List에 추가
				list.add(zv);
			}//end while
			
		//5. 연결끊기
		}finally{
			if(rs!=null) {rs.close();}
			if(stmt!=null) {stmt.close();}
			if(rs!=null) {rs.close();}
		}//end if
		return list;
	}//selectZipcode
	
	//조회결과
	public void searchZipcode(String dong) {
		try {
			//DB에서 조회한 결과를 받아서
			List<ZipcodeVO> listZip = selectZipcode(dong);
			//DefaultTableModel에 추가 ==> JTable에 반영된다.
			DefaultTableModel dtm = zv.getDtmZipcode();
			//D.T.M 초기화
			dtm.setRowCount(0);
			//D.T.M에 행(Row: 우편번호, 주소) 추가
			
			String[] rowData = null;
			for(ZipcodeVO zv: listZip) {
				rowData= new String[2];
				rowData[0] = zv.getZipcode();
				rowData[1]=zv.getSido()+" "+ zv.getGugun()+" "+zv.getDong()+" "+zv.getBunji();
				
				//D.T.M에 행(Row: 우편번호, 주소) 추가
				dtm.addRow(rowData);
			}//end for
			
			if(listZip.isEmpty()) {
				rowData = new String[2];
				rowData[0]="";
				rowData[1]="해당 동은 존재하지 않습니다. ";
				
				
				dtm.addRow(rowData);
			}//end if
			
		} catch (SQLException se) {
			JOptionPane.showMessageDialog(zv,"DB에서 문제가 발생했습니다.");
			se.printStackTrace();
		}
		
	}//searchZipcodes
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String dong = zv.getJtfDong().getText().trim();
		if(!dong.equals("")) {
			searchZipcode(dong);
		}//end if
	}//actionPerformed

}
