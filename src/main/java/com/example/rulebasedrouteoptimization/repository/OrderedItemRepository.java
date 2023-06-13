package com.example.rulebasedrouteoptimization.repository;

import com.example.rulebasedrouteoptimization.model.OrderedItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderedItemRepository extends JpaRepository<OrderedItem,Long> {

//    List<OrderedItem> findOrderedItemsByOrder (Long oid);
    @Query("SELECT oi from OrderedItem oi where oi.order.oid= :oid")
    List<OrderedItem> findAllGroupedByOrder (@Param("oid") Long oid);
    @Query("SELECT oi from OrderedItem oi where oi.order.oid in :oidArr")
    List<OrderedItem> findByOidArr(@Param("oidArr") Long[] oidArr);

    @Override
    OrderedItem save(OrderedItem orderedItem);

    @Override
    List<OrderedItem> findAll();
}
