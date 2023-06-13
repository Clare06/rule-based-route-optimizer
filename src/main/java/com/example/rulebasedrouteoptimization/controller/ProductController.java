package com.example.rulebasedrouteoptimization.controller;

import com.example.rulebasedrouteoptimization.model.Product;
import com.example.rulebasedrouteoptimization.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@CrossOrigin(allowedHeaders = "*" ,origins = "*")
public class ProductController {
    private  final ProductService productService;

    public ProductController (ProductService productService){
        this.productService=productService;}

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.listAllProducts();

        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/products/{pid}")
    public ResponseEntity<Product> getProductByPid(@PathVariable Integer pid) {
        Product product = productService.getProductById(pid);
        if (product == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(product);
        }
    }

    @PostMapping
    public Product addProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }

    @DeleteMapping("products/{pid}")
    public ResponseEntity<Void> deleteProductById(@PathVariable("pid") Integer pid) {
        productService.deleteProductById(pid);
        return ResponseEntity.noContent().build();
    }
}

