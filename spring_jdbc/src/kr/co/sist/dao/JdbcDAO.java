package kr.co.sist.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.sist.domain.DetailMember;
import kr.co.sist.domain.Member;
import kr.co.sist.domain.MemberImg;
import kr.co.sist.vo.MemberUpdateVO;
import kr.co.sist.vo.MemberVO;

@Component
public class JdbcDAO {
	
	@Autowired(required=false)
	private JdbcTemplate jt;
	
	@RequestMapping()
	public void insertMember(MemberVO mv) throws DataAccessException {
		
		StringBuffer insertMember = new StringBuffer();
		insertMember
		.append(" INSERT INTO test_like(num, name, loc, highschool, img) ")
		.append(" VALUES(seq_reply.nextval, ?, ?, ?, ?) ");
		
		jt.update(insertMember.toString(),
			mv.getName(), mv.getLoc(), mv.getHighschool(), mv.getImg());
	}
	
	public List<Member> selectAllMember() throws DataAccessException {
		List<Member> list = null;
		
		// ��ȸ����� Domain�� �����ϴ� ��ü ����(RowMapper)
		RowMapper<Member> rm = new RowMapper<Member>() {
			@Override
			public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
				Member member = new Member(rs.getInt("num"), rs.getString("name"),
						rs.getString("img"));
				return member;
			}
		};
		
		// SQL�� �ۼ�
		String selectMember = "SELECT name, img, num FROM test_like";
		
		// ����
		list = jt.query(selectMember, rm);
		
		return list;
	}
	
	public DetailMember selectOneMember(int num) throws DataAccessException {
		DetailMember dm = null;
		
		RowMapper<DetailMember> rm = new RowMapper<DetailMember>() {
			@Override
			public DetailMember mapRow(ResultSet rs, int rowNum) throws SQLException {
				DetailMember dm = new DetailMember(rs.getString("name"),
						rs.getString("img"), rs.getString("loc"), rs.getString("highschool"));
				return dm;
			}
		};
		
		String selectOneMember = "SELECT name, img, loc, highschool FROM test_like WHERE num=?";
		
		dm = jt.queryForObject(selectOneMember, rm, num);
		
		return dm;
	}
	
	public int updateMember(MemberUpdateVO muv)throws DataAccessException{
		int cnt=0;
		String updateMember= "update test_like set name=?, highschool=?, loc=? where num=?";
		cnt =jt.update(updateMember, muv.getName(), muv.getHighschool(), muv.getLoc(), muv.getNum());
		
		return cnt;
	}//updateMember
	
	public MemberImg deleteMember(int num)throws DataAccessException{
		
		MemberImg mi= null;
		
		String selectImg="select img from test_like where num=?";
		
		RowMapper<MemberImg> rm = new RowMapper<MemberImg>() {
			@Override
			public MemberImg mapRow(ResultSet rs, int idx) throws SQLException {
				MemberImg mi= new MemberImg(0,rs.getString("img"));
				
				return mi;
			}//mapRow
		};//anonymous 
		
		mi=jt.queryForObject(selectImg,rm, num);
		
		String deleteMember="delete from test_like where num=?";
		
		mi.setCnt(jt.update(deleteMember,num));
		
		return mi;
		
	}//deleteMember
}
