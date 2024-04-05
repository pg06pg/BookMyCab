package com.myapp.bookmycab.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.myapp.bookmycab.entity.Vehicle;
import lombok.Data;

@Data
public class CreateDriverRequest {

    private String driverName;

    private long driverPhoneNumber;

    private String gender;

    private Integer age;

    private Vehicle vehicleDetails;

    @JsonProperty("xCoordinate")
    private long xCoordinate;

    @JsonProperty("yCoordinate")
    private long yCoordinate;

}
