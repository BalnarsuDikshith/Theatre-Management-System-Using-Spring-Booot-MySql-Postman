package com.qsp.Theatre_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.qsp.Theatre_management_system.dao.Paymentdao;
import com.qsp.Theatre_management_system.dto.Payment;
import com.qsp.Theatre_management_system.exception.MovieIdNotFound;
import com.qsp.Theatre_management_system.exception.PaymentIdNotFound;
import com.qsp.Theatre_management_system.dto.Payment;
import com.qsp.Theatre_management_system.util.ResponseStructure;
import com.qsp.Theatre_management_system.util.ResponseStructureList;

@Service
public class PaymentService {

	@Autowired
	Paymentdao paymentdao;
	
	@Autowired
	ResponseStructure<Payment> responseStructure;
	@Autowired
	ResponseStructureList<Payment> responseStructureList;
	
	public ResponseStructure<Payment> savePayment(Payment payment) {
		
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Successfully Payment inserted into DB");
		responseStructure.setData(paymentdao.savePayment(payment));
		return responseStructure;
	}

	
	public ResponseStructure<Payment> fetchPaymentById(int paymentId) {
		Payment payment=paymentdao.fetchPaymentById(paymentId);
		if(payment!=null) {
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Successfully Payment fetched from DB");
		responseStructure.setData(paymentdao.fetchPaymentById(paymentId));
		return responseStructure;
		}else {
		throw new PaymentIdNotFound();
	}
	}
	
	public ResponseStructureList<Payment> fetchAllPayment(){
		responseStructureList.setStatusCode(HttpStatus.FOUND.value());
		responseStructureList.setMessage("Successfully All Owners Fetched from DB");
		responseStructureList.setData(paymentdao.fetchAllPayment());
		return responseStructureList;
	}
	
	public ResponseStructure<Payment> deletePaymentById(int paymentId) {
		Payment payment=paymentdao.fetchPaymentById(paymentId);
		if(payment!=null) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Payment deleted in DB");
		responseStructure.setData(paymentdao.deletePaymentById(paymentId));
	    return responseStructure;
		}else {
			throw new PaymentIdNotFound();
		}
	    
	}
	
	public ResponseStructure<Payment> updatePaymentById(int oldPaymentId,Payment newPayment)
	{
		Payment payment=paymentdao.fetchPaymentById(oldPaymentId);
		if(payment!=null) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Payment Updated into DB");
		responseStructure.setData(paymentdao.updatePaymentById(oldPaymentId,newPayment));
		return responseStructure;
		}else {
			throw new PaymentIdNotFound();
	}
	}

}
