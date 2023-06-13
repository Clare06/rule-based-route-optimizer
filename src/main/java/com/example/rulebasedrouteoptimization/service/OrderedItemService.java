package com.example.rulebasedrouteoptimization.service;

import com.example.rulebasedrouteoptimization.model.OrderedItem;
import com.example.rulebasedrouteoptimization.repository.OrderedItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderedItemService {
    private final OrderedItemRepository orderedItemRepository;
    @Autowired
    public OrderedItemService(OrderedItemRepository orderedItemRepository){this.orderedItemRepository=orderedItemRepository;}

    public List<OrderedItem> listAllItems (){

        return orderedItemRepository.findAll();
    }
    public List<OrderedItem> listByOid(Long oid){

        return orderedItemRepository.findAllGroupedByOrder(oid);
    }
    public List<OrderedItem> listByOidArr(Long[] oidArr){
        return orderedItemRepository.findByOidArr(oidArr);
    }

    public OrderedItem additems(OrderedItem orderedItem) {
        return orderedItemRepository.save(orderedItem);
    }

}
