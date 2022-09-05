package com.meals.model;
import java.util.List;



public interface MealsDAO_interface {
	public void insert(MealsVO mealsVO);
    public void update(MealsVO mealsVO);
    public void delete(Integer mealsID);
    public MealsVO findByPrimaryKey(Integer mealsID);
    public List<MealsVO> getAll();
    //�U�νƦX�d��(�ǤJ�Ѽƫ��AMap)(�^�� List)
//  public List<EmpVO> getAll(Map<String, String[]> map); 

}
