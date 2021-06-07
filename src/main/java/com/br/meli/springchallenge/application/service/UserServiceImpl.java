package com.br.meli.springchallenge.application.service;

import com.br.meli.springchallenge.application.validator.FollowValidator;
import com.br.meli.springchallenge.dto.response.FollowerCountResponse;
import com.br.meli.springchallenge.dto.response.FollowerListResponse;
import com.br.meli.springchallenge.domain.model.Follower;
import com.br.meli.springchallenge.domain.model.User;
import com.br.meli.springchallenge.domain.repository.FollowerRepository;
import com.br.meli.springchallenge.domain.repository.UserRepository;
import com.br.meli.springchallenge.dto.response.FollowingListResponse;
import com.br.meli.springchallenge.exceptions.BadRequestApiException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private FollowerRepository followerRepository;
    private FollowValidator followValidator;

    public UserServiceImpl(UserRepository userRepository, FollowerRepository followerRepository, FollowValidator followValidator) {
        this.userRepository = userRepository;
        this.followerRepository = followerRepository;
        this.followValidator = followValidator;
    }

    public void follow(int userId, int userIdToFollow) throws BadRequestApiException {
        followValidator.validate(userId, userIdToFollow);

        User follower = userRepository.findById(userId).get();
        User following =  userRepository.findById(userIdToFollow).get();

        followerRepository.save(new Follower(following, follower));
    }

    public void unfollow(int userId, int userIdToFollow) {
        followerRepository.deleteByIds(userId, userIdToFollow);
    }

    public FollowerCountResponse getNumberOfFollowers(int userId) {
        User user = userRepository.findById(userId).get();
        return new FollowerCountResponse(user.getId(), user.getName(), user.countFollowers());
    }

    public FollowerListResponse getFollowerList(int userId, String order) {
        User user =  userRepository.findById(userId).get();
        user.setFollowersOrderByName(order);
        return new FollowerListResponse(user);
    }

    public FollowingListResponse getFollowingList(int userId, String order) {
        User user =  userRepository.findById(userId).get();
        user.setFollowingOrderByName(order);
        return new FollowingListResponse(user);
    }

    public User create(User user) {
        return userRepository.save(user);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }
}