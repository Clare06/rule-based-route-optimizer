package com.example.rulebasedrouteoptimization.controller;

import com.example.rulebasedrouteoptimization.model.Order;
import com.example.rulebasedrouteoptimization.model.OrderedItem;
import com.example.rulebasedrouteoptimization.orderrequest.ItemRequest;
import com.example.rulebasedrouteoptimization.service.OrderedItemService;
import com.example.rulebasedrouteoptimization.service.OrderService;
import com.example.rulebasedrouteoptimization.model.Product;
import com.example.rulebasedrouteoptimization.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/item")
@CrossOrigin(allowedHeaders = "*" ,origins = "*")
public class OrderedItemController {
    private  final OrderedItemService orderedItemService;
    private final OrderController orderController;

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderService orderService;

    public OrderedItemController (OrderedItemService orderedItemService, OrderController orderController){this.orderedItemService=orderedItemService;
        this.orderController = orderController;
    }

    @GetMapping
    public ResponseEntity<List<OrderedItem>> getAllItems(){
        List<OrderedItem> items= orderedItemService.listAllItems();

        return  new ResponseEntity<>(items, HttpStatus.OK);
    }
//    @GetMapping("/itembyid")
//    public ResponseEntity<List<OrderedItem>> getAllbyOid( ){
//        List<OrderedItem> itemsbyOid = orderedItemService.listByOid();
//        return new ResponseEntity<>(itemsbyOid,HttpStatus.OK);
//    }
      @GetMapping("/group-by-oid/{oid}")
    public ResponseEntity<List<OrderedItem>> getAllbyOid(@PathVariable("oid") Long oid ){
        List<OrderedItem> itemsByOid= orderedItemService.listByOid(oid);

        return new ResponseEntity<>(itemsByOid,HttpStatus.OK);
      }
    @GetMapping("listbyuid/{uid}")
    public ResponseEntity<List<OrderedItem>> listByUid (@PathVariable("uid") Integer uid){
        Long [] oidArr= orderService.getOids(uid);
        List<OrderedItem> listByUid = orderedItemService.listByOidArr(oidArr);
        return new ResponseEntity<>(listByUid,HttpStatus.OK);
    }

    @PostMapping
    public List<OrderedItem> addItems(@RequestBody List<ItemRequest> itemRequests) {
        List<OrderedItem> orderedItems = new ArrayList<>();
//        Long lastAddedOid = orderService.getLastAddedOid();
        Order order = orderService.getOrderByOid(orderController.order_id);
        for (ItemRequest itemRequest : itemRequests) {
            Product product = productService.getProductById(itemRequest.getPid());
//         product.setAvailableQuantity(product.getAvailableQuantity()-itemRequest.getOrderedQuantity());
            OrderedItem orderedItem = new OrderedItem(itemRequest, product, order);
            orderedItems.add(orderedItemService.additems(orderedItem));
        }
        return orderedItems;
    }


}
