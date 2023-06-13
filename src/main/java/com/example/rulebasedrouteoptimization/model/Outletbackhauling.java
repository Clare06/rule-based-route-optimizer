package com.example.rulebasedrouteoptimization.model;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "outletbackhauling")
public class Outletbackhauling implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idretoutlet")
    private Long obId;

    @OneToOne
    @JoinColumn(name = "rid",referencedColumnName = "returnid")
    private Backhauling backhauling;

    @ManyToOne
    @JoinColumn(name = "outletid",referencedColumnName = "id")
    private User user;

    public Outletbackhauling(Long obId, Backhauling backhauling, User user) {
        this.obId = obId;
        this.backhauling = backhauling;
        this.user = user;
    }

    public Outletbackhauling(Backhauling backhauling, User user) {
        this.backhauling = backhauling;
        this.user = user;
    }

    public Outletbackhauling() {
        super();

    }

    public Backhauling getBackhauling() {
        return backhauling;
    }

    public void setBackhauling(Backhauling backhauling) {
        this.backhauling = backhauling;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getObId() {
        return obId;
    }
}
