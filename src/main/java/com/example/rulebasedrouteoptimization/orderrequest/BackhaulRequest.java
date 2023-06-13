package com.example.rulebasedrouteoptimization.orderrequest;

public class BackhaulRequest {
    private Integer weight;
    private Integer volume;
    private Integer quantity;
    private String reason;
    private Integer pid;
    private Integer uid;

    public BackhaulRequest(Integer weight, Integer volume, Integer quantity, String reason, Integer pid, Integer uid) {
        this.weight = weight;
        this.volume = volume;
        this.quantity = quantity;
        this.reason = reason;
        this.pid = pid;
        this.uid = uid;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }
}
