package com.arpit.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.arpit.entity.ShoppingCart;
import com.arpit.pojo.Items;


public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Integer> {

	@Query("FROM ShoppingCart WHERE user_id=:uid")
	ShoppingCart findCartByUserId(int uid);
	
	@Query(value="SELECT Products.* FROM Products INNER JOIN added_products ON added_products.cart_id=:cartid AND Products.product_id=added_products.product_id",nativeQuery = true)
	List<Items> viewCart(int cartid);
}
