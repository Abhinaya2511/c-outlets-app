package com.ford.coutlets.serviceImpl;

import com.ford.coutlets.dto.CategoryDto;
import com.ford.coutlets.model.Category;
import com.ford.coutlets.repository.CategoryRepository;
import com.ford.coutlets.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;
    @Override
    public Category saveCategory(CategoryDto categoryDto) {
        Category category=new Category();
        category.setCategoryName(categoryDto.getCategoryName());
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> getCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public void deleteCategory(Long categoryId) {

        categoryRepository.deleteById(categoryId );

    }
}
