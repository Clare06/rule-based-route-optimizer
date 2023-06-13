package com.example.rulebasedrouteoptimization.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "product")
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pid")
    private Integer pid;
    @Column(name = "product_name")
    private String productName;
    @Column(name = "weight_per_unit")
    private Integer weightPerUnit;
    @Column(name = "volume_per_unit")
    private Integer volumePerUnit;

    @Column(name = "available_quantity")
    private Integer availableQuantity;

    @OneToMany(mappedBy = "product",fetch = FetchType.LAZY)
    private List<OrderedItem> orderedItems;

    @OneToMany(mappedBy = "product",fetch = FetchType.LAZY)
    private List<Inventory> inventories;
    public Product(Integer pid, String productName, Integer weightPerUnit, Integer volumePerUnit, Integer availableQuantity) {
        this.pid = pid;
        this.productName = productName;
        this.weightPerUnit = weightPerUnit;
        this.volumePerUnit = volumePerUnit;
        this.availableQuantity= availableQuantity;
    }

    public Product(String productName, Integer weightPerUnit, Integer volumePerUnit, Integer availableQuantity) {
        this.productName = productName;
        this.weightPerUnit = weightPerUnit;
        this.volumePerUnit = volumePerUnit;
        this.availableQuantity= availableQuantity;
    }

    public Product() {
        super();
        this.productName = productName;
        this.weightPerUnit = weightPerUnit;
        this.volumePerUnit = volumePerUnit;
        this.availableQuantity = availableQuantity;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(Integer availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getWeightPerUnit() {
        return weightPerUnit;
    }

    public void setWeightPerUnit(Integer weightPerUnit) {
        this.weightPerUnit = weightPerUnit;
    }

    public Integer getVolumePerUnit() {
        return volumePerUnit;
    }

    public void setVolumePerUnit(Integer volumePerUnit) {
        this.volumePerUnit = volumePerUnit;
    }
}
