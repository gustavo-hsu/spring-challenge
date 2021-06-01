package com.br.meli.springchallenge.application;

import com.br.meli.springchallenge.dto.FollowerCountResponse;
import com.br.meli.springchallenge.dto.FollowerListResponse;
import com.br.meli.springchallenge.domain.model.Follower;
import com.br.meli.springchallenge.domain.model.User;
import com.br.meli.springchallenge.domain.repository.FollowerRepository;
import com.br.meli.springchallenge.domain.repository.UserRepository;
import com.br.meli.springchallenge.dto.FollowingListResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserRepository userRepository;
    private FollowerRepository followerRepository;
    private FollowValidator followValidator;

    public UserService(UserRepository userRepository, FollowerRepository followerRepository, FollowValidator followValidator) {
        this.userRepository = userRepository;
        this.followerRepository = followerRepository;
        this.followValidator = followValidator;
    }

    public void follow(int userId, int userIdToFollow) throws Exception {
        followValidator.validate(userId, userIdToFollow);

        User follower = userRepository.findById(userId).get();
        User toFollow =  userRepository.findById(userIdToFollow).get();

        followerRepository.save(new Follower(follower, toFollow));
    }

    public User create(User user) {
       return userRepository.save(user);
    }

    public FollowerCountResponse getNumberOfFollowers(int userId) {
        User user = userRepository.findById(userId).get();
        return new FollowerCountResponse(user.getId(), user.getName(), user.countFollowers());
    }

    public FollowerListResponse getFollowerList(int userId) {
        User user =  userRepository.findById(userId).get();

        FollowerListResponse followerList = new FollowerListResponse(user);
        return followerList;
    }

    public FollowingListResponse getFollowingList(int userId) {
        User user =  userRepository.findById(userId).get();

        FollowingListResponse followerList = new FollowingListResponse(user);
        return followerList;
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public void unfollow(int userId, int userIdToFollow) {
        //followerRepository.deleteBy(userId, userIdToFollow);
    }
}
