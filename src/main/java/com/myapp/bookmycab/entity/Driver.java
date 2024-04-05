package com.myapp.bookmycab.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Driver {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @EqualsAndHashCode.Include
    private int id;

    @Size(min = 3, max = 255, message = "name can be between 3 to 255 characters")
    @NotNull(message = "Driver name cant be null")
    private String driverName;

    private long driverPhoneNumber;

    private String gender;

    private Integer age;

    @OneToOne
    private Vehicle vehicleDetails;

    private boolean available;

    private long xCoordinate;

    private long yCoordinate;

}
