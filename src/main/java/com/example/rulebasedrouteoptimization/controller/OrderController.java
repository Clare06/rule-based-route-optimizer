package com.example.rulebasedrouteoptimization.controller;

import com.example.rulebasedrouteoptimization.model.Order;
import com.example.rulebasedrouteoptimization.repository.OrderRepository;
import com.example.rulebasedrouteoptimization.service.OrderService;
import com.example.rulebasedrouteoptimization.model.User;
import com.example.rulebasedrouteoptimization.service.UserService;
import com.example.rulebasedrouteoptimization.orderrequest.OrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.YearMonth;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/order")
@CrossOrigin(allowedHeaders = "*" ,origins = "*")
public class OrderController {
    public Long order_id;
    private  final OrderService orderService;
    @Autowired
    private UserService userService;

    @Autowired
    private OrderRepository orderRepository;

    public OrderController(OrderService orderService){

        this.orderService=orderService;

    }
    @GetMapping("test")
    public ResponseEntity<String> getString(){
        return ResponseEntity.ok("hey I am here");
    }
    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders(){
        List<Order> orders= orderService.listAllOrders();

        return  new ResponseEntity<>(orders, HttpStatus.OK);
    }
    @DeleteMapping("delete/{oid}")
    public void deleteOrder(@PathVariable("oid") Long oid){
        this.orderService.deleteOrderbyId(oid);
    }
//    @GetMapping("get-by-id/{oid}")
//    public ResponseEntity<Optional<Order>> getbyID(@PathVariable("oid") Long oid){
//
//       return  new ResponseEntity<>(this.orderService.getOrderbyID(oid),HttpStatus.OK);
//    }
    @GetMapping("getByIds/{oids}")
    public ResponseEntity<List<Optional<Order>>> getbyIDS(@PathVariable List<Long> oids){
//        System.out.println("hi");
//        System.out.println(oids);
        return  new ResponseEntity<>(this.orderService.getOrderbyIDs(oids),HttpStatus.OK);

    }

    @GetMapping("/orders/{oid}")
    public ResponseEntity<Order> getOrderByOid(@PathVariable Long oid) {
        Order order = orderService.getOrderByOid(oid);
        if (order == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(order);
        }
    }

    @PostMapping
    public Order createOrder(@RequestBody OrderRequest orderRequest) {
        User user = userService.getUserByUid(orderRequest.getUid());
        Order order = new Order(orderRequest, user);
        Order order1 = orderRepository.save(order);
        this.order_id=order.getOid();
        return order1;
    }

    @GetMapping("count")
    public Integer getcount(){
        Integer order_count = orderRepository.ordercount();
        return order_count;
    }

    @GetMapping("/grouped_by_month/{uid}")
    public ResponseEntity<Map<YearMonth, Integer>> getOrdersCountGroupedByMonth(@PathVariable Integer uid) {
        List<Order> orders = orderRepository.findAllGroupedByUser(uid);

        Map<YearMonth, List<Order>> ordersByMonth = orders.stream()
                .collect(Collectors.groupingBy(order -> YearMonth.from(order.getDateTime())));

        Map<YearMonth, Integer> orderCountsByMonth = new HashMap<>();
        for (Map.Entry<YearMonth, List<Order>> entry : ordersByMonth.entrySet()) {
            YearMonth month = entry.getKey();
            List<Order> ordersForMonth = entry.getValue();
            int orderCount = ordersForMonth.size();
            orderCountsByMonth.put(month, orderCount);
        }

        return ResponseEntity.ok(orderCountsByMonth);
    }



}
