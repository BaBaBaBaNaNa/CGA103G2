package com.orddetails.model;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.orders.model.OrdersVO;

public interface OrddetailsDAO_interface {
	public void insert(OrddetailsVO orddetailsVO);
	public void update(OrddetailsVO orddetailsVO);
	public void delete(Integer orddetailsID);
	public OrddetailsVO findByPrimaryKey1(Integer orddetailsID);
	public List<OrddetailsVO> findByPrimaryKey(Integer orddetailsID);
	public List<OrddetailsVO> getAll();
//	public Set<OrdersVO> get
	 //萬用複合查詢(傳入參數型態Map)(回傳 List)
//  public List<OrddetailsVO> getAll(Map<String, String[]> map); 
}
