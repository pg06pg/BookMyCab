package com.myapp.bookmycab.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Ride {

    @Id
    private Integer id;

    private String customerName;

    private String driverName;

    private String fromLocation;

    private String toLocation;
}
