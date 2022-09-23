package com.meals.model;

public class MealsVO implements java.io.Serializable{
	private Integer mealsID;
	private Integer mealsCategoryID;
	private String mealsName;
	private Integer mealsPrice;
	private String mealsInfo;
	private byte[] mealsPicture;
	private Integer mealsControl;
	
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
	public com.mealscateory.model.MealsCategoryVO getMealsCategoryVO() {
		com.mealscateory.model.MealsCategoryService mealsCategorySvc = new com.mealscateory.model.MealsCategoryService();
		com.mealscateory.model.MealsCategoryVO mealsCategoryVO =mealsCategorySvc.getOneMealsCategory(mealsCategoryID);
		return mealsCategoryVO;
    }
}
