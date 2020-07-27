package com.saurabhsomani.controller;

import com.saurabhsomani.domain.Product;
import com.saurabhsomani.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {
    //no business logic in controller

    private ProductService productService;

    //constructor
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    public ProductService getProductService() {
        return productService;
    }

    @GetMapping("/list")
    public Iterable<Product> list(){
        return productService.list();
    }


}
