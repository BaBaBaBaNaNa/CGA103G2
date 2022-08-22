package com.queuer.model;

import java.io.Serializable;

public class QueuerVO implements Serializable{
	private Integer queuer_id;
	private Integer waiting_id;
	private Integer queuer_status;
	private String queuer_name;
	private String queuer_phone;
	private Integer queuer_no;
	
	
	public QueuerVO() {
		super();
	}
	public Integer getqueuer_id() {
		return queuer_id;
	}
	public void setqueuer_id(Integer queuer_id) {
		this.queuer_id = queuer_id;
	}
	public Integer getwaiting_id() {
		return waiting_id;
	}
	public void setwaiting_id(Integer waiting_id) {
		this.waiting_id = waiting_id;
	}
	public Integer getqueuer_status() {
		return queuer_status;
	}
	public void setqueuer_status(Integer queuer_status) {
		this.queuer_status = queuer_status;
	}
	public String getqueuer_name() {
		return queuer_name;
	}
	public void setqueuer_name(String queuer_name) {
		this.queuer_name = queuer_name;
	}
	public String getqueuer_phone() {
		return queuer_phone;
	}
	public void setqueuer_phone(String queuer_phone) {
		this.queuer_phone = queuer_phone;
	}
	public Integer getqueuer_no() {
		return queuer_no;
	}
	public void setqueuer_no(Integer queuer_no) {
		this.queuer_no = queuer_no;
	}
	
}
