package com.mealscateory.model;

import java.util.List;
import java.util.Set;

import com.meals.model.MealsVO;


public class MealsCategoryService {

	private MealsCategory_interface dao;

	public MealsCategoryService() {
		dao = new MealsCategoryDAO();
	}

	public MealsCategoryVO addMealsCategory(Integer mealsCategoryID ,String mealsCategory) {

		MealsCategoryVO mealsCategoryVO = new MealsCategoryVO();

		mealsCategoryVO.setMealsCategoryId(mealsCategoryID);
		mealsCategoryVO.setMealsCategory(mealsCategory);
		
		dao.insert(mealsCategoryVO);
		
		return mealsCategoryVO;
	}

	public MealsCategoryVO updateMealsCategory(Integer mealsCategoryID ,String mealsCategory) {

		MealsCategoryVO mealsCategoryVO = new MealsCategoryVO();

		mealsCategoryVO.setMealsCategoryId(mealsCategoryID);
		mealsCategoryVO.setMealsCategory(mealsCategory);
		dao.update(mealsCategoryVO);
		
		return dao.findByPrimaryKey(mealsCategoryID);
//		return mealsCategoryVO;
	}
	public void updateEmp(MealsCategoryVO mealsCategoryVO) {
		dao.update(mealsCategoryVO);
	}
	public void deleteMealsCategory(Integer MealsCategoryId) {
		dao.delete(MealsCategoryId);
	}

	public MealsCategoryVO getOneMealsCategory(Integer mealsCategoryID) {
		return dao.findByPrimaryKey(mealsCategoryID);
	}

	public List<MealsCategoryVO> getAll() {
		return dao.getAll();
	}
	 public Set<MealsVO> getMealsByMealsCategoryID(Integer mealsCategoryID){
		 return dao.getMealsByMealsCategoryID(mealsCategoryID);
	 }

}
