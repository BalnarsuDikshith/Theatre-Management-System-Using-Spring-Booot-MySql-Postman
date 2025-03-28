package com.qsp.Theatre_management_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.Theatre_management_system.dto.Payment;
import com.qsp.Theatre_management_system.service.PaymentService;
import com.qsp.Theatre_management_system.util.ResponseStructure;
import com.qsp.Theatre_management_system.util.ResponseStructureList;

@RestController
public class PaymentController {

	@Autowired
	PaymentService paymentService;
	
	@PostMapping("/savePayment")
	public ResponseStructure<Payment> savePayment(@RequestBody Payment payment) {
		return paymentService.savePayment(payment);
	}
	
	@GetMapping("/fetchPaymentById")
	public ResponseStructure<Payment> fetchPaymentById(@RequestParam int paymentId) {
		return paymentService.fetchPaymentById(paymentId);
	}
	
	@GetMapping("/fetchAllPayment")
	public ResponseStructureList<Payment> fetchAllPayment(){
		return paymentService.fetchAllPayment();
	}
	
	@DeleteMapping("/deletePaymentById")
	public ResponseStructure<Payment> deletePaymentById(@RequestParam int paymentId) {
		return paymentService.deletePaymentById(paymentId);
	}
	
	@PutMapping("/updatePaymentById")
	public ResponseStructure<Payment> updatePaymentById(@RequestParam int oldPaymentId,@RequestBody Payment newPayment) {
		return paymentService.updatePaymentById(oldPaymentId, newPayment);
	}
}
