package de.tekup.order.dto;

import lombok.Data;
import lombok.AllArgsConstructor;
@Data
@AllArgsConstructor
public class TransactionOrderReq {
	
	private int orderId;
	private double orderValue;

}
