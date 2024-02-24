package com.test.test.controller;

import com.test.test.DTO.DETECTEDDTO;
import com.test.test.service.DETECTEDservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/DETECTED")
public class DETECTEDcontroller {
    @Autowired
    private DETECTEDservice detecteDservice;
    //build add request rest api
    @PostMapping
    public ResponseEntity<DETECTEDDTO>createDETECTED(@RequestBody DETECTEDDTO detecteddto){
        DETECTEDDTO savedDETECTED = detecteDservice.createDETECTED(detecteddto);
    return new ResponseEntity<>(savedDETECTED, HttpStatus.CREATED);
    }

    @GetMapping("id")
    public ResponseEntity<DETECTEDDTO>getDETECTEDbyid(@RequestParam("id") Long DETECTEDid){
        DETECTEDDTO detecteddto = detecteDservice.getDETECTEDbyid(DETECTEDid);
        return ResponseEntity.ok(detecteddto);
    }
    //Build get alll rest api
    @GetMapping
    public ResponseEntity<List<DETECTEDDTO>> getAllDETECTED(){
        List<DETECTEDDTO> detecteds = detecteDservice.getAllDETECTED();
        return ResponseEntity.ok(detecteds);
    }
    //BUILD UPDATE REST API
    @PutMapping("{id}")
    public  ResponseEntity<DETECTEDDTO>updateDETECTED(@PathVariable("id") Long DETECTEDid,
                                                      @RequestBody DETECTEDDTO updateDETECTED){
        DETECTEDDTO detecteddto = detecteDservice.updateDETECTED(DETECTEDid, updateDETECTED);
        return ResponseEntity.ok(detecteddto);
    }
    //Build delete rest api
    @DeleteMapping("{id}")
    public  ResponseEntity<String> deleteDETECTED(Long DETECTEDid){
        detecteDservice.deleteDETECTED(DETECTEDid);

        return ResponseEntity.ok("deleted succefuly!");
    }
}
