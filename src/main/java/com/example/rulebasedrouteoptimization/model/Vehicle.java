package com.example.rulebasedrouteoptimization.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "vehicle")
public class Vehicle implements Serializable {

    @Id
    @Column(name = "vehicleno")
    private String vehicleNo;

    @Column(name = "maxvol")
    private Integer maxVol;

    @Column(name = "maxweight")
    private Integer maxWeight;

    @Column(name = "model")
    private  String model;

    @Column(name = "status")
    private String status;

    public Vehicle(String vehicleNo, Integer maxVol, Integer maxWeight,String model,String status) {
        this.vehicleNo = vehicleNo;
        this.maxVol = maxVol;
        this.maxWeight = maxWeight;
        this.model=model;
        this.status=status;
    }

    public Vehicle() {
        this.maxVol = maxVol;
        this.maxWeight = maxWeight;
    }

    public Integer getMaxVol() {
        return maxVol;
    }

    public void setMaxVol(Integer maxVol) {
        this.maxVol = maxVol;
    }

    public Integer getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(Integer maxWeight) {
        this.maxWeight = maxWeight;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
