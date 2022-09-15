package com.meals.model;

import java.util.List;
import java.util.Map;




public class MealsService {
	private MealsDAO_interface dao;
	
	public MealsService() {
		dao = new MealsDAO();
	}
	public MealsVO addMeals(Integer mealsCategoryID,String mealsName
			,Integer mealsPrice,String mealsInfo,byte[] mealsPicture,Integer mealsControl) {
		MealsVO mealsVO = new MealsVO();
		
		mealsVO.setMealsCategoryID(mealsCategoryID);
		mealsVO.setMealsName(mealsName);
		mealsVO.setMealsPrice(mealsPrice);
		mealsVO.setMealsInfo(mealsInfo);
		mealsVO.setMealsPicture(mealsPicture);
		mealsVO.setMealsControl(mealsControl);
		
		dao.insert(mealsVO);
		
		return mealsVO;
	}
	
	
	public MealsVO updateMeals(Integer mealsID ,Integer mealsCategoryID,String mealsName
			,Integer mealsPrice,String mealsInfo,byte[] mealsPicture,Integer mealsControl) {
		MealsVO mealsVO = new MealsVO();
		
		mealsVO.setMealsID(mealsID);
		mealsVO.setMealsCategoryID(mealsCategoryID);
		mealsVO.setMealsName(mealsName);
		mealsVO.setMealsPrice(mealsPrice);
		mealsVO.setMealsInfo(mealsInfo);
		mealsVO.setMealsPicture(mealsPicture);
		mealsVO.setMealsControl(mealsControl);
		
		dao.update(mealsVO);
		return dao.findByPrimaryKey(mealsID);
	}
	
	public void updateMeals(MealsVO mealsVO) {
		dao.update(mealsVO);
	}
	public void daletMeals(Integer mealsID) {
		dao.delete(mealsID);
	}
	public MealsVO getOneMeals(Integer mealsID) {
		return dao.findByPrimaryKey(mealsID);
	}
	public List<MealsVO> getAll(){
		return dao.getAll();
	}
	 public List<MealsVO> getAll(Map<String, String[]> map){
		 return dao.getAll(map);
	 }
	
}
