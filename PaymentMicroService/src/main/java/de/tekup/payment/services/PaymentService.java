package de.tekup.payment.services;

import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.springframework.stereotype.Service;

import de.tekup.payment.dto.TransactionOrderReq;
import de.tekup.payment.dto.TransactionPaymentRes;
import de.tekup.payment.entities.Payment;
import de.tekup.payment.repos.PaymentRepos;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PaymentService {
	
	private PaymentRepos paymentRepos;
	
	public List<Payment> allPayments(){
		return paymentRepos.findAll();
	}
	
	public TransactionPaymentRes savePaymentForOrder(TransactionOrderReq orderReq) {
		Payment payment = new Payment();
		payment.setOrderId(orderReq.getOrderId());
		payment.setOrderValue(orderReq.getOrderValue());
		payment.setPaymentStatus(payProcess());
		if(payment.getPaymentStatus().equals("success"))
			payment.setTransactionId(UUID.randomUUID().toString());
		paymentRepos.save(payment);
		return new TransactionPaymentRes(payment.getPaymentStatus(),payment.getTransactionId());
	}
	
	//simulation of 3rd party (Paypal)
	private String payProcess() {
		return new Random().nextBoolean()?"success":"failed";
	}

}
