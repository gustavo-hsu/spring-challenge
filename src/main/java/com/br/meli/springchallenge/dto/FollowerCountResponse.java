package com.br.meli.springchallenge.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class FollowerCountResponse {
    private int userId;
    private String userName;
    private int followersCount;
}
