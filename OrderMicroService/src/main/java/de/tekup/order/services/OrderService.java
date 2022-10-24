package de.tekup.order.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import de.tekup.order.dto.TransactionOrderReq;
import de.tekup.order.dto.TransactionPaymentRes;
import de.tekup.order.entities.Order;
import de.tekup.order.repos.OrderRepos;

@Service
public class OrderService {
	
	private OrderRepos orderRepos;
	private RestTemplate template;
	@Value("${gateway.ip}")
	private String GW_URL;
	
	
	
	public OrderService(OrderRepos orderRepos, RestTemplate template) {
		super();
		this.orderRepos = orderRepos;
		this.template = template;
	}

	public List<Order> getOrders(){
		return orderRepos.findAll();
	}
	
	public Order saveOrder(Order order) {
		//process payment
		
		TransactionPaymentRes pay =template.postForObject(GW_URL+"/payment/process",
				new TransactionOrderReq(order.getId(),order.getQty()*order.getPrice())
				,TransactionPaymentRes.class);
		if(pay.getPaymentStatus().equals("success"))
			order.setTransactionId(pay.getTransactionId());
		//else 
		// throw exception PaymentFailed
		
		return orderRepos.save(order);
	}
	//feign
	@Autowired
	private PaymentClient feignClient;
	
	public Order saveOrderFeign(Order order) {
		//process payment
		
		TransactionPaymentRes pay =
				feignClient.callPayment(new TransactionOrderReq(order.getId(),order.getQty()*order.getPrice()));
			
		if(pay.getPaymentStatus().equals("success"))
			order.setTransactionId(pay.getTransactionId());
		//else 
		// throw exception PaymentFailed
		
		return orderRepos.save(order);
	}

}
