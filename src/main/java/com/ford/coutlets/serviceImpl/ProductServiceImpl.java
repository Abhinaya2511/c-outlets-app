package com.ford.coutlets.serviceImpl;

import com.ford.coutlets.dto.BrandProductDto;
import com.ford.coutlets.dto.CategoryProductDto;
import com.ford.coutlets.dto.ProductDto;
import com.ford.coutlets.model.Brand;
import com.ford.coutlets.model.Category;
import com.ford.coutlets.model.Product;
import com.ford.coutlets.repository.BrandRepository;
import com.ford.coutlets.repository.CategoryRepository;
import com.ford.coutlets.repository.ProductRepository;
import com.ford.coutlets.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepo;
    @Autowired
    private BrandRepository brandRepository;
    @Autowired
    private CategoryRepository categoryRepository;


    /**
     * Saving the properties in the database
     */
    @Override
    public Product saveProduct(ProductDto productDto) throws Exception {
        try{
            Brand brand=brandRepository.findById(productDto.getBrandId()).get();
            if(Objects.isNull(brand)){
                throw new NullPointerException("Brand not Found");
            }
            Category category=categoryRepository.findById(productDto.getCategoryId()).get();
                if (Objects.isNull(brand)){
                    throw  new NullPointerException("Category not found");
                }

            Product product= new Product();
            product.setProductName(productDto.getProductName());
            product.setMfDate(productDto.getMfDate());
            product.setBasePrice(productDto.getBasePrice());
            product.setBrandId(brand);
            product.setCategoryId(category);
            product=productRepo.save(product);
            return product;
        }
        catch(Exception e){
            throw new NullPointerException("Value not found");
        }
    }

    /**
     * Getting all the properties stored in the database
     */
    @Override
    public List<Product> getProduct() {

        return productRepo.findAll();
    }

    /**
     * Getting products by particular id
     */

    @Override
    public Product getProductById(long id) {
        Product product = productRepo.findById(id).get();
        return product;
    }

    /**
     *
     * Getting Brand name of a particular product
     */

    @Override
    public BrandProductDto getProductBrand(long id) {
        try{
            BrandProductDto brandProductDto=new BrandProductDto();
            Product product = productRepo.findById(id).get();
            brandProductDto.setProductName(product.getProductName());
            brandProductDto.setBasePrice(product.getBasePrice());
            brandProductDto.setMfDate(product.getMfDate());
            Brand brand=brandRepository.findById(product.getBrandId().getBrandId()).get();
            if(Objects.isNull(brand)) {
                throw new NullPointerException("Brand not Found");
            }
            brandProductDto.setBrandName(brand.getBrandName());
            return brandProductDto;
        }
        catch (Exception e){
            throw e;
        }

    }

    /**
     *
     * Getting a category type of particular product
     */

    @Override
    public CategoryProductDto getProductCategory(long id) {
        try{
            CategoryProductDto categoryProductDto=new CategoryProductDto();
            Product product = productRepo.findById(id).get();
            categoryProductDto.setProductName(product.getProductName());
            categoryProductDto.setBasePrice(product.getBasePrice());
            categoryProductDto.setMfDate(product.getMfDate());
            Category category =categoryRepository.findById(product.getBrandId().getBrandId()).get();
            if(Objects.isNull(category)) {
                throw new NullPointerException("Category not Found");
            }
            categoryProductDto.setCategoryName(category.getCategoryName());
            return categoryProductDto;
        }
        catch (Exception e){
            throw  e;
        }

    }

    /**
     * updating a particular product in the database using id
     */

    @Override
    public Product updateProduct(ProductDto productDto, Long id) {

        Product product = productRepo.findById(id).get();
        product.setProductName(productDto.getProductName());
        product.setMfDate(productDto.getMfDate());
        product.setBasePrice(productDto.getBasePrice());
        Product updatedProduct=productRepo.save(product);
        return updatedProduct;
    }

    /**
     * deleting a product from the database by id
     */

    @Override
    public void deleteProduct(Long id) {
        productRepo.deleteById(id); ;

    }

}
