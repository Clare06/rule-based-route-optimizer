package com.example.rulebasedrouteoptimization.model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "driverdelivery")
public class DriverDelivery implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name= "ddid")
    private Long ddID;

    @OneToOne
    @JoinColumn(name = "doid",referencedColumnName = "oid")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "did",referencedColumnName = "id")
    private User user;

    public DriverDelivery(Long ddID, Order order, User user) {
        this.ddID = ddID;
        this.order = order;
        this.user = user;
    }

    public DriverDelivery() {

    }

    public Long getDdID() {
        return ddID;
    }


    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
