package com.test.test.service;

import com.test.test.DTO.VehiclesDTO;

import java.util.List;

public interface Vehicleservice {
    VehiclesDTO createVehicle(VehiclesDTO vehiclesDTO);
    VehiclesDTO getVehiclebyID(Long Vehicleid );
    List<VehiclesDTO> getAllVehicles();
    VehiclesDTO updateVehicles(Long Vehicleid,VehiclesDTO updatedVehicles);
    void deleteVehicle(Long Vehicleid);
}
