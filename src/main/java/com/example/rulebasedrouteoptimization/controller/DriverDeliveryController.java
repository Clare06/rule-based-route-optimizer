package com.example.rulebasedrouteoptimization.controller;

import com.example.rulebasedrouteoptimization.model.DriverDelivery;
import com.example.rulebasedrouteoptimization.service.DriverDeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("driverdeliver")
@CrossOrigin(origins = "*")
public class DriverDeliveryController {
    private DriverDeliveryService driverDeliveryService;

    @Autowired
    public DriverDeliveryController (DriverDeliveryService driverDeliveryService){
        this.driverDeliveryService=driverDeliveryService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Optional<DriverDelivery>>> listorder(@PathVariable("id") Integer id){
        List<Optional<DriverDelivery>> listDeli = driverDeliveryService.listDeliver(id);
        return new ResponseEntity<>(listDeli, HttpStatus.OK);
    }
}
