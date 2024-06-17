package com.arpit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arpit.entity.Address;
import com.arpit.entity.User;
import com.arpit.pojo.UserAddress;
import com.arpit.repo.AddressRepository;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressRepository repo;
	
	@Autowired
	private UserService userv;
	
	@Override
	public int addAddress(UserAddress user_add) {
		User u = userv.fetch(user_add.getUid());
		
		Address a = new Address();
		a.setAddressId(user_add.getAid());
		a.setCity(user_add.getCity());
		a.setHouseNo(user_add.getHouseno());
		a.setState(user_add.getState());
		a.setPincode(user_add.getPin());
		a.setStreet(user_add.getStreet());
		a.setUseradd(u);

		userv.update(u);
		repo.save(a);
		
		return a.getAddressId();
	}

	@Override
	public Address getAddress(int aid) {
		return repo.findById(aid).get();
	}

	@Override
	public List<Address> listAllAddress() {
		return repo.findAll();
	}

	@Override
	public List<Address> fetchAllAddressByUserId(int userid) {
		return repo.findAllbyUserId(userid);
	}
		

}
