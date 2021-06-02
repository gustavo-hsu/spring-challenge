package com.br.meli.springchallenge.dto;

import com.br.meli.springchallenge.domain.model.Follower;
import com.br.meli.springchallenge.domain.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class FollowingListResponse {
    private int userId;
    private String userName;
    private List<FollowingDTO> followed = new ArrayList<FollowingDTO>();

    public FollowingListResponse(User user) {
        this.userId = user.getId();
        this.userName = user.getName();

        for (Follower follower : user.getFollowing()) {
            this.followed.add(new FollowingDTO(follower));
        }
    }
}
