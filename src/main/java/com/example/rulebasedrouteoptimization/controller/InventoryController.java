package com.example.rulebasedrouteoptimization.controller;


import com.example.rulebasedrouteoptimization.model.Inventory;
import com.example.rulebasedrouteoptimization.service.InventoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/inventory")
@CrossOrigin(allowedHeaders = "*" ,origins = "*")
public class InventoryController {
    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService){
        this.inventoryService=inventoryService;
    }
    @GetMapping
    public ResponseEntity<List<Inventory>> getAllOrders(){
        List<Inventory> inventories= inventoryService.listAllInventories();

        return  new ResponseEntity<>(inventories, HttpStatus.OK);
    }
}
