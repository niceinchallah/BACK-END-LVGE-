package com.test.test.controller;
import com.test.test.DTO.ClientDTO;
import com.test.test.entity.Client;
import com.test.test.repository.Clientrep;

import com.test.test.service.Clientservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/Clients")

public class Clientcontroller {
    @Autowired
    private Clientservice clientservice;

    @Autowired
    private Clientrep clientrep;

    @PostMapping("/withoutPhoto")
    public ResponseEntity<?> createClientWithoutPhoto(@RequestParam("name") String name,
                                                      @RequestParam("brand") String brand,
                                                      @RequestParam("model") String model) {
        Client client = new Client();
        client.setName(name);
        client.setBrand(brand);
        client.setModel(model);
        client = clientrep.save(client);

        return ResponseEntity.status(HttpStatus.CREATED).body("Client created successfully without photo");
    }

    // Endpoint to create a client with a photo
    @PostMapping("/withPhoto")
    public ResponseEntity<?> createClientWithPhoto(@RequestParam("name") String name,
                                                   @RequestParam("brand") String brand,
                                                   @RequestParam("model") String model,
                                                   @RequestParam(value = "photo", required = false) MultipartFile photo) {
        try {
            byte[] photoBytes = null; // Initialize to null by default

            // Check if photo is provided and not empty
            if (photo != null && !photo.isEmpty()) {
                photoBytes = photo.getBytes();

                // **Temporary Base64 encoding (optional):**
                // If needed for processing on the server before saving, uncomment this line.
                // String base64Photo = Base64.getEncoder().encodeToString(photoBytes);

                // Store the original binary data in the database
                Client client = new Client();
                client.setName(name);
                client.setBrand(brand);
                client.setModel(model);
                client.setPhoto(photoBytes); // Set photoBytes even if it's null
                client = clientrep.save(client);

                return ResponseEntity.status(HttpStatus.CREATED).body("Client created successfully");
            } else {
                // Handle client creation without photo
                return createClientWithoutPhoto(name, brand, model);
            }

        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to process image");
        }
    }

    @PostMapping
    public ResponseEntity<?> createClient(@RequestParam("name") String name,
                                          @RequestParam("brand") String brand,
                                          @RequestParam("model") String model,
                                          @RequestParam(value = "photo", required = false) MultipartFile photo) {
        // Check if photo parameter is present
        if (photo != null) {
            // Handle client creation with photo
            return createClientWithPhoto(name, brand, model, photo);
        } else {
            // Handle client creation without photo
            return createClientWithoutPhoto(name, brand, model);
        }
    }

    //build get **rest api
    @GetMapping("/{id}") // Correction de l'annotation et ajout de l'ID entre accolades
    public ResponseEntity<ClientDTO> getClientById(@PathVariable("id") Long clientId) { // Correction du nom de la méthode et de la variable
        ClientDTO clientDTO = clientservice.getClientbyid(clientId); // Correction du nom de la méthode
        return ResponseEntity.ok(clientDTO);
    }
    //Build get all rest api
    @GetMapping
    public ResponseEntity<List<ClientDTO>> getallClients() {
        List<ClientDTO> clients = clientservice.getAllCients();
        return ResponseEntity.ok(clients);

    }
    //Build update rest api
    @PutMapping("/{id}")

    public ResponseEntity<ClientDTO> updateClients(@PathVariable("id") Long Clientsid,
                                                   @RequestBody ClientDTO updatedClients) {
        ClientDTO clientDTO = clientservice.updateClients(Clientsid, updatedClients);
        return ResponseEntity.ok(clientDTO);
    }

    //BUILD DELETE REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteClient(@PathVariable Long id) {
        clientservice.deleteClients(id);
        return ResponseEntity.ok("deleted succesufelly.!");
    }
}
