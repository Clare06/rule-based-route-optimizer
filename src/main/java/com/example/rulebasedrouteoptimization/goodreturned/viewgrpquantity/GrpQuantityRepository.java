package com.example.rulebasedrouteoptimization.goodreturned.viewgrpquantity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrpQuantityRepository extends JpaRepository<GrpQuantity,Long> {
}
