package com.emp.model;
import java.sql.Date;

public class EmpVO implements java.io.Serializable{
	
	private int emp_id;
	private String emp_name;
	private String emp_account;
	private String emp_password;
	private int emp_permission;
	private String emp_phone;
	private String emp_address;
	private String emp_job;
	private String emp_hiredate;
	
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
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
	public int getEmp_permission() {
		return emp_permission;
	}
	public void setEmp_permission(int emp_permission) {
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
	public String getEmp_job() {
		return emp_job;
	}
	public void setEmp_job(String emp_job) {
		this.emp_job = emp_job;
	}
	public String getEmp_hiredate() {
		return emp_hiredate;
	}
	public void setEmp_hiredate(String emp_hiredate) {
		this.emp_hiredate = emp_hiredate;
	}
	/* */
	
}
