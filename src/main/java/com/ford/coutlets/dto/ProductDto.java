package com.ford.coutlets.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.Date;
@Data
public class ProductDto {
    private long id;
    @NotNull(message = "Product Name should not be null")
    @Size(min = 1, max = 15, message = "The length of Product Name must be between 1 and 15 characters")
    private String productName;
    private Timestamp mfDate;
    private int basePrice;
    private long brandId;
    private long categoryId;

}
