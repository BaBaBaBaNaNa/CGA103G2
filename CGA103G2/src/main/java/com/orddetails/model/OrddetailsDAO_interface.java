package com.orddetails.model;

import java.util.List;
import java.util.Map;

public interface OrddetailsDAO_interface {
	public void insert(OrddetailsVO orddetailsVO);
	public void update(OrddetailsVO orddetailsVO);
	public void delete(Integer orddetailsID);
	public OrddetailsVO findByPrimaryKey(Integer orddetailsID);
	public List<OrddetailsVO> getAll();
	 //萬用複合查詢(傳入參數型態Map)(回傳 List)
//  public List<OrddetailsVO> getAll(Map<String, String[]> map); 
}
