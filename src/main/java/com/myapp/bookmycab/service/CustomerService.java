package com.myapp.bookmycab.service;

import com.myapp.bookmycab.controller.request.CreateCustomerRequest;
import com.myapp.bookmycab.controller.response.CreateCustomerResponse;

public interface CustomerService {

    public CreateCustomerResponse createCustomer(CreateCustomerRequest createCustomerRequest);
}
