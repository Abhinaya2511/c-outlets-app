package com.ford.coutlets.controller;

import java.util.List;

import com.ford.coutlets.dto.BrandProductDto;
import com.ford.coutlets.dto.CategoryProductDto;
import com.ford.coutlets.service.ProductService;
import com.ford.coutlets.dto.ProductDto;
import com.ford.coutlets.model.Product;
import com.ford.coutlets.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService productService;


    @GetMapping("/products")
    public List<Product> getAllProducts(){

        return productService.getProduct();
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Product response=productService.getProductById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/brand/product/{id}")
    public ResponseEntity<BrandProductDto> getProductBrand(@PathVariable Long id){
        BrandProductDto brandProductDto=productService.getProductBrand(id);
        return ResponseEntity.ok(brandProductDto);
    }

    @GetMapping("/category/product/{id}")
    public ResponseEntity<CategoryProductDto> getProductCategory(@PathVariable Long id){
        CategoryProductDto categoryProductDto=productService.getProductCategory(id);
        return ResponseEntity.ok(categoryProductDto);
    }


    @PostMapping("/products")
    public String createProduct(@Valid @RequestBody ProductDto productDto) throws Exception
    {
        productService.saveProduct(productDto);
        return "Product Saved Successfully";
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<Product> updatedProduct(@PathVariable Long id, @RequestBody ProductDto productDto){
        Product updatedProduct=productService.updateProduct(productDto,id);
        return ResponseEntity.ok(updatedProduct);
    }


    @DeleteMapping("/products/{id}")
    public String deleteEmployee(@PathVariable Long id){
        productService.deleteProduct(id);
        return "Deleted successfully";
    }
}

