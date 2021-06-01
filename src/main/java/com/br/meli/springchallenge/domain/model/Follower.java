package com.br.meli.springchallenge.domain.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="follower")
@NoArgsConstructor
public class Follower {
    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn(name="from_user_id")
    private User follower;

    @ManyToOne
    @JoinColumn(name="to_user_id")
    private User following;

    public Follower(User follower, User following) {
        this.follower = follower;
        this.following = following;
    }

    public int getFollowerId() {
        return this.follower.getId();
    }

    public String getFollowerName() {
        return this.follower.getName();
    }

    public int getFollowingId() {
        return this.following.getId();
    }

    public String getFollowingName() {
        return this.following.getName();
    }
}