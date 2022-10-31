package com.pragmatest.nolt.customer_orders.web.controllers.requests;

import java.util.List;

public class SubmitOrderRequest {

    private List<OrderItem> orderItems; //list of OrderItem objects

    public SubmitOrderRequest(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public SubmitOrderRequest() {
    }

    // Getters and Setters

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

}
