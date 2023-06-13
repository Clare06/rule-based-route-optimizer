package com.example.rulebasedrouteoptimization.model;

import com.example.rulebasedrouteoptimization.model.Order;
import com.example.rulebasedrouteoptimization.orderrequest.ItemRequest;
import com.example.rulebasedrouteoptimization.model.Product;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ordered_item")
public class OrderedItem implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "itemid")
    private long oItemID;
    @Column(name = "ordered_quantity")
    private Integer orderedQuantity;

    @ManyToOne
    @JoinColumn(name = "pid",referencedColumnName = "pid")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "oid",referencedColumnName = "oid")
    private Order order;

    public OrderedItem() {
        super();
        this.orderedQuantity = orderedQuantity;
        this.product = product;
        this.order = order;
    }

    public OrderedItem(long oItemID, Integer orderedQuantity, Product product, Order order) {
        this.oItemID = oItemID;
        this.orderedQuantity = orderedQuantity;
        this.product = product;
        this.order = order;
    }

    public OrderedItem(Integer orderedQuantity, Product product, Order order) {
        this.orderedQuantity = orderedQuantity;
        this.product = product;
        this.order = order;
    }

   public OrderedItem(ItemRequest itemRequest,Product product,Order order){
        this.orderedQuantity = itemRequest.getOrderedQuantity();
        this.product = product;
        this.order = order;
    }



    public Integer getOrderedQuantity() {
        return orderedQuantity;
    }

    public void setOrderedQuantity(Integer orderedQuantity) {
        this.orderedQuantity = orderedQuantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public long getoItemID() {
        return oItemID;
    }
}
