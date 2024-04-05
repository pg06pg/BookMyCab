package com.myapp.bookmycab.controller.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateCustomerResponse {

    private String customerName;

    private long customerMobileNumber;

    private String gender;

    private Integer age;
}
