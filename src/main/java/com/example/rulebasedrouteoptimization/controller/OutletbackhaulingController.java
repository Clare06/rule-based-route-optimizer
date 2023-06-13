package com.example.rulebasedrouteoptimization.controller;

import com.example.rulebasedrouteoptimization.model.Outletbackhauling;
import com.example.rulebasedrouteoptimization.service.OutletbackhaulingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("outletbackhauling")
@CrossOrigin(allowedHeaders = "*" ,origins = "*")
public class OutletbackhaulingController {
    private  final OutletbackhaulingService outletbackhaulingService;
    public OutletbackhaulingController(OutletbackhaulingService outletbackhaulingService){this.outletbackhaulingService=outletbackhaulingService;}
    @GetMapping
    public ResponseEntity<List<Outletbackhauling>> getAll(){
        List<Outletbackhauling> items= outletbackhaulingService.listAll();
        return  new ResponseEntity<>(items, HttpStatus.OK);
    }
    @GetMapping("getByObId/{obid}")
    public ResponseEntity<List<Optional<Outletbackhauling>>> getByObID(@PathVariable("obid") List<Long> obid){

        return  new ResponseEntity<>(this.outletbackhaulingService.getByObIDs(obid),HttpStatus.OK);

    }
}
