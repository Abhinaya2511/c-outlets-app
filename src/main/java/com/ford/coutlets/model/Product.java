package com.ford.coutlets.model;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;


@Data
@Entity
@Table(name="Products")
public class Product {

    @Id
    @Column(name="product_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(name = "product_name")
    @NotNull(message = "Product Name should not be null")
    @Size(min = 1, max = 15, message = "The length of Product Name must be between 1 and 15 characters")
    private String productName;

    @Column(name = "mf_date")
    private Timestamp mfDate;

    @Column(name = "base_price")
    private int basePrice;


    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name="brand_id")
    private Brand brandId;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name="category_id")
    private Category categoryId;

}


