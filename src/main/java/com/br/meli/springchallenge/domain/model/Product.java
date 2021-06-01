package com.br.meli.springchallenge.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="product")
@Setter
@Getter
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue
    private int id;
    private String productName;
    private String type;
    private String brand;
    private String color;
    private String notes;
    private int category;
    private Double price;

    public Product(int id, String productName, String type, String brand, String color, String notes, int category, Double price) {
        this.id = id;
        this.productName = productName;
        this.type = type;
        this.brand = brand;
        this.color = color;
        this.notes = notes;
        this.category = category;
        this.price = price;
    }
}