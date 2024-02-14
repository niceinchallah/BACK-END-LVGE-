package com.test.test.mapper;

import com.test.test.DTO.VehiclesDTO;
import com.test.test.entity.Vehiclesent;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
@Getter
@Setter
public class Vehiclesmapper {
    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public static VehiclesDTO mapToVehiclesDTO(Vehiclesent vehiclesent){
        return new VehiclesDTO(
                vehiclesent.getId(),
                vehiclesent.getBrand(),
                vehiclesent.getModel(),
                vehiclesent.getPhoto(),
                vehiclesent.getDate()
        );
    }
    public static Vehiclesent mapToVehiclesent(VehiclesDTO vehiclesDTO){
        return new Vehiclesent(
                vehiclesDTO.getId(),
                vehiclesDTO.getBrand(),
                vehiclesDTO.getModel(),
                vehiclesDTO.getPhoto(),
                vehiclesDTO.getDate()
        );
    }
    private static String formatLocalDateToString(LocalDate date) {
        return date != null ? date.format(dateFormatter) : null;
    }

    private static LocalDate parseStringToLocalDate(String dateString) {
        return dateString != null ? LocalDate.parse(dateString, dateFormatter) : null;
    }
}
