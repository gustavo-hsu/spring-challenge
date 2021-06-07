package com.br.meli.springchallenge.application.validator;

import com.br.meli.springchallenge.domain.model.User;
import com.br.meli.springchallenge.exceptions.BadRequestApiException;

public interface UserValidator {
    void validate(int userId, int userIdToFollow) throws BadRequestApiException;

    void validateSeller(User user) throws BadRequestApiException;

    void validate(User user) throws BadRequestApiException;
}
