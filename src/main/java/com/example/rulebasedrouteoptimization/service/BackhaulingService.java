package com.example.rulebasedrouteoptimization.service;

import com.example.rulebasedrouteoptimization.model.Backhauling;
import com.example.rulebasedrouteoptimization.model.OrderedItem;
import com.example.rulebasedrouteoptimization.repository.BackhaulingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BackhaulingService {
    private BackhaulingRepository backhaulingRepository;
    @Autowired
    public BackhaulingService (BackhaulingRepository backhaulingRepository){this.backhaulingRepository=backhaulingRepository;}

    public List<Backhauling> listByRidArr(Long[] ridArr){
        return backhaulingRepository.findByRidArr(ridArr);
    }
}
