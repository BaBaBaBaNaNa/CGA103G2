package com.orders.model;

import java.util.List;


public interface OrdersDAO_interface {
    public void insert(OrdersVO ordersVO);
    public void update(OrdersVO ordersVO);
    public void delete(Integer ordersID);
    public OrdersVO findByPrimaryKey(Integer ordersID);
    public List<OrdersVO> getAll();
    //萬用複合查詢(傳入參數型態Map)(回傳 List)
//  public List<OrdersVO> getAll(Map<String, String[]> map); 
}
