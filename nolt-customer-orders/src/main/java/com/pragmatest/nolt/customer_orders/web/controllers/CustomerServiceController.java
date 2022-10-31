package com.pragmatest.nolt.customer_orders.web.controllers;

import com.pragmatest.nolt.customer_orders.services.CustomerOrdersService;
import com.pragmatest.nolt.customer_orders.services.models.Order;
import com.pragmatest.nolt.customer_orders.web.controllers.requests.SubmitOrderRequest;
import com.pragmatest.nolt.customer_orders.web.controllers.responses.GetOrderResponse;
import com.pragmatest.nolt.customer_orders.web.controllers.responses.SubmitOrderResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerServiceController {

    @Autowired
    CustomerOrdersService customerOrdersService; // auto wiring this instance into the specified class

    @Autowired
    ModelMapper mapper;

    // Consumer using api wanting to submit an order
    // @PostMapping exposing a pose and when we call /orders, it maps into this method.
    @PostMapping(value = "orders", produces = MediaType.APPLICATION_JSON_VALUE)
    // The request consists of a body and returns a response
    // Headers meta-data helping understand info related to resource (order). 'X-' means it is a custom header (for the application) mapped into a customerID String. Makes request more clearer and can be worked on without having to 'unpack' request
    // We create a SubmitOrderRequest model mapped into request variable.
    // The end point returns a response, ResponseEntity a spring object of type SubmitOrderResponse
    public ResponseEntity<SubmitOrderResponse> submit(@RequestHeader(name = "X-Customer-Id") String customerId, @RequestBody SubmitOrderRequest request) {

        // When state dependent in compile time - inject, when state dependent on run time you can use new.
        //.map(request,destination)
        Order orderSubmission = mapper.map(request, Order.class); // Dependency Injection rather than ... new - safer
        orderSubmission.setCustomerId(customerId); // this can also be done using a mapping with a tuple of string and submit order request to an order

        // we add a new service layer in the service package to avoid having all the business logic here
        // customerOrdersService class
        String orderId = customerOrdersService.submitOrder(orderSubmission);

        return ResponseEntity.ok(new SubmitOrderResponse(orderId)); //returning a http 200 reponse - everything is ok
        // response can also have a body
    }

    @GetMapping(value = "orders/{orderId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GetOrderResponse> get(@RequestHeader(name = "X-Customer-Id") String customerId, @PathVariable String orderId) {

        Order order = customerOrdersService.getOrder(orderId, customerId);

        if (order == null) {
            return ResponseEntity.notFound().build();
        }

        GetOrderResponse getOrderResponse = mapper.map(order, GetOrderResponse.class);
        return ResponseEntity.ok(getOrderResponse);
    }
}
