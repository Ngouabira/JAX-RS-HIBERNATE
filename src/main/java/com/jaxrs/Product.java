package com.jaxrs;

import lombok.*;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table
public class Product {
    
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private int price;
    private String description;
}
