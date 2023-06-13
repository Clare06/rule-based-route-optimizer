package com.example.rulebasedrouteoptimization.service;

import com.example.rulebasedrouteoptimization.model.DriverDelivery;
import com.example.rulebasedrouteoptimization.repository.DriverDeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DriverDeliveryService {
    private final DriverDeliveryRepository driverDeliveryRepository;

    @Autowired
    public DriverDeliveryService(DriverDeliveryRepository driverDeliveryRepository){
        this.driverDeliveryRepository=driverDeliveryRepository;
    }


    public List<Optional<DriverDelivery>> listDeliver(Integer id) {
        return driverDeliveryRepository.listbyDID(id);
    }
}
