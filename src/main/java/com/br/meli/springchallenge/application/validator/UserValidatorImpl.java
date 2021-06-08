package com.br.meli.springchallenge.application.validator;

import com.br.meli.springchallenge.domain.model.User;
import com.br.meli.springchallenge.domain.repository.FollowerRepository;
import com.br.meli.springchallenge.domain.repository.UserRepository;
import com.br.meli.springchallenge.exceptions.ApiException;
import com.br.meli.springchallenge.exceptions.BadRequestApiException;
import com.br.meli.springchallenge.exceptions.NotFoundApiException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserValidatorImpl implements UserValidator {
    private FollowerRepository followerRepository;
    private UserRepository userRepository;

    @Override
    public void validate(int userId, int userIdToFollow) throws ApiException {
        if(userId == userIdToFollow) {
            throw new BadRequestApiException("A user can not follow himself");
        }

        if(userRepository.findById(userId).isEmpty()) {
            throw new NotFoundApiException("User with id " + userId + " not found");
        }

        User userToFollow =  userRepository.findById(userIdToFollow).orElse(null);

        if(userToFollow == null) {
            throw new NotFoundApiException("User with id " + userIdToFollow + " not found");
        }

        if(!userToFollow.isSeller()) {
            throw new BadRequestApiException("Can not follow user with id " + userIdToFollow + " - he is not a seller");
        }

        if(followerRepository.findByIds(userId, userIdToFollow) != null) {
            throw new BadRequestApiException("User already follow this seller");
        }
    }

    @Override
    public void validateSeller(User user) throws ApiException {
        if(user == null) {
            throw new NotFoundApiException("User not found");
        }

        if(!user.isSeller()) {
            throw new BadRequestApiException("The user is not a seller");
        }
    }

    @Override
    public void validate(User user) throws ApiException {
        if(user == null) {
            throw new NotFoundApiException("User not found");
        }
    }

    @Override
    public void validateUnfollow(int userId, int userIdToUnfollow) throws ApiException {
        if(userId == userIdToUnfollow) {
            throw new BadRequestApiException("A user can not follow/unfollow himself");
        }

        if(userRepository.findById(userId).isEmpty()) {
            throw new NotFoundApiException("User with id " + userId + " not found");
        }

        if(userRepository.findById(userIdToUnfollow).isEmpty()) {
            throw new NotFoundApiException("User with id " + userIdToUnfollow + " not found");
        }

        if(followerRepository.findByIds(userId, userIdToUnfollow) == null) {
            throw new BadRequestApiException("The user with id" + userId +  " do not follow user with id " + userIdToUnfollow);
        }
    }
}
