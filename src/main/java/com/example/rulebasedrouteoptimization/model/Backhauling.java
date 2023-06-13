package com.example.rulebasedrouteoptimization.model;

import com.example.rulebasedrouteoptimization.orderrequest.BackhaulRequest;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "backhauling")
public class Backhauling implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "returnid")
    private Long retID;
    @Column(name = "tweight")
    private Integer tWeight;
    @Column(name = "tvolume")
    private Integer tVolume;
    @Column(name = "returnquantity")
    private Integer retQuantity;
    @Column(name = "reason")
    private String reason;

    @ManyToOne
    @JoinColumn(name = "pidd",referencedColumnName = "pid")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Product product;

    @OneToOne(mappedBy = "backhauling",fetch = FetchType.LAZY)
    private Outletbackhauling outletbackhauling;

    @OneToOne(mappedBy = "backhauling",fetch = FetchType.LAZY)
    private Warehousebackhauling warehousebackhauling;

    public Backhauling(Long retID, Integer tWeight, Integer tVolume, Integer retQuantity, String reason, Product product) {
        this.retID = retID;
        this.tWeight = tWeight;
        this.tVolume = tVolume;
        this.retQuantity = retQuantity;
        this.reason = reason;
        this.product = product;

    }

    public Backhauling(Integer tWeight, Integer tVolume, Integer retQuantity, String reason, Product product) {
        this.tWeight = tWeight;
        this.tVolume = tVolume;
        this.retQuantity = retQuantity;
        this.reason = reason;
        this.product = product;

    }

    public Backhauling() {
//        super();
//        this.tWeight = tWeight;
//        this.tVolume = tVolume;
//        this.retQuantity = retQuantity;
//        this.reason = reason;
//        this.product = product;

    }

    public Backhauling(BackhaulRequest backhaulRequest,Product product){
        this.tWeight = backhaulRequest.getWeight();
        this.tVolume = backhaulRequest.getVolume();
        this.retQuantity = backhaulRequest.getQuantity();
        this.reason = backhaulRequest.getReason();
        this.product = product;
    }

    public Long getRetID() {
        return retID;
    }

    public Integer gettWeight() {
        return tWeight;
    }

    public void settWeight(Integer tWeight) {
        this.tWeight = tWeight;
    }

    public Integer gettVolume() {
        return tVolume;
    }

    public void settVolume(Integer tVolume) {
        this.tVolume = tVolume;
    }

    public Integer getRetQuantity() {
        return retQuantity;
    }

    public void setRetQuantity(Integer retQuantity) {
        this.retQuantity = retQuantity;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }


}
