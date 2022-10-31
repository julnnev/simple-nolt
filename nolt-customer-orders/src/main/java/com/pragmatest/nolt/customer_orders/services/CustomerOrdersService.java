package com.pragmatest.nolt.customer_orders.services;

import com.pragmatest.nolt.customer_orders.data.entities.OrderEntity;
import com.pragmatest.nolt.customer_orders.data.repositories.CustomerOrdersRepository;
import com.pragmatest.nolt.customer_orders.services.models.Order;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class CustomerOrdersService {

    @Autowired
    CustomerOrdersRepository repository;

    @Autowired
    ModelMapper mapper;

    // service layer also has its own model - separation of different models across layers
    //return order id and save this to a database
    public String submitOrder(Order order) {
        OrderEntity orderEntity = mapper.map(order, OrderEntity.class);
        orderEntity.setId(UUID.randomUUID().toString()); //after validation of balance, order acceptance, and more business logic...
        orderEntity = repository.save(orderEntity); //saving an object of OrderEntity type to the repository
        return orderEntity.getId();
    }

    public Order getOrder(String orderId, String customerId) {
        OrderEntity orderEntityToFind = new OrderEntity();
        orderEntityToFind.setCustomerId(customerId);
        orderEntityToFind.setId(orderId);

        Optional<OrderEntity> retrievedOrderEntity =
                repository.findOne(Example.of(orderEntityToFind, ExampleMatcher.matchingAll()));

        if (retrievedOrderEntity.isEmpty()) return null;

        Order order = mapper.map(retrievedOrderEntity.get(), Order.class);

        return order;
    }
}
