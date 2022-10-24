package de.tekup.payment.dto;

import lombok.Data;

@Data
public class TransactionOrderReq {
	
	private int orderId;
	private double orderValue;

}
