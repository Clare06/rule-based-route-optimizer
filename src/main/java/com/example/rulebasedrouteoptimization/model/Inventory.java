package com.example.rulebasedrouteoptimization.model;

import com.example.rulebasedrouteoptimization.model.Product;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "inventory")
public class Inventory implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "inv_id")
    private Long invId;
    @CreationTimestamp
    @Column(name = "date_added")
    private Date date;
    @Column(name = "quantity_added")
    private Integer quantityAdded;

    @ManyToOne
    @JoinColumn(name = "p_id",referencedColumnName = "pid")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Product product;

    public Inventory(Date date, Integer quantityAdded, Product product) {
        this.date = date;
        this.quantityAdded = quantityAdded;
        this.product = product;
    }

    public Inventory(Long invId, Date date, Integer quantityAdded, Product product) {
        this.invId = invId;
        this.date = date;
        this.quantityAdded = quantityAdded;
        this.product = product;
    }

    public Inventory() {
    }

    public Long getInvId() {
        return invId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getQuantityAdded() {
        return quantityAdded;
    }

    public void setQuantityAdded(Integer quantityAdded) {
        this.quantityAdded = quantityAdded;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
