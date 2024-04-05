package com.myapp.bookmycab.service;

import com.myapp.bookmycab.controller.request.CreateDriverRequest;
import com.myapp.bookmycab.controller.response.CreateCustomerResponse;
import com.myapp.bookmycab.controller.response.CreateDriverResponse;
import com.myapp.bookmycab.controller.response.VehicleResponse;
import com.myapp.bookmycab.dao.DriverDAO;
import com.myapp.bookmycab.dao.VehicleDAO;
import com.myapp.bookmycab.entity.Driver;
import com.myapp.bookmycab.entity.Vehicle;
import com.myapp.bookmycab.exception.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class DriverServiceImpl implements  DriverService{

    @Autowired
    private DriverDAO driverDAO;

    @Autowired
    private VehicleDAO vehicleDAO;

    @Override
    public CreateDriverResponse createDriver(CreateDriverRequest createDriverRequest) {

        Driver driver = driverDAO.findByDriverPhoneNumber(createDriverRequest.getDriverPhoneNumber());
        if(Objects.nonNull(driver)){
            throw new BadRequestException("Driver with same phone number already exists!");
        }

        Driver driverToBeSaved = new Driver();
        driverToBeSaved.setDriverName(createDriverRequest.getDriverName());
        driverToBeSaved.setDriverPhoneNumber(createDriverRequest.getDriverPhoneNumber());
        driverToBeSaved.setAge(createDriverRequest.getAge());
        driverToBeSaved.setGender(createDriverRequest.getGender());
        driverToBeSaved.setXCoordinate(createDriverRequest.getXCoordinate());
        driverToBeSaved.setYCoordinate(createDriverRequest.getYCoordinate());

        Vehicle vehicle = new Vehicle();
        vehicle.setLicenceNo(createDriverRequest.getVehicleDetails().getLicenceNo());
        vehicle.setNoOfSeats(createDriverRequest.getVehicleDetails().getNoOfSeats());
        vehicleDAO.save(vehicle);

        driverToBeSaved.setVehicleDetails(vehicle);
        driverToBeSaved.setAvailable(Boolean.TRUE);
        driverDAO.save(driverToBeSaved);

        CreateDriverResponse createDriverResponse = new CreateDriverResponse();
        VehicleResponse vehicleResponse = new VehicleResponse();
        vehicleResponse.setLicenceNo(vehicle.getLicenceNo());
        vehicleResponse.setNoOfSeats(vehicle.getNoOfSeats());
        createDriverResponse.setDriverName(createDriverRequest.getDriverName());
        createDriverResponse.setDriverPhoneNumber(createDriverRequest.getDriverPhoneNumber());
        createDriverResponse.setVehicleDetails(vehicleResponse);
        createDriverResponse.setAvailable(Boolean.TRUE);
        createDriverResponse.setGender(createDriverRequest.getGender());
        createDriverResponse.setAge(createDriverRequest.getAge());
        createDriverResponse.setXCoordinate(createDriverRequest.getXCoordinate());
        createDriverResponse.setYCoordinate(createDriverRequest.getYCoordinate());
        return createDriverResponse;
    }
}
