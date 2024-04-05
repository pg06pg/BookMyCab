package com.myapp.bookmycab.dao;

import com.myapp.bookmycab.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleDAO extends JpaRepository<Vehicle, Integer> {

}
