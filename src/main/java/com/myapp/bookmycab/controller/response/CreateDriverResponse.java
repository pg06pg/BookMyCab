package com.myapp.bookmycab.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.myapp.bookmycab.entity.Vehicle;
import lombok.Data;

@Data
public class CreateDriverResponse {


    private String driverName;

    private long driverPhoneNumber;

    private String gender;

    private Integer age;

    private VehicleResponse vehicleDetails;

    private boolean available;

    @JsonProperty("xCoordinate")
    private long xCoordinate;

    @JsonProperty("yCoordinate")
    private long yCoordinate;
}
