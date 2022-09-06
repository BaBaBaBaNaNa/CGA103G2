package com.waiting.model;

import java.io.Serializable;
import java.sql.Date;

public class WaitingVO implements Serializable{
	private Integer waiting_id;
	private Date waiting_date;
	private Integer waiting_time;
	private Integer current_no;
	private Integer current_queued_no;
	
	public WaitingVO() {
		super();
	}
	public Integer getwaiting_id() {
		return waiting_id;
	}
	public void setwaiting_id(Integer waiting_id) {
		this.waiting_id = waiting_id;
	}
	public Date getwaiting_date() {
		return waiting_date;
	}
	public void setwaiting_date(Date waiting_date) {
		this.waiting_date = waiting_date;
	}
	public Integer getwaiting_time() {
		return waiting_time;
	}
	public void setwaiting_time(Integer waiting_time) {
		this.waiting_time = waiting_time;
	}
	public Integer getcurrent_no() {
		return current_no;
	}
	public void setcurrent_no(Integer current_no) {
		this.current_no = current_no;
	}
	public Integer getcurrent_queued_no() {
		return current_queued_no;
	}
	public void setcurrent_queued_no(Integer current_queued_no) {
		this.current_queued_no = current_queued_no;
	}
	
	
	

}
