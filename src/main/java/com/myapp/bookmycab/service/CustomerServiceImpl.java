package com.myapp.bookmycab.service;

import com.myapp.bookmycab.controller.request.CreateCustomerRequest;
import com.myapp.bookmycab.controller.response.CreateCustomerResponse;
import com.myapp.bookmycab.dao.CustomerDAO;
import com.myapp.bookmycab.entity.Customer;
import com.myapp.bookmycab.exception.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerDAO customerDAO;

    @Override
    public CreateCustomerResponse createCustomer(CreateCustomerRequest createCustomerRequest) {
        Customer customer = customerDAO.findByCustomerMobileNumber(createCustomerRequest.getCustomerMobileNumber());
        if(Objects.nonNull(customer)){
            throw new BadRequestException("Customer with same mobile number already exists!");
        }

        Customer customerToBeSaved = new Customer();
        customerToBeSaved.setCustomerName(createCustomerRequest.getCustomerName());
        customerToBeSaved.setCustomerMobileNumber(createCustomerRequest.getCustomerMobileNumber());
        customerToBeSaved.setAge(createCustomerRequest.getAge());
        customerToBeSaved.setGender(createCustomerRequest.getGender());
        customerDAO.save(customerToBeSaved);

        return  new CreateCustomerResponse(createCustomerRequest.getCustomerName(), createCustomerRequest.getCustomerMobileNumber(),createCustomerRequest.getGender(),createCustomerRequest.getAge());
    }
}
