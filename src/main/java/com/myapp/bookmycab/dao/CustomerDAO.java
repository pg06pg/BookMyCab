package com.myapp.bookmycab.dao;

import com.myapp.bookmycab.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDAO extends JpaRepository<Customer, Integer> {
    Customer findByCustomerMobileNumber(long customerMobileNumber);
}
