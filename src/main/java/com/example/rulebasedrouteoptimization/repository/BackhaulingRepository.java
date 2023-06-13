package com.example.rulebasedrouteoptimization.repository;

import com.example.rulebasedrouteoptimization.model.Backhauling;
import com.example.rulebasedrouteoptimization.model.OrderedItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BackhaulingRepository extends JpaRepository<Backhauling,Long> {
    @Query("SELECT oi from Backhauling oi where oi.retID in :ridArr")
    List<Backhauling> findByRidArr(@Param("ridArr") Long[] ridArr);
}
