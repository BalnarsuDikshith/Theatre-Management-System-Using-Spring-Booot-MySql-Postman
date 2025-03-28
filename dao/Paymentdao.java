package com.qsp.Theatre_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.Theatre_management_system.dto.Payment;
import com.qsp.Theatre_management_system.repo.PaymentRepo;

@Repository
public class Paymentdao {

	@Autowired
	PaymentRepo paymentRepo;
	
	public Payment savePayment(Payment payment) {
		return paymentRepo.save(payment);
	}
	
	public Payment fetchPaymentById(int paymentId) {
		Optional<Payment> dbPayment=paymentRepo.findById(paymentId);
		if(dbPayment.isPresent()) {
			return dbPayment.get();
		}else {
			return null;
		}
		
	}
	
	public List<Payment> fetchAllPayment(){
		return paymentRepo.findAll();
	}
	
	public Payment deletePaymentById(int paymentId) {
		Payment payment= paymentRepo.findById(paymentId).get();
	paymentRepo.delete(payment);
		return payment;
	}
	
	public Payment updatePaymentById(int oldPaymentId, Payment newPayment) {
		newPayment.setPaymentId(oldPaymentId);
		return paymentRepo.save(newPayment);
	}
}
