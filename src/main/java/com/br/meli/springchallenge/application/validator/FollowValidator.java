package com.br.meli.springchallenge.application.validator;

import com.br.meli.springchallenge.exceptions.BadRequestApiException;

public interface FollowValidator {
    void validate(int userId, int userIdToFollow) throws BadRequestApiException;
}
