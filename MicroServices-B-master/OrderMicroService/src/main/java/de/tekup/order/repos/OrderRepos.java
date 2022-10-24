package de.tekup.order.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import de.tekup.order.entities.Order;

public interface OrderRepos extends JpaRepository<Order, Integer>{

}
