package com.test.test.service.impl;

import com.test.test.DTO.VehiclesDTO;
import com.test.test.EXCEPTION.ResourceNOTfoundexception;
import com.test.test.entity.Vehiclesent;
import com.test.test.mapper.Vehiclesmapper;
import com.test.test.repository.Vehiclesrep;
import com.test.test.service.Vehicleservice;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor

public class Vehiclesserviceimpl  implements Vehicleservice {

    private Vehiclesrep vehiclesrep;

    @Override
    public VehiclesDTO createVehicle(VehiclesDTO vehiclesDTO) {

        Vehiclesent vehiclesent= Vehiclesmapper.mapToVehiclesent(vehiclesDTO);
       Vehiclesent savedVehicle= vehiclesrep.save(vehiclesent);
        return Vehiclesmapper.mapToVehiclesDTO(savedVehicle);
    }

    @Override
    public VehiclesDTO getVehiclebyID(Long Vehicleid) {
        Vehiclesent vehiclesent = vehiclesrep.findById(Vehicleid)
                .orElseThrow(()->
                        new ResourceNOTfoundexception("not exist with gven id "+ Vehicleid));
        return Vehiclesmapper.mapToVehiclesDTO(vehiclesent);
    }

    @Override
    public List<VehiclesDTO> getAllVehicles() {
        return null;
    }

    @Override
    public VehiclesDTO updateVehicles(Long Vehicleid, VehiclesDTO updatedVehicles) {
        Vehiclesent vehiclesent = vehiclesrep.findById(Vehicleid).orElseThrow(()
        -> new ResourceNOTfoundexception("not exist with given id :" + Vehicleid)
        );
        vehiclesent.setBrand(updatedVehicles.getBrand());
        vehiclesent.setModel(updatedVehicles.getModel());
        vehiclesent.setId(updatedVehicles.getId());
        vehiclesent.setPhoto(updatedVehicles.getPhoto());
        vehiclesent.setDate(updatedVehicles.getDate());
         Vehiclesent updatedVehicleobj = vehiclesrep.save(vehiclesent);
        return Vehiclesmapper.mapToVehiclesDTO(updatedVehicleobj);
    }

    @Override
    public void deleteVehicle(Long Vehicleid) {
        Vehiclesent vehiclesent = vehiclesrep.findById(Vehicleid).orElseThrow(()
                -> new ResourceNOTfoundexception("not exist with given id :" + Vehicleid)
        );
        vehiclesrep.deleteById(Vehicleid);
    }
}
