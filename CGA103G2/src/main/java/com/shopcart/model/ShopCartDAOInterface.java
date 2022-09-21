package com.shopcart.model;

import java.sql.Connection;
import java.util.*;

import com.login.model.EmpLoginVO;

public interface ShopCartDAOInterface {
    public void insertInsideOrders(ShopCartVO shopcart , ArrayList PriceArrayList, ArrayList NameArrayList, ArrayList CountArrayList);
}