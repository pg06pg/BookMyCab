package com.myapp.bookmycab.service;


import com.myapp.bookmycab.controller.request.CreateDriverRequest;
import com.myapp.bookmycab.controller.response.CreateCustomerResponse;
import com.myapp.bookmycab.controller.response.CreateDriverResponse;

public interface DriverService {
    CreateDriverResponse createDriver(CreateDriverRequest createDriverRequest);
}
