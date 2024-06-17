package com.arpit.service;

import java.util.List;

import com.arpit.entity.Coupon;

/**
 * This is a coupon entity related service interface
* @author Mrinal Samanta(@github - Mrinal_Delta)
* @since 0.0.1
**/

public interface CouponService {
	int addCoupon(Coupon coupon);
	
	Coupon fetchCoupon(int id);
	
	List<Coupon> fetchAllCoupons();
}
