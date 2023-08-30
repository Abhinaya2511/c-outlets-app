package com.ford.coutlets.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

@Data
@Entity
@Table(name="brands")
public class Brand {

    @Id
    @Column(name="brand_id")
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private long brandId;

    @Column(name = "brand_name")
    private String brandName;

}
