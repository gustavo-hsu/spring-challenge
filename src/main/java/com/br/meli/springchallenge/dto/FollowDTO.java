package com.br.meli.springchallenge.dto;

import com.br.meli.springchallenge.domain.model.Follower;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FollowDTO {
    private int userId;
    private String userName;

    public FollowDTO(Follower follower) {
        this.userId = follower.getId();
        this.userName = follower.getName();
    }
}
