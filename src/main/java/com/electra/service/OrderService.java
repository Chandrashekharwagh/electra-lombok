package com.electra.service;


import com.electra.model.Orders;
import com.electra.repository.OrderRepository;
import java.util.List;

public class OrderService {
    private static final OrderRepository ORDER_REPO = new OrderRepository();

    // Method to retrieve  orders of the database
    public List<Orders> retrieveOrders() {
        return ORDER_REPO.retrieveOrders();
    }
}
