package com.orders.model;

import java.sql.Timestamp;
import java.util.List;

public class OrdersService {

	private OrdersDAO_interface dao;
	
	public OrdersService() {
		dao = new OrdersDAO();
	}

	public OrdersVO addOrders(Integer ordersID, Integer memID, Integer empCounterID, Integer empDeliveryID,
			Integer seatID, Integer ordersType, Integer ordersAmount, Integer ordersStatus,
			String ordersDestination, Timestamp ordersBuildDate, Timestamp ordersMakeDate) {

		OrdersVO ordersVO = new OrdersVO();

		ordersVO.setOrdersID(ordersID);
		ordersVO.setMemID(memID);
		ordersVO.setEmpCounterID(empCounterID);
		ordersVO.setEmpDeliveryID(empDeliveryID);
		ordersVO.setSeatID(seatID);
		ordersVO.setOrdersType(ordersType);
		ordersVO.setOrdersAmount(ordersAmount);
		ordersVO.setOrdersStatus(ordersStatus);
		ordersVO.setOrdersDestination(ordersDestination);
		ordersVO.setOrdersBuildDate(ordersBuildDate);
		ordersVO.setOrdersMakeDate(ordersMakeDate);
		dao.insert(ordersVO);

		return ordersVO;
	}

	public OrdersVO updateOrders(Integer ordersID, Integer memID, Integer empCounterID, Integer empDeliveryID,
			Integer seatID, Integer ordersType, Integer ordersAmount, Integer ordersStatus,
			String ordersDestination, Timestamp ordersBuildDate, Timestamp ordersMakeDate) {

		OrdersVO ordersVO = new OrdersVO();

		ordersVO.setOrdersID(ordersID);
		ordersVO.setMemID(memID);
		ordersVO.setEmpCounterID(empCounterID);
		ordersVO.setEmpDeliveryID(empDeliveryID);
		ordersVO.setSeatID(seatID);
		ordersVO.setOrdersType(ordersType);
		ordersVO.setOrdersAmount(ordersAmount);
		ordersVO.setOrdersStatus(ordersStatus);
		ordersVO.setOrdersDestination(ordersDestination);
		ordersVO.setOrdersBuildDate(ordersBuildDate);
		ordersVO.setOrdersMakeDate(ordersMakeDate);
		dao.update(ordersVO);

		return ordersVO;
	}

	public void deleteOrders(Integer ordersID) {
		dao.delete(ordersID);
	}
	
	public OrdersVO getOneOrders(Integer ordersID) {
		return dao.findByPrimaryKey(ordersID);
	}
	
	public List<OrdersVO> getAll(){
		return dao.getAll();
	}
	
}
