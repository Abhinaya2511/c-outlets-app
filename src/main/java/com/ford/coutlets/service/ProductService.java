package com.ford.coutlets.service;

import com.ford.coutlets.dto.BrandDto;
import com.ford.coutlets.dto.BrandProductDto;
import com.ford.coutlets.dto.CategoryProductDto;
import com.ford.coutlets.dto.ProductDto;
import com.ford.coutlets.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    Product saveProduct(ProductDto productDto) throws Exception;

    List<Product> getProduct();

    Product getProductById(long id);

    BrandProductDto getProductBrand(long id);

    CategoryProductDto getProductCategory(long id);

    Product updateProduct(ProductDto productDto, Long id);

    void deleteProduct(Long id);


}
