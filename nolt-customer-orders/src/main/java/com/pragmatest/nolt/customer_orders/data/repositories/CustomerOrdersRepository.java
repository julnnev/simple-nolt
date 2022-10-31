package com.pragmatest.nolt.customer_orders.data.repositories;

import com.pragmatest.nolt.customer_orders.data.entities.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

// JPA repo gives us the option to save in memory
// Easy move between databases - just change pom file
public interface CustomerOrdersRepository extends JpaRepository<OrderEntity, String> {
}
