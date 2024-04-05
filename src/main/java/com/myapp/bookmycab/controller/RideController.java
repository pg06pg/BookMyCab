package com.myapp.bookmycab.controller;

import com.myapp.bookmycab.dto.DriverDTO;
import com.myapp.bookmycab.service.RideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "rides")
public class RideController {

    @Autowired
    private RideService rideService;

    @GetMapping(path = "find-ride")
    public List<DriverDTO> findRide(@RequestParam String customerName,@RequestParam long customerMobileNumber ,@RequestParam long sourceXCoordinate, @RequestParam long sourceYCoordinate, @RequestParam long destXCoordinate, @RequestParam long destYCoordinate) {

        return rideService.findRide(customerName,customerMobileNumber,sourceXCoordinate,sourceYCoordinate,destXCoordinate,destYCoordinate);
    }

    @GetMapping(path = "choose-ride")
    public DriverDTO chooseRide(@RequestParam String customerName,@RequestParam String driverName, @RequestParam long driverPhoneNumber){

        return rideService.chooseRide(customerName,driverName,driverPhoneNumber);

    }

}
