package com.ford.coutlets.service;

import com.ford.coutlets.dto.CategoryDto;
import com.ford.coutlets.model.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
    Category saveCategory(CategoryDto categoryDto);

    List<Category> getCategory();

    void deleteCategory(Long categoryId);

}
