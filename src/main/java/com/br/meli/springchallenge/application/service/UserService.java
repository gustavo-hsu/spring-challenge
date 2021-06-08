package com.br.meli.springchallenge.application.service;

import com.br.meli.springchallenge.domain.model.User;
import com.br.meli.springchallenge.dto.response.FollowerCountResponse;
import com.br.meli.springchallenge.dto.response.FollowerListResponse;
import com.br.meli.springchallenge.dto.response.FollowingListResponse;
import com.br.meli.springchallenge.exceptions.ApiException;

import java.util.List;

 public interface UserService {
     void follow(int userId, int userIdToFollow) throws ApiException;

     void unfollow(int userId, int userIdToFollow) throws ApiException;

     FollowerCountResponse getNumberOfFollowers(int userId) throws ApiException;

     FollowerListResponse getFollowerList(int userId, String order) throws ApiException;

     FollowingListResponse getFollowingList(int userId, String order) throws ApiException;

     User create(User user);

     List<User> getAll();
}
