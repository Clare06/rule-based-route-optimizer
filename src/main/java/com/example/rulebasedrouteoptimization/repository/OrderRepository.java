package com.example.rulebasedrouteoptimization.repository;

import com.example.rulebasedrouteoptimization.model.Order;
import com.example.rulebasedrouteoptimization.model.OrderedItem;
import com.example.rulebasedrouteoptimization.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepository extends JpaRepository <Order, Long>{
//        @Query("SELECT MAX(o.oid) FROM Order o")
//        Long findLastAddedOid();
//
//        @Query("SELECT o FROM Order o WHERE o.oid = (SELECT MAX(oid) FROM Order)")
//        Order findLastAddedOrder();
    @Query("SELECT do from Order do where do.user.id= :uid")
    List<Order> listByUid (@Param("uid") Integer uid);

    @Query("SELECT COUNT(do) FROM Order do")
    Integer ordercount ();

    @Query("SELECT od FROM Order od where od.oid in :oid")
    List<Order> listOrdersByoidarr (@Param("oid") Long[] oidArr);

    @Query("SELECT o from Order o where o.user.id= :uid")
    List<Order> findAllGroupedByUser (@Param("uid") Integer uid);

    List<Order> findByUser(User user);

}
