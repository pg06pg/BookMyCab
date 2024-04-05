package com.myapp.bookmycab.dao;

import com.myapp.bookmycab.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverDAO extends JpaRepository<Driver,Integer> {
    Driver findByDriverPhoneNumber(long driverPhoneNumber);

    Driver findByDriverNameAndDriverPhoneNumber(String driverName, long driverPhoneNumber);

}
