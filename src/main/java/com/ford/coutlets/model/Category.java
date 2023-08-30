package com.ford.coutlets.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="category")
public class Category {

    @Id
    @Column(name="category_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long categoryId;

    @Column(name="category_name")
    private String categoryName;




}
