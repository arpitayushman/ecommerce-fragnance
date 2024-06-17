package com.arpit.service;

import java.util.List;

import com.arpit.entity.Address;
import com.arpit.pojo.UserAddress;

public interface AddressService {
	
	int addAddress(UserAddress a);
	
	Address getAddress(int aid);
	
	List<Address> listAllAddress();
	
	List<Address> fetchAllAddressByUserId(int userid);
}
