package com.orddetails.model;

import java.util.List;

public class OrddetailsService {

	private OrddetailsDAO_interface dao;

	public OrddetailsService() {
		dao = new OrddetailsDAO();
	}

	public OrddetailsVO addOrddetails(Integer orddetailsID, Integer ordersID, Integer mealsID,
			Integer orddetailsMealsQuantity, Integer orddetailsMealsAmount, Integer orddetailsMealsStatus,
			Integer orddetailsDeliverStatus) {
		
		OrddetailsVO orddetailsVO = new OrddetailsVO();
		
		orddetailsVO.setOrddetailsID(orddetailsID);
		orddetailsVO.setOrdersID(ordersID);
		orddetailsVO.setMealsID(mealsID);
		orddetailsVO.setOrddetailsMealsQuantity(orddetailsMealsQuantity);
		orddetailsVO.setOrddetailsMealsAmount(orddetailsMealsAmount);
		orddetailsVO.setOrddetailsMealsStatus(orddetailsMealsStatus);
		orddetailsVO.setOrddetailsDeliverStatus(orddetailsDeliverStatus);
		dao.insert(orddetailsVO);
		
		return orddetailsVO;
	}
	
	public OrddetailsVO updateOrddetails(Integer orddetailsID, Integer ordersID, Integer mealsID,
			Integer orddetailsMealsQuantity, Integer orddetailsMealsAmount, Integer orddetailsMealsStatus,
			Integer orddetailsDeliverStatus) {
		
		OrddetailsVO orddetailsVO = new OrddetailsVO();
		
		orddetailsVO.setOrddetailsID(orddetailsID);
		orddetailsVO.setOrdersID(ordersID);
		orddetailsVO.setMealsID(mealsID);
		orddetailsVO.setOrddetailsMealsQuantity(orddetailsMealsQuantity);
		orddetailsVO.setOrddetailsMealsAmount(orddetailsMealsAmount);
		orddetailsVO.setOrddetailsMealsStatus(orddetailsMealsStatus);
		orddetailsVO.setOrddetailsDeliverStatus(orddetailsDeliverStatus);
		dao.update(orddetailsVO);
		
		return orddetailsVO;
	}
	
	public void deleteOrddetails(Integer orddetailsID) {
		dao.delete(orddetailsID);
	}
	
	public OrddetailsVO getOneOrddetails(Integer orddetailsID) {
		return dao.findByPrimaryKey(orddetailsID);
	}
	
	public List<OrddetailsVO> getAll(){
		return dao.getAll();
	}
	
}
