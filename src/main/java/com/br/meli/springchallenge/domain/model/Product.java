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
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String productName;
    private String type;
    private String brand;
    private String color;
    private String notes;
    @OneToOne
    private Category category;
    private Double price;
    private boolean hasPromo = false;
    private double discount = 0D;

    public Product(String productName, String type, String brand, String color, String notes, Double price, boolean hasPromo, double discount) {
        this.productName = productName;
        this.type = type;
        this.brand = brand;
        this.color = color;
        this.notes = notes;
        this.price = price;
        this.hasPromo = hasPromo;
        this.discount = discount;
    }
}