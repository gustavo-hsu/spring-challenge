package com.br.meli.springchallenge.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PromotionCountResponse {
    private int userId;
    private String userName;
    private int promoProductCount;
}
