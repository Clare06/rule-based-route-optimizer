package com.example.rulebasedrouteoptimization.model;

import com.example.rulebasedrouteoptimization.model.Backhauling;
import com.example.rulebasedrouteoptimization.model.User;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "warehousebackhauling")
public class Warehousebackhauling implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idwarehousebackhauling")
    private Long wbId;

    @ManyToOne
    @JoinColumn(name = "warehouseid",referencedColumnName = "id")
    private User user;

    @OneToOne
    @JoinColumn(name = "retid",referencedColumnName = "returnid")
    private Backhauling backhauling;

    public Warehousebackhauling(Long wbId, User user, Backhauling backhauling) {
        this.wbId = wbId;
        this.user = user;
        this.backhauling = backhauling;
    }

    public Warehousebackhauling() {

    }

    public Warehousebackhauling(User user, Backhauling backhauling) {
        this.user = user;
        this.backhauling = backhauling;
    }

    public Long getWbId() {
        return wbId;
    }

    public void setWbId(Long wbId) {
        this.wbId = wbId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Backhauling getBackhauling() {
        return backhauling;
    }

    public void setBackhauling(Backhauling backhauling) {
        this.backhauling = backhauling;
    }
}
