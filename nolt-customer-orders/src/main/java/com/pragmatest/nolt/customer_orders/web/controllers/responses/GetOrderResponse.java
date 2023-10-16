package com.pragmatest.nolt.customer_orders.web.controllers.responses;
import com.pragmatest.nolt.customer_orders.web.controllers.requests.OrderItem;

import java.util.List;

public class GetOrderResponse {
    private List<OrderItem> orderItems;
    private String customerId;
    private String orderId;

    public GetOrderResponse(List<OrderItem> orderItems, String customerId, String orderId) {
        this.orderItems = orderItems;
        this.customerId = customerId;
        this.orderId = orderId;
    }

    public GetOrderResponse(){

    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
