package com.example.rulebasedrouteoptimization.model;

import java.util.List;

public class DataObjectOpt {
    private List<Long> curOrder;
    private List<Long> curReq;
    private String selectedVehicle;


    public List<Long> getCurOrder() {
        return curOrder;
    }

    public void setCurOrder(List<Long> curOrder) {
        this.curOrder = curOrder;
    }

    public List<Long> getCurReq() {
        return curReq;
    }

    public void setCurReq(List<Long> curReq) {
        this.curReq = curReq;
    }

    public String getSelectedVehicle() {
        return selectedVehicle;
    }

    public void setSelectedVehicle(String selectedVehicle) {
        this.selectedVehicle = selectedVehicle;
    }
}
