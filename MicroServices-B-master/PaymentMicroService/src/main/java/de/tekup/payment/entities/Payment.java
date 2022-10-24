package de.tekup.payment.entities;

import javax.persistence.*;

import lombok.Data;

@Entity
@Table(name="PAYMENT_TB")
@Data
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int paymentId;
	private String paymentStatus;
	private String transactionId;
	
	
	private int orderId;
	private double orderValue;

}
