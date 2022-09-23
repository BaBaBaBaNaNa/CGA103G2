package com.orders.model;

import java.io.Serializable;
import java.sql.Timestamp;



public class OrdersVO implements Serializable{
	private Integer ordersID; 
	private Integer memID;
	private Integer empCounterID;
	private Integer empDeliveryID;
	private Integer seatID;
	private Integer ordersType;
	private Integer ordersAmount;
	private Integer ordersStatus;
	private String ordersDestination;
	private Timestamp ordersBuildDate;
	private Timestamp ordersMakeDate;
	public Integer getOrdersID() {
		return ordersID;
	}
	public void setOrdersID(Integer ordersID) {
		this.ordersID = ordersID;
	}
	public Integer getMemID() {
		return memID;
	}
	public void setMemID(Integer memID) {
		this.memID = memID;
	}
	public Integer getEmpCounterID() {
		return empCounterID;
	}
	public void setEmpCounterID(Integer empCounterID) {
		this.empCounterID = empCounterID;
	}
	public Integer getEmpDeliveryID() {
		return empDeliveryID;
	}
	public void setEmpDeliveryID(Integer empDeliveryID) {
		this.empDeliveryID = empDeliveryID;
	}
	public Integer getSeatID() {
		return seatID;
	}
	public void setSeatID(Integer seatID) {
		this.seatID = seatID;
	}
	public Integer getOrdersType() {
		return ordersType;
	}
	public void setOrdersType(Integer ordersType) {
		this.ordersType = ordersType;
	}
	public Integer getOrdersAmount() {
		return ordersAmount;
	}
	public void setOrdersAmount(Integer ordersAmount) {
		this.ordersAmount = ordersAmount;
	}
	public Integer getOrdersStatus() {
		return ordersStatus;
	}
	public void setOrdersStatus(Integer ordersStatus) {
		this.ordersStatus = ordersStatus;
	}
	public String getOrdersDestination() {
		return ordersDestination;
	}
	public void setOrdersDestination(String ordersDestination) {
		this.ordersDestination = ordersDestination;
	}
	public Timestamp getOrdersBuildDate() {
		return ordersBuildDate;
	}
	public void setOrdersBuildDate(Timestamp ordersBuildDate) {
		this.ordersBuildDate = ordersBuildDate;
	}
	public Timestamp getOrdersMakeDate() {
		return ordersMakeDate;
	}
	public void setOrdersMakeDate(Timestamp ordersMakeDate) {
		this.ordersMakeDate = ordersMakeDate;
	}
	
	@Override
	public String toString() {
		return "OrdersVO [ordersID=" + ordersID  +  "]";
	}
	
}
