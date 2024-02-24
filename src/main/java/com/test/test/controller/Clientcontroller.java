package com.test.test.controller;

import com.test.test.DTO.ClientDTO;
import com.test.test.service.Clientservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Clients")
public class Clientcontroller {
    @Autowired
    private Clientservice clientservice;

    ////build add request rest API
    @PostMapping
    public ResponseEntity<ClientDTO> createClient(@RequestBody ClientDTO clientDTO) {
        ClientDTO savedClients = clientservice.createClient(clientDTO);
        return new ResponseEntity<>(savedClients, HttpStatus.CREATED);
    }

    //build get **rest api
    @GetMapping("/{id}") // Correction de l'annotation et ajout de l'ID entre accolades
    public ResponseEntity<ClientDTO> getClientById(@PathVariable("id") Long clientId) { // Correction du nom de la méthode et de la variable
        ClientDTO clientDTO = clientservice.getClientbyid(clientId); // Correction du nom de la méthode
        return ResponseEntity.ok(clientDTO);
    }


    //Build get alll rest api
    @GetMapping
    public ResponseEntity<List<ClientDTO>> getallClients() {
        List<ClientDTO> clients = clientservice.getAllCients();
        return ResponseEntity.ok(clients);

    }

    //Build update rest api
    @PutMapping("{id}")

    public ResponseEntity<ClientDTO> updateClients(@PathVariable("id") Long Clientsid,
                                                   @RequestBody ClientDTO updatedClients) {
        ClientDTO clientDTO = clientservice.updateClients(Clientsid, updatedClients);
        return ResponseEntity.ok(clientDTO);
    }

    //BUILD DELETE REST API
    public ResponseEntity<String> deleteClient(Long Clientid) {
        clientservice.deleteClients(Clientid);
        return ResponseEntity.ok("deleted succesufelly.!");
    }
}
