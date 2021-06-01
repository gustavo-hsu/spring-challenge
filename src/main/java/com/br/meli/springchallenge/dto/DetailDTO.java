package com.br.meli.springchallenge.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DetailDTO {
    private int productId;
    private String productName;
    private String type;
    private String brand;
    private String color;
    private String notes;
}
