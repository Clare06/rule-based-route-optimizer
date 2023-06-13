package com.example.rulebasedrouteoptimization.repository;

import com.example.rulebasedrouteoptimization.model.Rgood;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RgoodRepository extends JpaRepository<Rgood,Long> {

}
