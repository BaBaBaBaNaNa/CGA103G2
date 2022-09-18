package com.shopcart.model;

import java.sql.Date;
import java.sql.Timestamp;
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
			int memID,
			int empCounterID,
			int empDeliveryID,
			int seatID,
			int ordersType,
			int ordersAmount,
			int ordersStatus,
			String ordersDestination,
			Timestamp ordersBuildDate,
			Timestamp ordersMakeDate
			) {
		ShopCartVO shopcartVO = new ShopCartVO();

		shopcartVO.setMemID(memID);
		shopcartVO.setEmpCounterID(empCounterID);
		shopcartVO.setEmpDeliveryID(empDeliveryID);
		shopcartVO.setSeatID(seatID);
		shopcartVO.setOrdersType(ordersType);
		shopcartVO.setOrdersAmount(ordersAmount);
		shopcartVO.setOrdersStatus(ordersStatus);
		shopcartVO.setOrdersDestination(ordersDestination);
		shopcartVO.setOrdersBuildDate(ordersBuildDate);
		shopcartVO.setOrdersMakeDate(ordersMakeDate);
		dao.insertOrders(shopcartVO);

		return shopcartVO;
	}
	
	//新增訂單明細
	public ShopCartVO addOrderDetails(
			int memID,
			int empCounterID,
			int empDeliveryID,
			int seatID,
			int ordersType,
			int ordersAmount,
			int ordersStatus,
			String ordersDestination,
			Timestamp ordersBuildDate,
			Timestamp ordersMakeDate
			) {
		ShopCartVO shopcartVO = new ShopCartVO();

		shopcartVO.setMemID(memID);
		shopcartVO.setEmpCounterID(empCounterID);
		shopcartVO.setEmpDeliveryID(empDeliveryID);
		shopcartVO.setSeatID(seatID);
		shopcartVO.setOrdersType(ordersType);
		shopcartVO.setOrdersAmount(ordersAmount);
		shopcartVO.setOrdersStatus(ordersStatus);
		shopcartVO.setOrdersDestination(ordersDestination);
		shopcartVO.setOrdersBuildDate(ordersBuildDate);
		shopcartVO.setOrdersMakeDate(ordersMakeDate);
		dao.insertOrders(shopcartVO);

		return shopcartVO;
	}
	//新增內用訂單
	public ShopCartVO addInsideOrder(
			int ordersType,
			int ordersStatus,
			Timestamp ordersBuildDate
			) {
		ShopCartVO shopcartVO = new ShopCartVO();

		shopcartVO.setOrdersStatus(ordersStatus);
		shopcartVO.setOrdersType(ordersType);
		shopcartVO.setOrdersBuildDate(ordersBuildDate);

		dao.insertInsideOrders(shopcartVO);

		return shopcartVO;
	}
	// ----- ----- ----- 購物車新增訂單 end ----- ----- -----
}
