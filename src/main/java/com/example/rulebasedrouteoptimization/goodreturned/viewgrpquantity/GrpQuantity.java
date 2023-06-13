package com.example.rulebasedrouteoptimization.goodreturned.viewgrpquantity;

import com.example.rulebasedrouteoptimization.model.Product;
import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Immutable
@IdClass(GrpQuantity.class)
@Table(name = "grp_quantity")
public class GrpQuantity implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "prodid")
    private Product product;
    @Id
    @Column(name = "year")
    private Integer year;
    @Id
    @Column(name = "month")
    private Integer month;

    @Column(name = "total_quantity")
    private Integer totalQuantity;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(Integer totalQuantity) {
        this.totalQuantity = totalQuantity;
    }
}
