package com.example.rulebasedrouteoptimization.service;

import com.example.rulebasedrouteoptimization.model.Order;
import com.example.rulebasedrouteoptimization.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    private  final OrderRepository orderRepository;
    @Autowired
    public OrderService(OrderRepository orderRepository){
        this.orderRepository= orderRepository;
    }

    public List<Order> listAllOrders (){

        return orderRepository.findAll();
    }
    public void deleteOrderbyId(Long oid){

        this.orderRepository.deleteById(oid);
    }
    public Optional<Order> getOrderbyID(Long oid){
//        Optional<Order> getByID= orderRepository.findById(oid);
        return  orderRepository.findById(oid);
    }

    public List<Optional<Order>> getOrderbyIDs(List<Long> oids) {
        List<Optional<Order>> orders = new ArrayList<>();

        oids.forEach(oid->{
            orders.add(orderRepository.findById(oid));
                }
        );
        return orders;
    }

    public Order getOrderByOid(Long oid) {
        return orderRepository.findById(oid).orElse(null);
    }

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    public Long[] getOids (Integer uid){
        List<Order> orderListById=orderRepository.listByUid(uid);
        Long[] oidsArr = orderListById.stream().map(Order ::getOid).toArray(Long[]::new);

        return oidsArr;

    }
    public List<Order> orderbyOidarr (Long[] oidArr){
        return orderRepository.listOrdersByoidarr(oidArr);
    }
}
