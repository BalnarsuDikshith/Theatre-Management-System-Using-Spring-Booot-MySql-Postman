package com.qsp.Theatre_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.Theatre_management_system.dto.Address;
import com.qsp.Theatre_management_system.repo.AddressRepo;

@Repository
public class Addressdao {

	@Autowired
	AddressRepo addressRepo;
	
	public Address saveAddress(Address address) {
	return addressRepo.save(address);
	}
	
	public Address fetchAddressById(int addressId) {
		Optional<Address> dbAddress=addressRepo.findById(addressId);
		if(dbAddress.isPresent()){
			return dbAddress.get();	
		}else {
			return null;
		}
	}
	
	public List<Address> fetchAllAddress(){
		return addressRepo.findAll();
	}
	
	public Address deleteAddressById(int addressId) {
		Address address=fetchAddressById(addressId);
		addressRepo.delete(address);
		return address;
	}
	public Address updateAddressById(int oldAddressId,Address newAddress) {
		newAddress.setAddressId(oldAddressId);
		return addressRepo.save(newAddress);
	}
}
