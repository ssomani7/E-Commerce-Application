package com.saurabhsomani.repository;

import com.saurabhsomani.domain.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository <Product, Long>{

}
