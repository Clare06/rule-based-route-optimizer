package com.example.rulebasedrouteoptimization.repository;

import com.example.rulebasedrouteoptimization.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}
