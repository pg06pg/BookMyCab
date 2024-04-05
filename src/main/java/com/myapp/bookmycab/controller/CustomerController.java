package com.myapp.bookmycab.controller;

import com.myapp.bookmycab.controller.request.CreateCustomerRequest;
import com.myapp.bookmycab.controller.response.CreateCustomerResponse;
import com.myapp.bookmycab.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "users")
public class CustomerController {

    @Autowired
    private CustomerServiceImpl customerServiceImpl;

    @PostMapping(path = "add-user")
    public ResponseEntity<CreateCustomerResponse> createCustomer(@RequestBody CreateCustomerRequest createCustomerRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(customerServiceImpl.createCustomer(createCustomerRequest));
    }
}
