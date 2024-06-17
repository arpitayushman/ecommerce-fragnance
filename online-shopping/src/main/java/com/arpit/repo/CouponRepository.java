package com.arpit.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arpit.entity.Coupon;



public interface CouponRepository extends JpaRepository<Coupon, Integer> {

}
