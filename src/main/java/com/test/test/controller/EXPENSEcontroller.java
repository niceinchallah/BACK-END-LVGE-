package com.test.test.controller;

import com.test.test.DTO.EXPENSEDTO;
import com.test.test.service.EXPENSEservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/EXPENSE")
public class EXPENSEcontroller {
    @Autowired
private EXPENSEservice expensEservice;
//build add request rest api
    @PostMapping
    public ResponseEntity<EXPENSEDTO> createEXPENSE(@RequestBody EXPENSEDTO expensedto){
        EXPENSEDTO savedEXPENSE = expensEservice.createEXPENSE(expensedto);
        return new ResponseEntity<>(savedEXPENSE, HttpStatus.CREATED);
    }
    //build get **rest api
    @GetMapping("id")
    public ResponseEntity<EXPENSEDTO>getEXPENSEbyid(@RequestParam("id") Long EXPENSEid){
        EXPENSEDTO expensedto = expensEservice.getEXPENSEbyid(EXPENSEid);
    return ResponseEntity.ok(expensedto);
    }
    //Build get alll rest api
    @GetMapping
    public  ResponseEntity<List<EXPENSEDTO>> getAllEXPENSES(){
        List<EXPENSEDTO> expenses = expensEservice.getAllEXPENSE();
        return ResponseEntity.ok(expenses);
    }
    //BUILD UPDATE REST API
    @PutMapping("{id}")
    public ResponseEntity<EXPENSEDTO> updateEXPENSE(@PathVariable("id") Long EXPENSEid,
                                                    @RequestBody EXPENSEDTO updatedEXPENSE){
        EXPENSEDTO expensedto = expensEservice.updatedEXPENSE(EXPENSEid, updatedEXPENSE);
        return ResponseEntity.ok(expensedto);
    }
    //BUILD DELETE REST API
    public ResponseEntity<String>deleteEXPENSE(Long EXPENSEid){
        expensEservice.deleteEXPENSE(EXPENSEid);
        return ResponseEntity.ok("deleted succefuluy!");
    }
    }
