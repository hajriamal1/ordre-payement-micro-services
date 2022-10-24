package de.tekup.order.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import de.tekup.order.dto.TransactionOrderReq;
import de.tekup.order.dto.TransactionPaymentRes;

@FeignClient(name="PAYMENT-SERVICE")
public interface PaymentClient {
	
	@PostMapping("/payment/process")
	public TransactionPaymentRes callPayment(@RequestBody TransactionOrderReq req);

}
