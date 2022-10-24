package de.tekup.order.entities;

import javax.persistence.*;

import lombok.Data;

@Entity
@Table(name="ORDER_TB")
@Data
public class Order {
	@Id
	private int id;
	
	private String name;
	private int qty;
	private double price;
	
	private String transactionId;

}
