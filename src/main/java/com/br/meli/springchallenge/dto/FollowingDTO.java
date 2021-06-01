package com.br.meli.springchallenge.dto;

import com.br.meli.springchallenge.domain.model.Follower;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FollowingDTO {
    private int userId;
    private String userName;

    public FollowingDTO(Follower follower) {
        this.userId = follower.getFollowingId();
        this.userName = follower.getFollowingName();
    }
}
