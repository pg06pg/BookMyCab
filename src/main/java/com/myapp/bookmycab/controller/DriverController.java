package com.myapp.bookmycab.controller;

import com.myapp.bookmycab.controller.request.CreateCustomerRequest;
import com.myapp.bookmycab.controller.request.CreateDriverRequest;
import com.myapp.bookmycab.controller.response.CreateCustomerResponse;
import com.myapp.bookmycab.controller.response.CreateDriverResponse;
import com.myapp.bookmycab.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "drivers")
public class DriverController {

    @Autowired
    private DriverService driverService;

    @PostMapping(path = "add-driver")
    public ResponseEntity<CreateDriverResponse> createCustomer(@RequestBody CreateDriverRequest createDriverRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(driverService.createDriver(createDriverRequest));
    }
}
