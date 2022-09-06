package com.queuer.model;

import java.io.Serializable;

public class QueuerVO implements Serializable{
	private Integer queuerID;
	private Integer waitingID;
	private Integer queuerStatus;
	private String queuerName;
	private String queuerPhone;
	private Integer queuerNo;
	
	
	public QueuerVO() {
		super();
	}


	public Integer getQueuerID() {
		return queuerID;
	}


	public void setQueuerID(Integer queuerID) {
		this.queuerID = queuerID;
	}


	public Integer getWaitingID() {
		return waitingID;
	}


	public void setWaitingID(Integer waitingID) {
		this.waitingID = waitingID;
	}


	public Integer getQueuerStatus() {
		return queuerStatus;
	}


	public void setQueuerStatus(Integer queuerStatus) {
		this.queuerStatus = queuerStatus;
	}


	public String getQueuerName() {
		return queuerName;
	}


	public void setQueuerName(String queuerName) {
		this.queuerName = queuerName;
	}


	public String getQueuerPhone() {
		return queuerPhone;
	}


	public void setQueuerPhone(String queuerPhone) {
		this.queuerPhone = queuerPhone;
	}


	public Integer getQueuerNo() {
		return queuerNo;
	}


	public void setQueuerNo(Integer queuerNo) {
		this.queuerNo = queuerNo;
	}
	
	
}
