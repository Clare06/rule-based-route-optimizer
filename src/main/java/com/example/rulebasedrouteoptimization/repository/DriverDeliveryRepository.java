package com.example.rulebasedrouteoptimization.repository;

import com.example.rulebasedrouteoptimization.model.DriverDelivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DriverDeliveryRepository extends JpaRepository<DriverDelivery,Long> {
    @Query("SELECT dd from DriverDelivery dd where dd.user.id=:did")
    List<Optional<DriverDelivery>> listbyDID(@Param("did") Integer did);
}
