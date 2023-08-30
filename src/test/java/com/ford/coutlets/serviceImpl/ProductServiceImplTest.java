package com.ford.coutlets.serviceImpl;

import com.ford.coutlets.dto.ProductDto;
import com.ford.coutlets.model.Brand;
import com.ford.coutlets.model.Category;
import com.ford.coutlets.model.Product;
import com.ford.coutlets.repository.BrandRepository;
import com.ford.coutlets.repository.CategoryRepository;
import com.ford.coutlets.repository.ProductRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ContextConfiguration;

import java.sql.Timestamp;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ContextConfiguration(classes = {ProductServiceImpl.class})
@ExtendWith(MockitoExtension.class)
public class ProductServiceImplTest {

    @Mock
    ProductRepository productRepository;

    @Mock
    BrandRepository brandRepository;

    @Mock
    CategoryRepository categoryRepository;

    @InjectMocks
    ProductServiceImpl productService;

    private AutoCloseable closeable;


    @BeforeEach
    void setUp() {

        closeable = MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void tearDown() throws Exception {
        closeable.close();
    }

    /**
     *
     * method under test : {@link ProductServiceImpl#saveProduct(ProductDto)}
     */
    @Test
    @DisplayName("given product details when save products then should pass")
    public void givenProductDetails_whenSaveProducts_thenShouldPass() throws Exception {
        Brand mockBrand= new Brand();
        mockBrand.setBrandId(1L);
        mockBrand.setBrandName("Test Brand");
        Category mockCategory=new Category();
        mockCategory.setCategoryId(1L);
        mockCategory.setCategoryName("Test Category");
        ProductDto productDto = new ProductDto();
        productDto.setProductName("Hair oil");
        productDto.setMfDate(new Timestamp(12345));
        productDto.setBasePrice(200);
        productDto.setBrandId(1L); // Replace with a valid brand ID
        productDto.setCategoryId(1L);
        productDto.setId(1L);

        Product mockProduct=new Product();

        mockProduct.setProductName(productDto.getProductName());
        mockProduct.setMfDate(productDto.getMfDate());
        mockProduct.setBasePrice(productDto.getBasePrice());
        mockProduct.setBrandId(mockBrand);
        mockProduct.setCategoryId(mockCategory);
        mockProduct.setId(1L);

        when(productRepository.save(mockProduct)).thenReturn(mockProduct);
         when(brandRepository.findById(Mockito.<Long>any())).thenReturn(Optional.of(mockBrand));
        when(categoryRepository.findById(Mockito.<Long>any() )).thenReturn(Optional.of(mockCategory));
        Product saveProduct=productService.saveProduct(productDto);
        assertNotNull(saveProduct);
        verify(brandRepository,times(1)).findById(1L);
        verify(categoryRepository,times(1)).findById(1L);
        verify(productRepository,times(1)).save(mockProduct);


    }
    @Test
    @DisplayName("given product details when save products then should fail")
    public void givenProductDetails_whenSaveProducts_thenShouldFail() throws Exception {
        Brand mockBrand= mock(Brand.class);
        Category mockCategory=mock(Category.class);
        Product mockProduct=mock(Product.class);

        mockProduct.setProductName("Hair oil");
        mockProduct.setMfDate(new Timestamp(12345));
        mockProduct.setBasePrice(200);
        mockProduct.setBrandId(mockBrand);
        mockProduct.setCategoryId(mockCategory);
        mockProduct.setId(1L);
//        when(productRepository.save(any(Product.class))).thenReturn(mockProduct);
        when(brandRepository.findById(1L)).thenThrow(NullPointerException.class);
        when(categoryRepository.findById(1L)).thenThrow(NullPointerException.class);
    }
    @Test
    @DisplayName("given updated product details when save products then should pass")
    public void givenUpdatedProductDetails_whenSaveProducts_thenShouldPass(){
        Product mockProduct=mock(Product.class);
        ProductDto mockProductDto=mock(ProductDto.class);

        mockProduct.setProductName(mockProductDto.getProductName());
        mockProduct.setMfDate(mockProductDto.getMfDate());
        mockProduct.setBasePrice(mockProductDto.getBasePrice());
        mockProduct.setId(mockProductDto.getId());

    }
    @Test
    @DisplayName("given product id when delete product then should pass")
    public void givenProductId_whenDeleteProduct_thenShouldPass(){
        Product mockProduct=mock(Product.class);
        productRepository.deleteById(mockProduct.getId());
    }
    @Test
    @DisplayName("")
    public void givenProductId_whenValid_thenShouldPass(){

    }



}
