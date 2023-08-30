package com.ford.coutlets.controller;

import com.ford.coutlets.dto.BrandDto;
import com.ford.coutlets.model.Brand;
import com.ford.coutlets.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")

public class BrandController {
    @Autowired
    BrandService brandService;
    @GetMapping("/brands")
    public List<Brand> getBrands(){

        return brandService.getAllBrand();
    }

    @PostMapping("/brands")
        public String savebrands(@Valid @RequestBody BrandDto brandDto){
        brandService.saveBrand(brandDto);
        return "Brand Saved Successfully";
    }

    @DeleteMapping("/brands/{id}")
     public String deleteBrand(@PathVariable long brandId){
        brandService.deleteBrand(brandId);
        return "Deleted Successfully";
    }

}
