package com.br.meli.springchallenge.application;

import com.br.meli.springchallenge.boundaries.dto.FollowerCountResponse;
import com.br.meli.springchallenge.boundaries.dto.FollowerListResponse;
import com.br.meli.springchallenge.model.Follower;
import com.br.meli.springchallenge.model.User;
import com.br.meli.springchallenge.repository.FollowerRepository;
import com.br.meli.springchallenge.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserRepository userRepository;
    private com.br.meli.springchallenge.repository.FollowerRepository followerRepository;

    public UserService(UserRepository userRepository, FollowerRepository followerRepository) {
        this.userRepository = userRepository;
        this.followerRepository = followerRepository;
    }

    public void follow(int userId, int userIdToFollow) {
        User follower = userRepository.findById(userId).get();
        User toFollow =  userRepository.findById(userIdToFollow).get();

        //usuario consegue seguir ele mesmo
        if(followerRepository.findByIds(userId, userIdToFollow) != null) {
            return;
        }

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

    public List<User> getAll() {
        return userRepository.findAll();
    }
}
