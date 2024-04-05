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
public class Customer {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @EqualsAndHashCode.Include
    private Integer customerId;

    @Size(min = 3, max = 255, message = "name length should be between 3 to 255")
    @NotNull(message = "this property cannot be null")
    private String customerName;

    private String gender;

    private Integer age;

    private long customerMobileNumber;

    private long xCoordinate;

    private long yCoordinate;

}
