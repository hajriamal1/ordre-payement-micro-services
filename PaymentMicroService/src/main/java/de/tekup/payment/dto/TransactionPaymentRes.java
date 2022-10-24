package de.tekup.payment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TransactionPaymentRes {
	
	private String paymentStatus;
	private String transactionId;

}
