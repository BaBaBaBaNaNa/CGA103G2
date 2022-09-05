package com.mealscateory.model;
import java.util.List;

public interface MealsCategory_interface {
	public void insert(MealsCategoryVO MealsCategoryVO);
    public void update(MealsCategoryVO MealsCategoryVO);
    public void delete(Integer mealsCategoryID);
    public MealsCategoryVO findByPrimaryKey(Integer mealsCategoryID);
    public List<MealsCategoryVO> getAll();
    
//  public List<EmpVO> getAll(Map<String, String[]> map); 

}
