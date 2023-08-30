package com.ford.coutlets.serviceImpl;

import com.ford.coutlets.dto.BrandDto;
import com.ford.coutlets.model.Brand;
import com.ford.coutlets.repository.BrandRepository;
import com.ford.coutlets.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    BrandRepository brandRepository;




    @Override
    public Brand saveBrand(BrandDto brandDto) {
        Brand brand=new Brand();
        brand.setBrandName(brandDto.getBrandName());
        return brandRepository.save(brand);
    }

    @Override
    public List<Brand> getAllBrand() {

        return brandRepository.findAll();
    }

    @Override
    public void deleteBrand(Long id) {
        brandRepository.deleteById(id);

    }
}
