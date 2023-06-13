package com.example.rulebasedrouteoptimization.repository;

import com.example.rulebasedrouteoptimization.model.Order;
import com.example.rulebasedrouteoptimization.model.Outletbackhauling;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OutletbackhaulingRepository extends JpaRepository<Outletbackhauling,Long> {
    @Query("SELECT ob from Outletbackhauling ob where ob.user.id=:uid")
    List<Outletbackhauling> listByUid (@Param("uid") Integer uid);

}
