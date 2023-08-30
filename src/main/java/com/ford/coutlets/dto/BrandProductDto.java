package com.ford.coutlets.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

@Data
public class BrandProductDto {
    @NotNull(message = "clientName shouldn't be null")
    @Size(min = 1, max = 100, message = "The length of clientName must be between 1 and 100 characters")
    private String productName;
    private Timestamp mfDate;
    private int basePrice;
    private String brandName;

}
