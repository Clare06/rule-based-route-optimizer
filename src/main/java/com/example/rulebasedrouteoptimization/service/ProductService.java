package com.example.rulebasedrouteoptimization.service;

import com.example.rulebasedrouteoptimization.model.Product;
import com.example.rulebasedrouteoptimization.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final InventoryService inventoryService;

    @Autowired
    public ProductService(ProductRepository productRepository, InventoryService inventoryService){
        this.productRepository=productRepository;
        this.inventoryService = inventoryService;
    }

    public List<Product> listAllProducts (){
        return productRepository.findAll();
    }

    public Product getProductById(Integer pid) {
        return productRepository.findById(pid).orElse(null);
    }

    public Product addProduct(Product product){
        Product product1 = productRepository.save(product);
//        inventoryService.addInventory(product1);
        return product1;
    }

    public void deleteProductById(Integer pid) {
        Optional<Product> optionalProduct = productRepository.findById(pid);
        if(optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            productRepository.delete(product);
        }
    }

}
