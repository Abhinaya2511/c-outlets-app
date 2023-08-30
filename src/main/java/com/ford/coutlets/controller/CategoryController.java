package com.ford.coutlets.controller;

import com.ford.coutlets.dto.CategoryDto;
import com.ford.coutlets.model.Category;
import com.ford.coutlets.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("/category")
    public List<Category> getallCategory(){
        return categoryService.getCategory();
    }

    @PostMapping("/category")
    public String saveCategory(@Valid @RequestBody CategoryDto categoryDto){
        categoryService.saveCategory(categoryDto);
        return "Category Saved Successfully";

    }
    @DeleteMapping("/category/{categoryId}")
    public String deleteCategory(@PathVariable long categoryId){
        categoryService.deleteCategory(categoryId);
        return "Category Deleted Successfully";
        }
    }

