package com.br.meli.springchallenge.application.validator;

import com.br.meli.springchallenge.application.validator.FollowValidator;
import com.br.meli.springchallenge.domain.repository.FollowerRepository;
import com.br.meli.springchallenge.domain.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class FollowValidatorImpl implements FollowValidator {
    private FollowerRepository followerRepository;
    private UserRepository userRepository;

    public FollowValidatorImpl(FollowerRepository followerRepository, UserRepository userRepository) {
        this.followerRepository = followerRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void validate(int userId, int userIdToFollow) {
        if(userId == userIdToFollow) {
            throw new IllegalArgumentException("A user can not follow himself.");
        }

        if(userRepository.findById(userId).isEmpty()) {
            throw new IllegalArgumentException("User with id " + userId + " not found.");
        }

        if(userRepository.findById(userIdToFollow).isEmpty()) {
            throw new IllegalArgumentException("User with id " + userIdToFollow + " not found.");
        }

        if(followerRepository.findByIds(userId, userIdToFollow) != null) {
            throw new IllegalArgumentException("User already follow this seller");
        }
    }
}
