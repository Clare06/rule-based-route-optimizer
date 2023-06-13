package com.example.rulebasedrouteoptimization.orderrequest;

import java.time.LocalDateTime;

public class OrderRequest {
    private  Integer volume;
    private  Integer weight;
    private LocalDateTime dateTime;
    private String deliveryAddress;
    private Integer uid;

    public OrderRequest(Integer volume, Integer weight, LocalDateTime dateTime, String deliveryAddress, Integer uid) {
        this.volume = volume;
        this.weight = weight;
        this.dateTime = dateTime;
        this.deliveryAddress = deliveryAddress;
        this.uid = uid;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }
}
