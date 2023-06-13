package com.example.rulebasedrouteoptimization.service;



import com.example.rulebasedrouteoptimization.model.Vehicle;
import com.example.rulebasedrouteoptimization.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {
    private final VehicleRepository vehicleRepository;

    @Autowired
    public VehicleService(VehicleRepository vehicleRepository){this.vehicleRepository=vehicleRepository;}

    public List<Optional<Vehicle>> listbyCapacity(Integer mV , Integer mW){
        List <Optional<Vehicle>> listVehicle= vehicleRepository.findVehicleByCapacity(mV,mW);
        return listVehicle;
    }

    public List<Vehicle> allVehicle() {
        return vehicleRepository.findAll();
    }

    public Optional<Vehicle> vehicleById(String vid){
        return  vehicleRepository.findById(vid);
    }
}
