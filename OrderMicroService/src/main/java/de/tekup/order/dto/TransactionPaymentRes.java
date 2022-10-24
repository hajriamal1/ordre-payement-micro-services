package de.tekup.order.dto;


import lombok.Data;

@Data
public class TransactionPaymentRes {
	
	private String paymentStatus;
	private String transactionId;

}
