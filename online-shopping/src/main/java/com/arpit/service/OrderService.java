package com.arpit.service;

import java.util.List;

import com.arpit.entity.Order;
import com.arpit.pojo.Items;

public interface OrderService {
	String addOrder(Order ordr);
	
	Order getOrder(String oid);
	
	List<Order>  fetchAllByUserId(int uid);

	List<Items> viewProducts(String order_id);
}
