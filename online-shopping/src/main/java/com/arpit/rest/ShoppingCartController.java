package com.arpit.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arpit.entity.ShoppingCart;
import com.arpit.pojo.Checkout;
import com.arpit.pojo.Items;
import com.arpit.pojo.UserProduct;
import com.arpit.service.ShoppingCartServcie;


@CrossOrigin
@RestController
@RequestMapping(value="Cart")
public class ShoppingCartController {
	
	@Autowired
	private ShoppingCartServcie service;
	
	@PostMapping(value="/create/{uid}",consumes="application/json")
	public String createCart(@PathVariable int uid) {//working
		return "Shopping Cart with id: "+service.createCart(uid)+" has been created";
	}
	
	@PostMapping(value="/addToCart",consumes="application/json")
	public String addToCart(@RequestBody UserProduct p) {//working
		try {
			return "Your product has been added to Cart \nTotal Price: "+service.addToCart(p);
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
	@PostMapping(value="/Checkout",consumes="application/json")
	public String checkout(@RequestBody Checkout c) {//working
		try {
			String oid = service.checkout(c.getCid(),c.getUid(),c.getAdid());
			return oid;
		} catch (Exception e) {
			return e.getMessage();
		}
		
	}
	
	@GetMapping(value="/fetchByUserID/{uid}",produces="application/json")
	public ShoppingCart fetchByUserId(@PathVariable int uid) {//working
		return service.fetchCart(uid);
	}
	
	@GetMapping(value="/view/{cartid}",produces="application/json")
	public List<Items> viewCart(@PathVariable int cartid) {//working
		return service.viewCart(cartid);
	}
}
