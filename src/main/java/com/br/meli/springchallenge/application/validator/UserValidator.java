package com.br.meli.springchallenge.application.validator;

import com.br.meli.springchallenge.domain.model.User;
import com.br.meli.springchallenge.exceptions.ApiException;
import com.br.meli.springchallenge.exceptions.BadRequestApiException;

public interface UserValidator {
    void validate(int userId, int userIdToFollow) throws ApiException;

    void validateSeller(User user) throws ApiException;

    void validate(User user) throws ApiException;
}
