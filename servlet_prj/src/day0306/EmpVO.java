package day0306;

public class EmpVO {
	private int empno,mgr,sal;
	private String ename,job,hiredate;
	
	public EmpVO(int empno, int mgr, int sal, String ename, String job, String hiredate) {
		super();
		this.empno = empno;
		this.mgr = mgr;
		this.sal = sal;
		this.ename = ename;
		this.job = job;
		this.hiredate = hiredate;
	}

	public int getEmpno() {
		return empno;
	}

	public int getMgr() {
		return mgr;
	}

	public int getSal() {
		return sal;
	}

	public String getEname() {
		return ename;
	}

	public String getJob() {
		return job;
	}

	public String getHiredate() {
		return hiredate;
	}
	
	
}
