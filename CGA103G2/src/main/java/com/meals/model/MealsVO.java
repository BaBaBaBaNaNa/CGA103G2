package com.meals.model;

public class MealsVO {
	private Integer mealsId;
	private Integer mealsCategoryId;
	private String mealsName;
	private Integer mealsPrice;
	private String mealsInfo;
	private Byte[] meals_picture;
	private Integer mealsControl;
	public Integer getMealsId() {
		return mealsId;
	}
	public Integer getMealsCategoryId() {
		return mealsCategoryId;
	}
	public String getMealsName() {
		return mealsName;
	}
	public Integer getMealsPrice() {
		return mealsPrice;
	}
	public String getMealsInfo() {
		return mealsInfo;
	}
	public Byte[] getmeals_picture() {
		return meals_picture;
	}
	public Integer getMealsControl() {
		return mealsControl;
	}
	public void setMealsId(Integer mealsId) {
		this.mealsId = mealsId;
	}
	public void setMealsCategoryId(Integer mealsCategoryId) {
		this.mealsCategoryId = mealsCategoryId;
	}
	public void setMealsName(String mealsName) {
		this.mealsName = mealsName;
	}
	public void setMealsPrice(Integer mealsPrice) {
		this.mealsPrice = mealsPrice;
	}
	public void setMealsInfo(String mealsInfo) {
		this.mealsInfo = mealsInfo;
	}
	public void setmeals_picture(Byte[] meals_picture) {
		this.meals_picture = meals_picture;
	}
	public void setMealsControl(Integer mealsControl) {
		this.mealsControl = mealsControl;
	}
	

}
