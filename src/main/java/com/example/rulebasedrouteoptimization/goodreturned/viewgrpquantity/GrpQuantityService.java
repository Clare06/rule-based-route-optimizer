package com.example.rulebasedrouteoptimization.goodreturned.viewgrpquantity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GrpQuantityService {
    private GrpQuantityRepository grpQuantityRepository;
    @Autowired
    public GrpQuantityService(GrpQuantityRepository grpQuantityRepository){
        this.grpQuantityRepository=grpQuantityRepository;
    }

    public List<GrpQuantity> listAllGrpQuantities() {
        return grpQuantityRepository.findAll();
    }
}
