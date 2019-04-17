package kr.co.sist.exam.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.sist.exam.domain.Car;
import kr.co.sist.exam.domain.Demp;
import kr.co.sist.exam.domain.DiaryList;
import kr.co.sist.exam.domain.DynamicIf;
import kr.co.sist.exam.domain.Emp;
import kr.co.sist.exam.domain.EmpJoin;
import kr.co.sist.exam.domain.Union;
import kr.co.sist.exam.domain.Zipcode;
import kr.co.sist.exam.domain.homeworkDomain;
import kr.co.sist.exam.vo.CarVO;
import kr.co.sist.exam.vo.CursorVO;
import kr.co.sist.exam.vo.DeptnoVO;
import kr.co.sist.exam.vo.DiaryListParamVO;
import kr.co.sist.exam.vo.EmpVO;
import kr.co.sist.exam.vo.TestProcVO;
import kr.co.sist.exam.vo.TnameVO;
import kr.co.sist.exam.vo.TransactionVO;
import kr.co.sist.exam.vo.homeworkVO;

public class MyBatisDAO1 {
	
	public List<Emp> multiParam(EmpVO ev){
		List<Emp> list= null;
		//4. Handler ¾ò±â
		SqlSession ss= MyBatisDAO.getInstance().getSessionFactory().openSession();
		
		list= ss.selectList("multiParam",ev);
		
		ss.close();
		return list;
	}//multiParam
	
	public List<Emp> lessThan(int sal){
		List<Emp> list=null;
		
		SqlSession ss= MyBatisDAO.getInstance().getSessionFactory().openSession();
		list=ss.selectList("lessThan",sal);
		ss.close();
		return list;
	}//lessThan
	
	public List<Emp> greaterThan(int sal){
		List<Emp> list=null;
		
		SqlSession ss= MyBatisDAO.getInstance().getSessionFactory().openSession();
		list=ss.selectList("greaterThan",sal);
		ss.close();
		return list;
	}//lessThan
	
	public List<Zipcode> like(String dong){
		List<Zipcode> list =null;
		
		SqlSession ss= MyBatisDAO.getInstance().getSessionFactory().openSession();
		list= ss.selectList("like",dong);
		ss.close();
		return list;
	}//like
	
	public int diaryTotalCount() {
		int cnt=0;
		
		SqlSession ss= MyBatisDAO.getInstance().getSessionFactory().openSession();
		cnt= ss.selectOne("diaryCnt");
		
		return cnt;
	}//diaryTotalCount
	
	public List<DiaryList> subquery(DiaryListParamVO dlpvo){
		List<DiaryList> list= null;
		
		SqlSession ss= MyBatisDAO.getInstance().getSessionFactory().openSession();
		list=ss.selectList("subquery",dlpvo);
		return list;
	}
	
	public List<Union> union(){
		List<Union> list= null;
		SqlSession ss= MyBatisDAO.getInstance().getSessionFactory().openSession();
		list= ss.selectList("union");
		return list;
	}//union
	
	public List<EmpJoin> join(int mgr){
		List<EmpJoin> list= null;
		
		SqlSession ss=MyBatisDAO.getInstance().getSessionFactory().openSession();
		list=ss.selectList("join",mgr);
		return list;
	}
	
	public List<Car> joinSubquery(){
		List<Car> list =null;
		SqlSession ss= MyBatisDAO.getInstance().getSessionFactory().openSession();
		
		list=ss.selectList("joinSubquery");
		
		return list;
	}//joinSubquery
	
	public List<Demp> dynamicTable(TnameVO tvo){
		List<Demp> list= null;
		SqlSession ss= MyBatisDAO.getInstance().getSessionFactory().openSession();
		list= ss.selectList("dtable",tvo);
		return list;
	}//dynamicTable
	
	public List<DynamicIf> dynamicIf(DeptnoVO dvo){
		List<DynamicIf> list= null;
		SqlSession ss= MyBatisDAO.getInstance().getSessionFactory().openSession();
		list= ss.selectList("dynamicIf", dvo);
		return list;
	}//dynamicIf
	
	public List<DynamicIf> dynamicChoose(DeptnoVO dvo){
		List<DynamicIf> list= null;
		SqlSession ss= MyBatisDAO.getInstance().getSessionFactory().openSession();
		list= ss.selectList("kr.co.sist.exam2.dynamicChoose", dvo);
		return list;
	}//dynamicIf
	
	public List<Car> dynamicForeach(CarVO cv){
		
		List<Car> list= null;
		SqlSession ss= MyBatisDAO.getInstance().getSessionFactory().openSession();
		list= ss.selectList("kr.co.sist.exam2.dynamicForeach", cv);
		ss.close();
		return list;
	}//dynamicIf
	
	public TestProcVO insertProc(TestProcVO tpvo){
		SqlSession ss= MyBatisDAO.getInstance().getSessionFactory().openSession();
		ss.selectOne("insertProcedure",tpvo);
		return tpvo;
	}
	
	public void selectProc(CursorVO c_vo) {
		
		SqlSession ss= MyBatisDAO.getInstance().getSessionFactory().openSession();
		ss.selectOne("selectProcedure",c_vo);
		
	}//selectProc
	
	public int insertTransaction(TransactionVO t_vo) {
		int cnt=0, cnt1=0;
		SqlSession ss= MyBatisDAO.getInstance().getSessionFactory().openSession();
		cnt= ss.insert("tr1",t_vo);
		cnt1=ss.insert("tr2",t_vo);
		
		if((cnt+cnt1)==2) {
			ss.commit();
		}else {
			ss.rollback();
		}
		
		return cnt+cnt1;
	}
	
	////////////////////////////////////¼÷Á¦//////////////////////////////////////////////////////
	public List<homeworkDomain> hk( homeworkVO h_vo){
		List<homeworkDomain> list= null;
		SqlSession ss= MyBatisDAO.getInstance().getSessionFactory().openSession();
		list= ss.selectList("selectCar", h_vo);
		return list;
	}//hk
	
	public List<String> selectMaker(String country){
		List<String> list= null;
		SqlSession ss= MyBatisDAO.getInstance().getSessionFactory().openSession();
		list= ss.selectList("selectCarCountry", country);
		return list;
	}//selectMaker
	
	public List<String> selectModel(String maker){
		List<String> list= null;
		SqlSession ss= MyBatisDAO.getInstance().getSessionFactory().openSession();
		list= ss.selectList("selectCarMaker", maker);
		return list;
	}//selectModel
	
	
	////////////////////////////////////¼÷Á¦//////////////////////////////////////////////////////
	
	public static void main(String[] args) {
		MyBatisDAO1 md =new MyBatisDAO1();
		TransactionVO tv= new TransactionVO("¿À´ÃÀº ¾îÂ¾Áö ÁÁÀº ¸ñ¿äÀÏ", "±èÁ¤À±");
		
		System.out.println(md.insertTransaction(tv));
	}
	
}
