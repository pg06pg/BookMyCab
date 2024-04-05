package com.myapp.bookmycab.service;

import com.myapp.bookmycab.dao.CustomerDAO;
import com.myapp.bookmycab.dao.DriverDAO;
import com.myapp.bookmycab.dto.DriverDTO;
import com.myapp.bookmycab.dto.VehicleDTO;
import com.myapp.bookmycab.entity.Driver;
import com.myapp.bookmycab.exception.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class RideServiceImpl implements RideService {

    @Autowired
    private CustomerDAO customerDAO;

    @Autowired
    private DriverDAO driverDAO;


    @Override
    public List<DriverDTO> findRide(String customerName, long customerMobileNumber, long sourceXCoordinate, long sourceYCoordinate, long destXCoordinate, long destYCoordinate) {

        if (Objects.isNull(customerDAO.findByCustomerMobileNumber(customerMobileNumber))) {
            throw new BadRequestException("User not registered. Please add user before starting a ride!");
        }

        List<Driver> driversList = driverDAO.findAll();

        List<DriverDTO> nearbyDriversList = new ArrayList<>();


        for (Driver driver : driversList) {
            long driverDistance = calculateDistance(sourceXCoordinate, sourceYCoordinate,driver.getXCoordinate(), driver.getYCoordinate());

            if (driver.isAvailable() && driverDistance <= 5) {
                DriverDTO driverDTO = new DriverDTO();
                driverDTO.setDriverName(driver.getDriverName());
                driverDTO.setAvailable(driver.isAvailable());
                VehicleDTO vehicleDTO = new VehicleDTO();
                vehicleDTO.setModel(driver.getVehicleDetails().getModel());
                vehicleDTO.setNoOfSeats(driver.getVehicleDetails().getNoOfSeats());
                driverDTO.setVehicleDetails(vehicleDTO);
                driverDTO.setDriverPhoneNumber(driver.getDriverPhoneNumber());
                nearbyDriversList.add(driverDTO);
            }
        }

        return nearbyDriversList;
    }

    @Override
    public DriverDTO chooseRide(String customerName, String driverName, long driverPhoneNumber) {
        Driver driverToChosen = driverDAO.findByDriverNameAndDriverPhoneNumber(driverName,driverPhoneNumber);
        if(Objects.isNull(driverToChosen)){
            throw new BadRequestException("Driver with name : "+driverName+" and phone number : "+ driverPhoneNumber+" do not exists!");
        }

        driverToChosen.setAvailable(Boolean.FALSE);
        driverDAO.save(driverToChosen);

        DriverDTO driverDTO = new DriverDTO();
        driverDTO.setDriverName(driverName);
        driverDTO.setDriverPhoneNumber(driverPhoneNumber);
        VehicleDTO vehicleDTO = new VehicleDTO();
        vehicleDTO.setModel(driverToChosen.getVehicleDetails().getModel());
        vehicleDTO.setNoOfSeats(driverToChosen.getVehicleDetails().getNoOfSeats());
        vehicleDTO.setLicenseNumber(driverToChosen.getVehicleDetails().getLicenceNo());
        driverDTO.setVehicleDetails(vehicleDTO);
        return driverDTO;
    }

    public long calculateDistance(long sourceXCoordinate, long sourceYCoordinate,
                                  long destXCoordinate, long destYCoordinate)
    {
        long xDistance = (long) Math.pow(sourceXCoordinate - destXCoordinate, 2);
        long yDistance = (long) Math.pow(sourceYCoordinate - destYCoordinate, 2);

        return (long) Math.sqrt(xDistance + yDistance);
    }
}
