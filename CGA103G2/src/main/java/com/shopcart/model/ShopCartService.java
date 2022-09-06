package com.shopcart.model;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import com.job.model.JobVO;

public class ShopCartService {

	private ShopCartDAOInterface dao;

	public ShopCartService() {
		dao = new ShopCartDAO();
	}
	// ----- ----- ----- 購物車新增訂單 start ----- ----- -----
	//新增訂單
	public ShopCartVO addOrder(
			int empID,
			int memID,
			int empCounterID,
			int empDeliveryID,
			int seatID,
			int ordersType,
			int ordersAmount,
			String ordersDestination,
			java.sql.Date ordersBuildDate,
			java.sql.Date ordersMakeDate
			) {
		ShopCartVO shopcartVO = new ShopCartVO();

		shopcartVO.setEmpID(empID);
		shopcartVO.setMemID(memID);
		shopcartVO.setEmpCounterID(empCounterID);
		shopcartVO.setEmpDeliveryID(empDeliveryID);
		shopcartVO.setSeatID(seatID);
		shopcartVO.setOrdersType(ordersType);
		shopcartVO.setOrdersAmount(ordersAmount);
		shopcartVO.setOrdersDestination(ordersDestination);
		shopcartVO.setOrdersBuildDate(ordersBuildDate);
		shopcartVO.setOrdersMakeDate(ordersMakeDate);
		dao.insertOrders(shopcartVO);

		return shopcartVO;
	}
	
	//新增訂單明細
	public ShopCartVO addOrderDetails(
			int empID,
			int memID,
			int empCounterID,
			int empDeliveryID,
			int seatID,
			int ordersType,
			int ordersAmount,
			String ordersDestination,
			java.sql.Date ordersBuildDate,
			java.sql.Date ordersMakeDate
			) {
		ShopCartVO shopcartVO = new ShopCartVO();

		shopcartVO.setEmpID(empID);
		shopcartVO.setMemID(memID);
		shopcartVO.setEmpCounterID(empCounterID);
		shopcartVO.setEmpDeliveryID(empDeliveryID);
		shopcartVO.setSeatID(seatID);
		shopcartVO.setOrdersType(ordersType);
		shopcartVO.setOrdersAmount(ordersAmount);
		shopcartVO.setOrdersDestination(ordersDestination);
		shopcartVO.setOrdersBuildDate(ordersBuildDate);
		shopcartVO.setOrdersMakeDate(ordersMakeDate);
		dao.insertOrders(shopcartVO);

		return shopcartVO;
	}
	// ----- ----- ----- 購物車新增訂單 end ----- ----- -----
}
