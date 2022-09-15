package com.shopcart.model;

import java.sql.Date;
import java.sql.Timestamp;

public class ShopCartVO implements java.io.Serializable{
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
	
	private Integer orddetailsID;
	private Integer mealsID;
	private Integer orddetailsMealsQuantity;
	private Integer orddetailsMealsAmount;
	private Integer orddetailsMealsStatus;
	private Integer orddetailsDeliverStatus;
	
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
	
	public Integer getOrddetailsID() {
		return orddetailsID;
	}
	public void setOrddetailsID(Integer orddetailsID) {
		this.orddetailsID = orddetailsID;
	}
	public Integer getMealsID() {
		return mealsID;
	}
	public void setMealsID(Integer mealsID) {
		this.mealsID = mealsID;
	}
	public Integer getOrddetailsMealsQuantity() {
		return orddetailsMealsQuantity;
	}
	public void setOrddetailsMealsQuantity(Integer orddetailsMealsQuantity) {
		this.orddetailsMealsQuantity = orddetailsMealsQuantity;
	}
	public Integer getOrddetailsMealsAmount() {
		return orddetailsMealsAmount;
	}
	public void setOrddetailsMealsAmount(Integer orddetailsMealsAmount) {
		this.orddetailsMealsAmount = orddetailsMealsAmount;
	}
	public Integer getOrddetailsMealsStatus() {
		return orddetailsMealsStatus;
	}
	public void setOrddetailsMealsStatus(Integer orddetailsMealsStatus) {
		this.orddetailsMealsStatus = orddetailsMealsStatus;
	}
	public Integer getOrddetailsDeliverStatus() {
		return orddetailsDeliverStatus;
	}
	public void setOrddetailsDeliverStatus(Integer orddetailsDeliverStatus) {
		this.orddetailsDeliverStatus = orddetailsDeliverStatus;
	}
}
