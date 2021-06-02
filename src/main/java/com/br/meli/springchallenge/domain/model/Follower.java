package com.br.meli.springchallenge.domain.model;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="follower")
@NoArgsConstructor
public class Follower {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name="following_user_id")
    private User following;

    @ManyToOne
    @JoinColumn(name="follower_user_id")
    private User follower;

    public Follower(User following, User follower) {
        this.following = following;
        this.follower = follower;
    }

    public int getFollowerId() {
        return this.following.getId();
    }

    public String getFollowerName() {
        return this.following.getName();
    }

    public int getFollowingId() {
        return this.follower.getId();
    }

    public String getFollowingName() {
        return this.follower.getName();
    }
}