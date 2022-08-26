package com.rsvt.model;

import java.sql.*;

public class RsvtVO {
	private Integer rsvtId;
	private Integer memId;
	private Integer tableTypeId;
	private String customerName;
	private String customerPhone;
	private Integer rsvtNum;
	private Integer rsvtPeriod;
	private Integer rsvtToSeat;
	private Date rsvtDate;
	private Timestamp rsvtMealDate;

	public Integer getRsvtId() {
		return rsvtId;
	}

	public void setRsvtId(Integer rsvtId) {
		this.rsvtId = rsvtId;
	}

	public Integer getMemId() {
		return memId;
	}

	public void setMemId(Integer memId) {
		this.memId = memId;
	}

	public Integer getTableTypeId() {
		return tableTypeId;
	}

	public void setTableTypeId(Integer tableTypeId) {
		this.tableTypeId = tableTypeId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	public Integer getRsvtNum() {
		return rsvtNum;
	}

	public void setRsvtNum(Integer rsvtNum) {
		this.rsvtNum = rsvtNum;
	}

	public Integer getRsvtPeriod() {
		return rsvtPeriod;
	}

	public void setRsvtPeriod(Integer rsvtPeriod) {
		this.rsvtPeriod = rsvtPeriod;
	}

	public Integer getRsvtToSeat() {
		return rsvtToSeat;
	}

	public void setRsvtToSeat(Integer rsvtToSeat) {
		this.rsvtToSeat = rsvtToSeat;
	}

	public Date getRsvtDate() {
		return rsvtDate;
	}

	public void setRsvtDate(Date rsvtDate) {
		this.rsvtDate = rsvtDate;
	}

	public Timestamp getRsvtMealDate() {
		return rsvtMealDate;
	}

	public void setRsvtMealDate(Timestamp rsvtMealDate) {
		this.rsvtMealDate = rsvtMealDate;
	}

	public RsvtVO(String customerName, String customerPhone, Integer rsvtNum, Integer rsvtPeriod) {
		super();
		this.customerName = customerName;
		this.customerPhone = customerPhone;
		this.rsvtNum = rsvtNum;
		this.rsvtPeriod = rsvtPeriod;
	}
	
	public RsvtVO() {}
}
