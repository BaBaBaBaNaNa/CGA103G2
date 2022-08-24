package com.meals.modle;
import java.util.List;



public interface MealsDAO_interface {
	public void insert(MealsVO mealsVO);
    public void update(MealsVO mealsVO);
    public void delete(Integer mealsId);
    public MealsVO findByPrimaryKey(Integer mealsId);
    public List<MealsVO> getAll();
    //萬用複合查詢(傳入參數型態Map)(回傳 List)
//  public List<EmpVO> getAll(Map<String, String[]> map); 

}
