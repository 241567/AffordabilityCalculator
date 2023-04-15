package com.example.calculator.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.calculator.entity.HouseAffordability;
import com.example.calculator.service.HouseAffordabilityService;

@RestController
@RequestMapping("/api/houseAffordability")
public class HouseAffordabilityController {

    @Autowired
    private HouseAffordabilityService houseAffordabilityService;

    @PostMapping("/calculateAffordableHousePrice")
    public ResponseEntity<Double> calculateAffordableHousePrice(@RequestBody HouseAffordability houseAffordability) {
        double affordableHousePrice = houseAffordabilityService.calculateAffordableHousePrice(houseAffordability);
        return new ResponseEntity<>(affordableHousePrice, HttpStatus.OK);
    }

    @PostMapping("/saveHouseAffordability")
    public ResponseEntity<HouseAffordability> saveHouseAffordability(@RequestBody HouseAffordability houseAffordability) {
        HouseAffordability savedHouseAffordability = houseAffordabilityService.saveHouseAffordability(houseAffordability);
        return new ResponseEntity<>(savedHouseAffordability, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<HouseAffordability> getHouseAffordabilityById(@PathVariable Long id) {
        HouseAffordability houseAffordability = houseAffordabilityService.getHouseAffordabilityById(id);
        return ResponseEntity.ok(houseAffordability);
    }
}

