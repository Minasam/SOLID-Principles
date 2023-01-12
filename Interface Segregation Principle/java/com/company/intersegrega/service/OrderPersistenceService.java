package com.company.intersegrega.service;

import java.util.HashMap;
import java.util.List;

import com.company.intersegrega.entity.Order;

public class OrderPersistenceService implements PersistenceService<Order> {
	
	private HashMap<Long, Order> ORDERS = new HashMap<>();

	@Override
	public void save(Order order) {
		synchronized (ORDERS) {
			ORDERS.put(order.getId(), order);
		}
		
	}

	@Override
	public void delete(Order order) {
		synchronized (ORDERS) {
			ORDERS.remove(order.getId());
		}
	}

	@Override
	public Order findById(Long id) {
		synchronized (ORDERS) {
			return ORDERS.get(id);
		}
	}


}
