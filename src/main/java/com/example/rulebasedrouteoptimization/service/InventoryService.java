package com.example.rulebasedrouteoptimization.service;

import com.example.rulebasedrouteoptimization.model.Inventory;
import com.example.rulebasedrouteoptimization.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {
    private InventoryRepository inventoryRepository;
    @Autowired
    public InventoryService (InventoryRepository inventoryRepository){this.inventoryRepository=inventoryRepository;}

    public List<Inventory> listAllInventories() {
        return inventoryRepository.findAll();
    }
}
