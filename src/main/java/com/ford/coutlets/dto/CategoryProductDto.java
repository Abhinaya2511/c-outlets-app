package com.ford.coutlets.dto;

import lombok.Data;

import java.sql.Timestamp;
@Data
public class CategoryProductDto {

    private String productName;
    private Timestamp mfDate;
    private int basePrice;
    private String categoryName;
}
