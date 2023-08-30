package com.ford.coutlets.service;

import com.ford.coutlets.dto.BrandDto;
import com.ford.coutlets.model.Brand;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BrandService {



    Brand saveBrand(BrandDto brandDto);

    List<Brand> getAllBrand();

    void deleteBrand(Long id);


}
