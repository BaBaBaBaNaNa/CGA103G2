package com.rsvtCtrl.model;

import java.sql.Date;

public class RsvtCtrlVO {
	private Integer rsvtCtrlId;
	private Integer tableTypeId;
	private Integer rsvtCtrlOpen;
	private Date rsvtCtrlDate;
	private Integer rsvtCtrlPeriod;
	private Integer rsvtCtrlMax;
	private Integer rsvtCtrlNumber;

	public Integer getRsvtCtrlId() {
		return rsvtCtrlId;
	}

	public void setRsvtCtrlId(Integer rsvtCtrlId) {
		this.rsvtCtrlId = rsvtCtrlId;
	}

	public Integer getTableTypeId() {
		return tableTypeId;
	}

	public void setTableTypeId(Integer tableTypeId) {
		this.tableTypeId = tableTypeId;
	}

	public Integer getRsvtCtrlOpen() {
		return rsvtCtrlOpen;
	}

	public void setRsvtCtrlOpen(Integer rsvtCtrlOpen) {
		this.rsvtCtrlOpen = rsvtCtrlOpen;
	}

	public Date getRsvtCtrlDate() {
		return rsvtCtrlDate;
	}

	public void setRsvtCtrlDate(Date rsvtCtrlDate) {
		this.rsvtCtrlDate = rsvtCtrlDate;
	}

	public Integer getRsvtCtrlPeriod() {
		return rsvtCtrlPeriod;
	}

	public void setRsvtCtrlPeriod(Integer rsvtCtrlPeriod) {
		this.rsvtCtrlPeriod = rsvtCtrlPeriod;
	}

	public Integer getRsvtCtrlMax() {
		return rsvtCtrlMax;
	}

	public void setRsvtCtrlMax(Integer rsvtCtrlMax) {
		this.rsvtCtrlMax = rsvtCtrlMax;
	}

	public Integer getRsvtCtrlNumber() {
		return rsvtCtrlNumber;
	}

	public void setRsvtCtrlNumber(Integer rsvtCtrlNumber) {
		this.rsvtCtrlNumber = rsvtCtrlNumber;
	}

}
