package com.shopcart.model;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.job.model.JobVO;

public class ShopCartService {

	private ShopCartDAOInterface dao;

	public ShopCartService() {
		dao = new ShopCartDAO();
	}
	// ----- ----- ----- 購物車新增訂單 start ----- ----- -----
	//新增內用訂單
	public ShopCartVO addInsideOrder(
			int ordersType,
			int ordersStatus,
			Timestamp ordersBuildDate,
			ArrayList PriceArrayList,
			ArrayList NameArrayList,
			ArrayList CountArrayList,
			ArrayList NameidArrayList
			) {
		ShopCartVO shopcartVO = new ShopCartVO();

		shopcartVO.setOrdersStatus(ordersStatus);
		shopcartVO.setOrdersType(ordersType);
		shopcartVO.setOrdersBuildDate(ordersBuildDate);

		dao.insertInsideOrders(shopcartVO , PriceArrayList , NameArrayList , CountArrayList  , NameidArrayList);

		return shopcartVO;
	}
	// ----- ----- ----- 購物車新增訂單 end ----- ----- -----
}
