package com.example.rulebasedrouteoptimization.model;

import com.example.rulebasedrouteoptimization.otp.OtpTable;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String email;
    private String password;
    private String role;
    @Column(name = "prof_img_url")
    private String profImgUrl;

    @Column(name = "branch")
    private String branch;
    @Column(name = "phone")
    private String phone;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Order> deliveryOrders;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Outletbackhauling> outletbackhaulings;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Warehousebackhauling> warehousebackhaulings;

    @OneToOne(mappedBy = "user",fetch = FetchType.LAZY)
    private OtpTable otpTable;

    public User(String name, String email, String branch, String phone) {
        this.name = name;
        this.email = email;
        this.branch = branch;
        this.phone = phone;
    }

    public User(Integer id, String name, String email, String password, String role, String profImgUrl, String branch) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role=role;
        this.profImgUrl=profImgUrl;
        this.branch=branch;
    }

    public User(String name, String email, String password, String branch, String phone) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.branch = branch;
        this.phone = phone;
    }

    public User(String name, String email, String password, String role, String profImgUrl, String branch) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role=role;
        this.profImgUrl=profImgUrl;
        this.branch=branch;
    }

    public User() {
        super();
        this.name = name;
        this.email = email;
        this.password = password;
        this.role=role;
        this.profImgUrl=profImgUrl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfImgUrl() {
        return profImgUrl;
    }

    public void setProfImgUrl(String profImgUrl) {
        this.profImgUrl = profImgUrl;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
