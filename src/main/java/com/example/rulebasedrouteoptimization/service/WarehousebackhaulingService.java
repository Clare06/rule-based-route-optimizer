package com.example.rulebasedrouteoptimization.service;

import com.example.rulebasedrouteoptimization.repository.WarehousebackhaulingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WarehousebackhaulingService {
    private WarehousebackhaulingRepository warehousebackhaulingRepository;

    @Autowired
    public WarehousebackhaulingService(WarehousebackhaulingRepository warehousebackhaulingRepository){this.warehousebackhaulingRepository=warehousebackhaulingRepository;}
}
