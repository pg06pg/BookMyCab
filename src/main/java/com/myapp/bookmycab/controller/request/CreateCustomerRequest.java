package com.myapp.bookmycab.controller.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateCustomerRequest {

    private String customerName;

    private long customerMobileNumber;

    private String gender;

    private Integer age;
}
