package com.ford.coutlets.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class BrandDto {
    private int brandId;
    @NotNull(message = "Brand name shouldn't be null")
    @Size(min = 1, max = 15, message = "The length of brand name must be between 1 and 15 characters")
    private String brandName;

}
