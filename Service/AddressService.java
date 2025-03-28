package com.qsp.Theatre_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.qsp.Theatre_management_system.dao.Addressdao;
import com.qsp.Theatre_management_system.dto.Address;
import com.qsp.Theatre_management_system.dto.Owner;
import com.qsp.Theatre_management_system.exception.AddressIdNotFound;
import com.qsp.Theatre_management_system.dto.Address;
import com.qsp.Theatre_management_system.util.ResponseStructure;
import com.qsp.Theatre_management_system.util.ResponseStructureList;

@Service
public class AddressService {
	
	@Autowired
	Addressdao addressdao;
	
	@Autowired
	ResponseStructure<Address> responseStructure;
	@Autowired
	ResponseStructureList<Address> responseStructureList;
	
        public ResponseStructure<Address> saveAddress(Address address) {
		
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Successfully Address inserted into DB");
		responseStructure.setData(addressdao.saveAddress(address));
		return responseStructure;
	}
		
        public ResponseStructure<Address> fetchAddressById(int addressId) {
        	Address address=addressdao.fetchAddressById(addressId);
        	if(address!=null) {
    		responseStructure.setStatusCode(HttpStatus.FOUND.value());
    		responseStructure.setMessage("Successfully Address Updated into DB");
    		responseStructure.setData(addressdao.fetchAddressById(addressId));
    		return responseStructure;
    		}else {
    			throw new AddressIdNotFound();
    		}
    	}
		
		public ResponseStructureList<Address> fetchAllAddress(){
			responseStructureList.setStatusCode(HttpStatus.FOUND.value());
			responseStructureList.setMessage("Successfully All Addresses Fetched into DB");
			responseStructureList.setData(addressdao.fetchAllAddress());
			return responseStructureList;
		}
		
		public ResponseStructure<Address> deleteAddressById(int addressId) {
			Address address=addressdao.fetchAddressById(addressId);
        	if(address!=null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Successfully Address deleted into DB");
			responseStructure.setData(addressdao.deleteAddressById(addressId));
		    return responseStructure;
        	}else {
    			throw new AddressIdNotFound();
    		}
		    
		}
		public ResponseStructure<Address> updateAddressById(int oldAddressId,Address newAddress)
		{
			Address address=addressdao.fetchAddressById(oldAddressId);
        	if(address!=null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Successfully Address Updated into DB");
			responseStructure.setData(addressdao.updateAddressById(oldAddressId,newAddress));
			return responseStructure;
		}else {
			throw new AddressIdNotFound();
		}
		}

}
