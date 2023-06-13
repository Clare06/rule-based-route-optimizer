package com.example.rulebasedrouteoptimization.orderrequest;

public class ItemRequest {
    private Integer orderedQuantity;
    private Integer pid;

    public ItemRequest(Integer orderedQuantity, Integer pid) {
        this.orderedQuantity = orderedQuantity;
        this.pid = pid;
    }

    public Integer getOrderedQuantity() {
        return orderedQuantity;
    }

    public void setOrderedQuantity(Integer orderedQuantity) {
        this.orderedQuantity = orderedQuantity;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }
}
