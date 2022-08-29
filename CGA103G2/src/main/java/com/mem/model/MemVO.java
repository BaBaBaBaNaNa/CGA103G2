package com.mem.model;

import java.sql.Date;

import org.apache.taglibs.standard.lang.jstl.test.beans.PublicBean1;

public class MemVO implements java.io.Serializable {
	private Integer memID;
	private String memName;
	private String memAccount;
	private String memPassword;
	private Integer memGender;
	private String memPhone;
	private String memEmail;
	private String memAddress;
	private Date memBirthday;
	private Integer memPermission;
	
	
	public Integer getMemID() {
		return memID;
	}
	public void setMemID(Integer memID) {
		this.memID = memID;
	}
	public String getMemName() {
		return memName;
	}
	public void setMemName(String memName) {
		this.memName = memName;
	}
	public String getMemAccount() {
		return memAccount;
	}
	public void setMemAccount(String memAccount) {
		this.memAccount = memAccount;
	}
	public String getMemPassword() {
		return memPassword;
	}
	public void setMemPassword(String memPassword) {
		this.memPassword = memPassword;
	}
	public Integer getMemGender() {
		return memGender;
	}
	public void setMemGender(Integer memGender) {
		this.memGender = memGender;
	}
	public String getMemPhone() {
		return memPhone;
	}
	public void setMemPhone(String memPhone) {
		this.memPhone = memPhone;
	}
	public String getMemEmail() {
		return memEmail;
	}
	public void setMemEmail(String memEmail) {
		this.memEmail = memEmail;
	}
	public String getMemAddress() {
		return memAddress;
	}
	public void setMemAddress(String memAddress) {
		this.memAddress = memAddress;
	}
	public Date getMemBirthday() {
		return memBirthday;
	}
	public void setMemBirthday(Date memBirthday) {
		this.memBirthday = memBirthday;
	}
	public Integer getMemPermission() {
		return memPermission;
	}
	public void setMemPermission(Integer memPermission) {
		this.memPermission = memPermission;
	}


}