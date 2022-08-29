package com.emp.model;

import java.sql.Date;

public class EmpVO implements java.io.Serializable{
	private Integer empID;
	private String empName;
	private String empAccount;
	private String empPassword;
	private Integer empPermission;
	private String empPhone;
	private String empAddress;
	private Integer jobID;
	private Date empHiredate;
	
    public Integer getEmpID() {
		return empID;
	}
	public void setEmpID(Integer empID) {
		this.empID = empID;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpAccount() {
		return empAccount;
	}
	public void setEmpAccount(String empAccount) {
		this.empAccount = empAccount;
	}
	public String getEmpPassword() {
		return empPassword;
	}
	public void setEmpPassword(String empPassword) {
		this.empPassword = empPassword;
	}
	public Integer getEmpPermission() {
		return empPermission;
	}
	public void setEmpPermission(Integer empPermission) {
		this.empPermission = empPermission;
	}
	public String getEmpPhone() {
		return empPhone;
	}
	public void setEmpPhone(String empPhone) {
		this.empPhone = empPhone;
	}
	public String getEmpAddress() {
		return empAddress;
	}
	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}
	public Integer getJobID() {
		return jobID;
	}
	public void setJobID(Integer jobID) {
		this.jobID = jobID;
	}
	public Date getEmpHiredate() {
		return empHiredate;
	}
	public void setEmpHiredate(Date empHiredate) {
		this.empHiredate = empHiredate;
	}
	public com.job.model.JobVO getJobVO() {
	    com.job.model.JobService jobSvc = new com.job.model.JobService();
	    com.job.model.JobVO jobVO = jobSvc.getOneJob(jobID);
	    return jobVO;
    }
}
