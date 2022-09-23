package com.orddetails.model;

import com.meals.model.MealsVO;

public class OrddetailsVO {

	private Integer orddetailsID;
	private Integer ordersID;
	private Integer mealsID;
	private Integer orddetailsMealsQuantity;
	private Integer orddetailsMealsAmount;
	private Integer orddetailsMealsStatus;
	private Integer orddetailsDeliverStatus;

	public Integer getOrddetailsID() {
		return orddetailsID;
	}

	public void setOrddetailsID(Integer orddetailsID) {
		this.orddetailsID = orddetailsID;
	}

	public Integer getOrdersID() {
		return ordersID;
	}

	public void setOrdersID(Integer ordersID) {
		this.ordersID = ordersID;
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

	public com.meals.model.MealsVO getMealsVO() {
		com.meals.model.MealsService mealsSvc = new com.meals.model.MealsService();
		com.meals.model.MealsVO mealsVO = mealsSvc.getOneMeals(mealsID);

		return mealsVO;
	}

	public com.orders.model.OrdersVO getOrdersVO() {
		com.orders.model.OrdersService ordersSvc = new com.orders.model.OrdersService();
		com.orders.model.OrdersVO  ordersVO = ordersSvc.getOneOrders(ordersID);

		return ordersVO;
	}

}
