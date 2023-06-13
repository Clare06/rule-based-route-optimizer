package com.example.rulebasedrouteoptimization.model;

import com.example.rulebasedrouteoptimization.orderrequest.OrderRequest;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "delivery_order")
public class Order implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "oid")
    private Long oid;
    @Column(name = "volume")
    private Integer volume;
    @Column(name = "weight")
    private Integer weight;

    @CreationTimestamp
    @Column(name = "date_time")
    private LocalDateTime dateTime;
    @Column(name = "delivery_address")
    private String deliveryAddress;
    @ManyToOne
    @JoinColumn(name = "uid", referencedColumnName="id")
    private User user;

    @OneToMany(mappedBy = "order",fetch = FetchType.LAZY)
    private List<OrderedItem> orderedItems;

    public Order() {
        super();
        this.volume = volume;
        this.weight = weight;
        this.dateTime = dateTime;
        this.deliveryAddress = deliveryAddress;
        this.user = user;
    }

    public Order(OrderRequest orderRequest, User user) {
        this.volume = orderRequest.getVolume();
        this.weight = orderRequest.getWeight();
        this.deliveryAddress = orderRequest.getDeliveryAddress();
        this.user = user;
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

    public Long getOid() {
        return oid;
    }

    public User getUser() {
        return user;
    }

    public Order(Long oid, Integer volume, Integer weight, LocalDateTime dateTime, String deliveryAddress, User user) {
        this.oid = oid;
        this.volume = volume;
        this.weight = weight;
        this.dateTime = dateTime;
        this.deliveryAddress = deliveryAddress;
        this.user = user;
    }

    public Order(Integer volume, Integer weight, LocalDateTime dateTime, String deliveryAddress) {
        this.volume = volume;
        this.weight = weight;
        this.dateTime = dateTime;
        this.deliveryAddress = deliveryAddress;
    }

    public Order(Integer volume, Integer weight, LocalDateTime dateTime, String deliveryAddress, User user) {
        this.volume = volume;
        this.weight = weight;
        this.dateTime = dateTime;
        this.deliveryAddress = deliveryAddress;
        this.user = user;
    }

    @Override
    public String toString() {
        return "Order{" +
                "oid=" + oid +
                ", volume=" + volume +
                ", weight=" + weight +
                ", dateTime=" + dateTime +
                ", deliveryAddress='" + deliveryAddress + '\'' +
                ", user=" + user +
                '}';
    }
}
