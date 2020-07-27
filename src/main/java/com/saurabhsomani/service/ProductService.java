package com.saurabhsomani.service;

import com.saurabhsomani.domain.Product;
import com.saurabhsomani.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Iterable<Product> list(){
        return productRepository.findAll();
    }

    //to save one product
    public Product save(Product product){
        return productRepository.save(product);
    }

    //to save list of products
    public void save(List<Product> products) {
        productRepository.saveAll(products);
    }

}
