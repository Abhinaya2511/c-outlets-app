package com.ford.coutlets.repository;

import com.ford.coutlets.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BrandRepository extends JpaRepository<Brand,Long> {
}
