package com.test.test.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VehiclesDTO {
    private long id;
    private String brand;
    private String model;
    private byte[] photo;
    private LocalDate date;

   // public VehiclesDTO(long id, String brand, String model, byte[] photo) {
     //   this.id = id;
       // this.brand = brand;
        //this.model = model;


    }

