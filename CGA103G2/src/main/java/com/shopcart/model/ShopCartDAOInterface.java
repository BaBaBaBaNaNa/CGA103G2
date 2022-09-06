package com.shopcart.model;
import java.util.*;

import com.login.model.EmpLoginVO;

public interface ShopCartDAOInterface {
    public void insertOrders(ShopCartVO shopcart);
    
    public void insertOrdersDetail(ShopCartVO shopcart);

	ShopCartVO findByPrimaryKey(Integer ordersID);
}