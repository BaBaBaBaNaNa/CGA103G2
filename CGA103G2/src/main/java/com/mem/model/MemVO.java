package com.mem.model;

import java.sql.Date;

import org.apache.taglibs.standard.lang.jstl.test.beans.PublicBean1;

public class MemVO implements java.io.Serializable {
	private Integer mem_id;
	private String mem_name;
	private String mem_account;
	private String mem_password;
	private Integer mem_gender;
	private Integer mem_phone;
	private String mem_email;
	private String mem_address;
	private Date mem_birthday;
	private Integer mem_permission;

	public Integer getMem_id() {
		return mem_id;
	}

	public void setMem_id(Integer mem_id) {
		this.mem_id = mem_id;
	}

	public String getMem_name() {
		return mem_name;
	}

	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}

	public String getMem_account() {
		return mem_account;
	}

	public void setMem_account(String mem_account) {
		this.mem_account = mem_account;
	}

	public String getMem_password() {
		return mem_password;
	}

	public void setMem_password(String mem_password) {
		this.mem_password = mem_password;
	}

	public Integer getMem_gender() {
		return mem_gender;
	}

	public void setMem_gender(Integer mem_gender) {
		this.mem_gender = mem_gender;
	}

	public Integer getMem_phone() {
		return mem_phone;
	}

	public void setMem_phone(Integer mem_phone) {
		this.mem_phone = mem_phone;
	}

	public String getMem_email() {
		return mem_email;
	}

	public void setMem_email(String mem_email) {
		this.mem_email = mem_email;
	}
	
	public String getMem_address() {
		return mem_address;
	}
	public void setMem_address(String mem_address) {
		this.mem_address = mem_address;
	
	}

	public Date getMem_birthday() {
		return mem_birthday;
	}

	public void setMem_birthday(Date mem_birthday) {
		this.mem_birthday = mem_birthday;
	}

	public Integer getMem_permission() {
		return mem_permission;
	}

	public void setMem_permission(Integer mem_permission) {
		this.mem_permission = mem_permission;
	}
}