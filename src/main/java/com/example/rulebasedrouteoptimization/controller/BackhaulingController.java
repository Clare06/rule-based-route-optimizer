package com.example.rulebasedrouteoptimization.controller;

import com.example.rulebasedrouteoptimization.model.*;
import com.example.rulebasedrouteoptimization.repository.BackhaulingRepository;
import com.example.rulebasedrouteoptimization.service.BackhaulingService;
import com.example.rulebasedrouteoptimization.orderrequest.BackhaulRequest;
import com.example.rulebasedrouteoptimization.repository.OutletbackhaulingRepository;
import com.example.rulebasedrouteoptimization.service.OutletbackhaulingService;
import com.example.rulebasedrouteoptimization.service.UserService;
import com.example.rulebasedrouteoptimization.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/backhaul")
@CrossOrigin(allowedHeaders = "*" ,origins = "*")
public class BackhaulingController {
    private final BackhaulingService backhaulingService;
    private final ProductService productService;
    private final UserService userService;
    @Autowired
    private BackhaulingRepository backhaulingRepository;
    @Autowired
    private OutletbackhaulingRepository outletbackhaulingRepository;
    @Autowired
    private OutletbackhaulingService outletbackhaulingService;

    public BackhaulingController(BackhaulingService backhaulingService, ProductService productService, UserService userService,BackhaulingRepository backhaulingRepository) {
        this.backhaulingService = backhaulingService;
        this.productService = productService;
        this.userService = userService;
        this.backhaulingRepository = backhaulingRepository;
    }

    @PostMapping
    public void createBackhaul(@RequestBody BackhaulRequest backhaulRequest) {
        Product product = productService.getProductById(backhaulRequest.getPid());
        User user = userService.getUserByUid(backhaulRequest.getUid());
        Backhauling backhauling = new Backhauling(backhaulRequest,product);
        Outletbackhauling outletbackhauling = new Outletbackhauling(backhauling,user);
        outletbackhauling.setBackhauling(backhauling);
        backhaulingRepository.save(backhauling);
        outletbackhaulingRepository.save(outletbackhauling);
    }
    @GetMapping("listbyuid/{uid}")
    public ResponseEntity<List<Backhauling>> listByUid (@PathVariable("uid") Integer uid){
        Long [] oidArr= outletbackhaulingService.getRids(uid);
        List<Backhauling> listByUid = backhaulingService.listByRidArr(oidArr);
        return new ResponseEntity<>(listByUid, HttpStatus.OK);
    }
}
