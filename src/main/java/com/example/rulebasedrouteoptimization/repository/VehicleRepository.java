package com.example.rulebasedrouteoptimization.repository;


import com.example.rulebasedrouteoptimization.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface VehicleRepository extends JpaRepository<Vehicle,String> {
    @Query("SELECT v from Vehicle v where v.maxVol >= :mV AND v.maxWeight >= :mW AND v.status='free'")
   List <Optional<Vehicle>> findVehicleByCapacity (@Param("mV") Integer mv, @Param("mW") Integer mw);

    @Query("SELECT COUNT(v) FROM Vehicle v")
    Integer vehiclecount ();
}
