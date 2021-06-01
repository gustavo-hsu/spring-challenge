package com.br.meli.springchallenge.dto;

import com.br.meli.springchallenge.model.Follower;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FollowerDTO {
    private int userId;
    private String userName;

    public FollowerDTO(Follower follower) {
        this.userId = follower.getId();
        this.userName = follower.getName();
    }
}
