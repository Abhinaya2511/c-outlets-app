package com.ford.coutlets.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class CategoryDto {
    private long categoryId;
    @NotNull(message = "category name shouldn't be null")
    @Size(min = 1, max = 10, message = "The length of category name must be between 1 and 10 characters")
    private String categoryName;

}
