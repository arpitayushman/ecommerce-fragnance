package com.arpit.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.arpit.entity.Address;



public interface AddressRepository extends JpaRepository<Address, Integer>{
	
	//finds address by user id
	@Query("FROM Address WHERE user_id=:uid")
	List<Address> findAllbyUserId(int uid);
	
}
