package com.test.test.entity;

import jakarta.persistence.*;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="vehicle")



public class Vehiclesent {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;
        @Column(name = "brand")
        private String brand;
        @Column(name="model")
        private String model;

        @Lob
        @Column(name="photo")
        private byte[] photo;
        @Column(name = "date")
        private LocalDate date;


}
