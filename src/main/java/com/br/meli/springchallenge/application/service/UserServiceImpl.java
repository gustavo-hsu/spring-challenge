package com.br.meli.springchallenge.application.service;

import com.br.meli.springchallenge.application.validator.UserValidator;
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
    private UserValidator userValidator;

    public UserServiceImpl(UserRepository userRepository, FollowerRepository followerRepository, UserValidator userValidator) {
        this.userRepository = userRepository;
        this.followerRepository = followerRepository;
        this.userValidator = userValidator;
    }

    public void follow(int userId, int userIdToFollow) throws BadRequestApiException {
        userValidator.validate(userId, userIdToFollow);

        User follower = userRepository.findById(userId).get();
        User following =  userRepository.findById(userIdToFollow).get();

        followerRepository.save(new Follower(following, follower));
    }

    public void unfollow(int userId, int userIdToFollow) {
        followerRepository.deleteByIds(userId, userIdToFollow);
    }

    public FollowerCountResponse getNumberOfFollowers(int userId) throws BadRequestApiException {
        User user = userRepository.findById(userId).orElse(null);
        userValidator.validate(user);
        return new FollowerCountResponse(user.getId(), user.getName(), user.countFollowers());
    }

    public FollowerListResponse getFollowerList(int userId, String order) throws BadRequestApiException {
        User user =  userRepository.findById(userId).orElse(null);
        userValidator.validateSeller(user);
        user.setFollowersOrderByName(order);
        return new FollowerListResponse(user);
    }

    public FollowingListResponse getFollowingList(int userId, String order) throws BadRequestApiException {
        User user =  userRepository.findById(userId).orElse(null);
        userValidator.validate(user);
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
