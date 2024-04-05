package com.myapp.bookmycab.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @EqualsAndHashCode.Include
    private Integer id;

    @Size(max=10)
    private String licenceNo;

    private Integer noOfSeats;

    private String model;
}
