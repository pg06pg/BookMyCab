package com.myapp.bookmycab.service;

import com.myapp.bookmycab.dto.DriverDTO;

import java.util.List;

public interface RideService {

    List<DriverDTO> findRide(String customerName, long customerMobileNumber, long sourceXCoordinate, long sourceYCoordinate, long destXCoordinate, long destYCoordinate);

    DriverDTO chooseRide(String customerName, String driverName, long driverPhoneNumber);
}
