package com.myapp.bookmycab.dto;

import com.myapp.bookmycab.entity.Vehicle;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class DriverDTO {


    private String driverName;

    private long driverPhoneNumber;

    private VehicleDTO vehicleDetails;

    private boolean available;


}
