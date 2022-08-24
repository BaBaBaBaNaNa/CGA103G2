package com.emp.model;

import java.sql.Date;

public class EmpVO implements java.io.Serializable{
	private Integer emp_id;
	private String emp_name;
	private String emp_account;
	private String emp_password;
	private Integer emp_permission;
	private String emp_phone;
	private String emp_address;
	private Integer emp_job;
	private Date emp_hiredate;
	public Integer getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(Integer emp_id) {
		this.emp_id = emp_id;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public String getEmp_account() {
		return emp_account;
	}
	public void setEmp_account(String emp_account) {
		this.emp_account = emp_account;
	}
	public String getEmp_password() {
		return emp_password;
	}
	public void setEmp_password(String emp_password) {
		this.emp_password = emp_password;
	}
	public Integer getEmp_permission() {
		return emp_permission;
	}
	public void setEmp_permission(Integer emp_permission) {
		this.emp_permission = emp_permission;
	}
	public String getEmp_phone() {
		return emp_phone;
	}
	public void setEmp_phone(String emp_phone) {
		this.emp_phone = emp_phone;
	}
	public String getEmp_address() {
		return emp_address;
	}
	public void setEmp_address(String emp_address) {
		this.emp_address = emp_address;
	}
	public Integer getEmp_job() {
		return emp_job;
	}
	public void setEmp_job(Integer emp_job) {
		this.emp_job = emp_job;
	}
	public Date getEmp_hiredate() {
		return emp_hiredate;
	}
	public void setEmp_hiredate(Date emp_hiredate) {
		this.emp_hiredate = emp_hiredate;
	}

    public com.job.model.JobVO getJobVO() {
	    com.job.model.JobService jobSvc = new com.job.model.JobService();
	    com.job.model.JobVO jobVO = jobSvc.getOneJob(emp_job);
	    return jobVO;
    }
}
