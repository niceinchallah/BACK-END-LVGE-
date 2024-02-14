package com.test.test.controller;

import com.test.test.DTO.INCOMEDTO;
import com.test.test.service.INCOMEservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/INCOME")
public class INCOMEcontroller {
    @Autowired
    private INCOMEservice incomEservice;
    //build add request api
    @PostMapping
    public ResponseEntity<INCOMEDTO> createINCOME(@RequestBody INCOMEDTO incomedto){
        INCOMEDTO savedINCOME = incomEservice.createINCOME(incomedto);
        return new ResponseEntity<>(savedINCOME, HttpStatus.CREATED);
    }
    //build get **rest api
    @GetMapping("id")
    public ResponseEntity<INCOMEDTO>getINCOMEbyid(@RequestParam("id") Long INCOMEid){
        INCOMEDTO incomedto = incomEservice.getINCOMEbyid(INCOMEid);
        return ResponseEntity.ok(incomedto);
    }
    //Build get alll rest api
    @GetMapping
    public  ResponseEntity<List<INCOMEDTO>> getAllINCOMES(){
        List<INCOMEDTO> incomes = incomEservice.getAllINCOMES();
        return  ResponseEntity.ok(incomes);
    }
    //bUILD UPDATE REST API
    @PutMapping("{id}")
    public ResponseEntity<INCOMEDTO> updateINCOME(@PathVariable("id") Long INCOMEid,
                                                  @RequestBody INCOMEDTO updatedINCOME){
        INCOMEDTO incomedto = incomEservice.updateINCOME(INCOMEid, updatedINCOME);
        return ResponseEntity.ok(incomedto);
    }
    //BUILD DELETE REST API
    public ResponseEntity<String>deleteINCOME(Long INCOMEid){
        incomEservice.deleteINCOME(INCOMEid);
        return ResponseEntity.ok("deleted succefuly!");
    }
}
