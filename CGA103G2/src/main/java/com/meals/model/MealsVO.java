package com.meals.model;

public class MealsVO {
	private Integer mealsID;
	private Integer mealsCategoryID;
	private String mealsName;
	private Integer mealsPrice;
	private String mealsInfo;
	private byte[] mealsPicture;
	public Integer getMealsID() {
		return mealsID;
	}
	public void setMealsID(Integer mealsID) {
		this.mealsID = mealsID;
	}
	public Integer getMealsCategoryID() {
		return mealsCategoryID;
	}
	public void setMealsCategoryID(Integer mealsCategoryID) {
		this.mealsCategoryID = mealsCategoryID;
	}
	public String getMealsName() {
		return mealsName;
	}
	public void setMealsName(String mealsName) {
		this.mealsName = mealsName;
	}
	public Integer getMealsPrice() {
		return mealsPrice;
	}
	public void setMealsPrice(Integer mealsPrice) {
		this.mealsPrice = mealsPrice;
	}
	public String getMealsInfo() {
		return mealsInfo;
	}
	public void setMealsInfo(String mealsInfo) {
		this.mealsInfo = mealsInfo;
	}
	public byte[] getMealsPicture() {
		return mealsPicture;
	}
	public void setMealsPicture(byte[] mealsPicture) {
		this.mealsPicture = mealsPicture;
	}
	public Integer getMealsControl() {
		return mealsControl;
	}
	public void setMealsControl(Integer mealsControl) {
		this.mealsControl = mealsControl;
	}
	private Integer mealsControl;

	

}
