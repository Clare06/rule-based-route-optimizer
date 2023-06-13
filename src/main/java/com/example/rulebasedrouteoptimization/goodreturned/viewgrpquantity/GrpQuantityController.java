package com.example.rulebasedrouteoptimization.goodreturned.viewgrpquantity;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rgood")
@CrossOrigin(allowedHeaders = "*" ,origins = "*")
public class GrpQuantityController {
    private GrpQuantityService grpQuantityService;

    public GrpQuantityController(GrpQuantityService grpQuantityService){
        this.grpQuantityService=grpQuantityService;
    }

    @GetMapping
    public ResponseEntity<List<GrpQuantity>> getAllOrders(){
        List<GrpQuantity> grpQuantities = grpQuantityService.listAllGrpQuantities();

        return  new ResponseEntity<>(grpQuantities, HttpStatus.OK);
    }
}
