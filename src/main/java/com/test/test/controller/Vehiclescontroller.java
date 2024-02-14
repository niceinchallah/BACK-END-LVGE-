package com.test.test.controller;

import com.test.test.DTO.VehiclesDTO;
import com.test.test.service.Vehicleservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Vehicles")
public class Vehiclescontroller {
    @Autowired
    private Vehicleservice vehicleservice;
    //build add request rest API
    @PostMapping
    public ResponseEntity<VehiclesDTO> createVehicle(@RequestBody VehiclesDTO vehiclesDTO){
   VehiclesDTO savedVehicles   =  vehicleservice.createVehicle(vehiclesDTO);
   return new ResponseEntity<>(savedVehicles, HttpStatus.CREATED);
    }
    //build get **rest api
    @GetMapping("id")
    public ResponseEntity<VehiclesDTO>getVehiclebyID(@RequestParam("id") Long Vehicleid){
        VehiclesDTO vehiclesDTO = vehicleservice.getVehiclebyID(Vehicleid);
        return ResponseEntity.ok(vehiclesDTO);
    }
    //Build get alll rest api
    @GetMapping
    public ResponseEntity<List<VehiclesDTO>> getAllVehicles(){
        List<VehiclesDTO>vehicles = vehicleservice.getAllVehicles();
        return ResponseEntity.ok(vehicles);
    }
    //Build update restb api
    @PutMapping("{id}")
    public ResponseEntity<VehiclesDTO>updateVehicles(@PathVariable("id") Long Vehiclesid,
                                                     @RequestBody VehiclesDTO updatedVehicles){
        VehiclesDTO vehiclesDTO = vehicleservice.updateVehicles(Vehiclesid, updatedVehicles);
        return ResponseEntity.ok(vehiclesDTO);
    }
    //BUILD DELETE REST API
    public ResponseEntity<String>deleteVehicle(Long Vehicleid){
        vehicleservice.deleteVehicle(Vehicleid);
        return ResponseEntity.ok("deleted succefuly!");
    }
}
