package com.br.meli.springchallenge.application.service;

import com.br.meli.springchallenge.domain.model.Follower;
import com.br.meli.springchallenge.domain.model.User;
import com.br.meli.springchallenge.dto.response.FollowerCountResponse;
import com.br.meli.springchallenge.dto.response.FollowerListResponse;
import com.br.meli.springchallenge.dto.response.FollowingListResponse;
import com.br.meli.springchallenge.exceptions.BadRequestApiException;

import java.util.List;

 public interface UserService {
     void follow(int userId, int userIdToFollow) throws BadRequestApiException;

     void unfollow(int userId, int userIdToFollow);

     FollowerCountResponse getNumberOfFollowers(int userId);

     FollowerListResponse getFollowerList(int userId, String order);

     FollowingListResponse getFollowingList(int userId, String order);

     User create(User user);

     List<User> getAll();
}
