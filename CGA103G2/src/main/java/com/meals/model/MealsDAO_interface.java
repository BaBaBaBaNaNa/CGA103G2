package com.meals.model;
import java.util.*;



public interface MealsDAO_interface {
	public void insert(MealsVO mealsVO);
    public void update(MealsVO mealsVO);
    public void delete(Integer mealsID);
    public MealsVO findByPrimaryKey(Integer mealsID);
    public List<MealsVO> getAll();
    //萬用複合查詢(傳入參數型態Map)(回傳 List)
    public List<MealsVO> getAll(Map<String, String[]> map); 

}
