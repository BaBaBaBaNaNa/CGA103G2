package com.mealscateory.model;
import java.sql.Date;

public class MealsCategoryVO implements java.io.Serializable {

	private Integer mealsCategoryID;
	private String mealsCategory;

	public Integer getMealsCategoryId() {
		return mealsCategoryID;
	}
	public void setMealsCategoryId(Integer mealsCategoryID) {
		this.mealsCategoryID = mealsCategoryID;
	}
	public String getMealsCategory() {
		return mealsCategory;
	}
	public void setMealsCategory(String mealsCategory) {
		this.mealsCategory = mealsCategory;
	}
}
