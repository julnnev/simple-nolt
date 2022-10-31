package com.pragmatest.nolt.customer_orders.data.entities;

import javax.persistence.*;
import java.util.List;

//entities are models in the data layer

//creating a 'code representation' of our database

@Entity
public class OrderEntity {

    @ElementCollection // spring annotation
    @CollectionTable(name="ORDER_ITEMS", joinColumns=@JoinColumn(name="ORDER_ID")) //joining tables by order id fields
    private List<OrderItemEntity> orderItems;
    private String customerId;
    // 1 to many relationship, 1 order has many order items

    @Id
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<OrderItemEntity> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItemEntity> orderItems) {
        this.orderItems = orderItems;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

}
