package com.ford.coutlets.repository;

import com.ford.coutlets.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {



}
