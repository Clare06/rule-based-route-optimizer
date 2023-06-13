package com.example.rulebasedrouteoptimization.service;

import com.example.rulebasedrouteoptimization.model.Order;
import com.example.rulebasedrouteoptimization.model.Outletbackhauling;
import com.example.rulebasedrouteoptimization.repository.OutletbackhaulingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OutletbackhaulingService {
   private OutletbackhaulingRepository outletbackhaulingRepository;

   @Autowired
    public OutletbackhaulingService (OutletbackhaulingRepository outletbackhaulingRepository){this.outletbackhaulingRepository=outletbackhaulingRepository;}

    public List<Outletbackhauling> listAll(){
       return this.outletbackhaulingRepository.findAll();
    }

    public List<Optional<Outletbackhauling>> getByObIDs(List<Long> obid) {
       List<Optional<Outletbackhauling>> retItems= new ArrayList<>();

       obid.forEach(element->{
           retItems.add(outletbackhaulingRepository.findById(element));
               }

               );
       return retItems;
    }
    public Long[] getRids (Integer uid){
        List<Outletbackhauling> retListById=outletbackhaulingRepository.listByUid(uid);
        Long[] ridsArr = retListById.stream().map(outletbackhauling -> outletbackhauling.getBackhauling().getRetID()).toArray(Long[]::new);

        return ridsArr;

    }
}
