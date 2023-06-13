package com.example.rulebasedrouteoptimization.controller;

import com.example.rulebasedrouteoptimization.model.Backhauling;
import com.example.rulebasedrouteoptimization.model.DataObjectOpt;
import com.example.rulebasedrouteoptimization.model.Order;
import com.example.rulebasedrouteoptimization.model.Vehicle;
import com.example.rulebasedrouteoptimization.service.BackhaulingService;
import com.example.rulebasedrouteoptimization.service.OrderService;
import com.example.rulebasedrouteoptimization.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/opt")
@CrossOrigin(allowedHeaders = "*" ,origins = "*")
public class OptaApiController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private BackhaulingService backhaulingService;
    @Autowired
    private VehicleService vehicleService;
    @PostMapping("/map")
    public void dataOpt(@RequestBody DataObjectOpt dataObjectOpt){

        System.out.println(dataObjectOpt.getCurOrder());
        System.out.println(dataObjectOpt.getCurReq());
        System.out.println(dataObjectOpt.getSelectedVehicle());
        Long[] oidArr = dataObjectOpt.getCurOrder().toArray(new Long[0]);
        Long[] ridArr = dataObjectOpt.getCurReq().toArray(new Long[0]);
        System.out.println(oidArr.length);
        System.out.println(ridArr.length);
        List<Order> ordObj  = orderService.orderbyOidarr(oidArr);
        List<Backhauling> retObj = backhaulingService.listByRidArr(ridArr);
        Optional<Vehicle> vehObj = vehicleService.vehicleById(dataObjectOpt.getSelectedVehicle());
        System.out.println(ordObj.get(0).getDateTime());
        System.out.println(retObj.get(0).getProduct().getProductName());
        System.out.println(vehObj.get().getMaxVol());
    }
}
