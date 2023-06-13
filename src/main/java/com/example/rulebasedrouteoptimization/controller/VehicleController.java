package com.example.rulebasedrouteoptimization.controller;

import com.example.rulebasedrouteoptimization.exception.ResourceNotFoundException;
import com.example.rulebasedrouteoptimization.model.Capacity;
import com.example.rulebasedrouteoptimization.model.Vehicle;
import com.example.rulebasedrouteoptimization.repository.VehicleRepository;
import com.example.rulebasedrouteoptimization.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("vehicle")
@CrossOrigin(allowedHeaders = "*" ,origins = "*")
public class VehicleController {
    private final VehicleService vehicleService;
    @Autowired
    private VehicleRepository vehicleRepo;
    public VehicleController(VehicleService vehicleService){this.vehicleService=vehicleService;}

    @PostMapping("bycapacity")
    public ResponseEntity<?> vehicleByCapacity(@RequestBody Capacity capacity){
        List<Optional<Vehicle>> listVehicle = vehicleService.listbyCapacity(capacity.getMaxVol(),capacity.getMaxWeight());
        return new ResponseEntity<>(listVehicle, HttpStatus.OK);
    }
//    @GetMapping("")
//    public List<Vehicle> getAllNewVehicles(){
//        return vehicleRepo.findAll();
//    }

    // create new vehicle rest api

    @PostMapping("")
    public Vehicle createNewVehicle(@RequestBody Vehicle vehicle){
        return vehicleRepo.save(vehicle);
    }

    //get new vehicle by id rest api
    @GetMapping("/{id}")
    public ResponseEntity<Vehicle> getNewVehicleById(@PathVariable String id){
        Vehicle vehicle=vehicleRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("New vehicle not exist with id:" +id));
        return ResponseEntity.ok(vehicle);

    }

    // update new vehicle rest api
    @PutMapping("/{id}")
    public ResponseEntity<Vehicle> updateNewVehicle(@PathVariable String id, @RequestBody Vehicle vehicleDetails){
        Vehicle newVehicle=vehicleRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("New vehicle not exit with id:"+id));

//        newVehicle.setVehicleNo(vehicleDetails.getVehicleNo());
        newVehicle.setMaxVol(vehicleDetails.getMaxVol());
        newVehicle.setMaxWeight(vehicleDetails.getMaxWeight());
        newVehicle.setModel(vehicleDetails.getModel());

        Vehicle updatedNewVehicle=vehicleRepo.save(newVehicle);
        return ResponseEntity.ok(updatedNewVehicle);
    }

    // delete new vehicle rest api

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteNewVehicle(@PathVariable String id){
        Vehicle newVehicle=vehicleRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("New vehicle not exist with id:"+id));

        vehicleRepo.delete(newVehicle);
        Map<String, Boolean> response=new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }


    @GetMapping
    public ResponseEntity<List<Vehicle>> getVehicles(){
        List<Vehicle> vehicles=this.vehicleService.allVehicle();
        return new ResponseEntity<>(vehicles, HttpStatus.OK);
    }

    @GetMapping("count")
    public Integer getcount(){
        Integer order_count = vehicleRepo.vehiclecount();
        return order_count;
    }
}
