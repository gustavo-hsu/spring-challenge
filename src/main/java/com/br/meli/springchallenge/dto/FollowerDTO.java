package com.br.meli.springchallenge.dto;

import com.br.meli.springchallenge.domain.model.Follower;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FollowerDTO {
    private int userId;
    private String userName;

    public FollowerDTO(Follower follower) {
        this.userId = follower.getFollowerId();
        this.userName = follower.getFollowerName();
    }
}
