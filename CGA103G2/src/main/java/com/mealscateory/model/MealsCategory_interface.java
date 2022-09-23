package com.mealscateory.model;
import java.util.*;

import com.job.model.JobVO;
import com.meals.model.*;

public interface MealsCategory_interface {
	public void insert(MealsCategoryVO MealsCategoryVO);
    public void update(MealsCategoryVO MealsCategoryVO);
    public void delete(Integer mealsCategoryID);
    public MealsCategoryVO findByPrimaryKey(Integer mealsCategoryID);
    public List<MealsCategoryVO> getAll();
    
    public List<MealsCategoryVO> getAll(Map<String, String[]> map); 
    
    public Set<MealsVO> getMealsByMealsCategoryID(Integer mealsCategoryID);
    
    public MealsCategoryVO checkRepeatMealsCategoryName(String mealsCategory);

}
