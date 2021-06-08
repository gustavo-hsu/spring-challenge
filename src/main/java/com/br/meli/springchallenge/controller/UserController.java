package com.br.meli.springchallenge.controller;

import com.br.meli.springchallenge.application.service.UserService;
import com.br.meli.springchallenge.dto.response.FollowerCountResponse;
import com.br.meli.springchallenge.dto.response.FollowerListResponse;
import com.br.meli.springchallenge.domain.model.User;
import com.br.meli.springchallenge.dto.response.FollowingListResponse;
import com.br.meli.springchallenge.exceptions.ApiException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity follow(@PathVariable int userId, @PathVariable int userIdToFollow) throws ApiException {
        userService.follow(userId, userIdToFollow);

        return new ResponseEntity("Successfully followed!", HttpStatus.OK);
    }

    @PostMapping("/{userId}/unfollow/{userIdToFollow}")
    public ResponseEntity unfollow(@PathVariable int userId, @PathVariable int userIdToFollow) throws ApiException {
        userService.unfollow(userId, userIdToFollow);

        return new ResponseEntity("Successfully unfollowed!", HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/count")
    public ResponseEntity getNumberOfFollowers(@PathVariable int userId) throws ApiException {
        FollowerCountResponse numberOfFollowers = userService.getNumberOfFollowers(userId);

        return new ResponseEntity(numberOfFollowers, HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/list")
    public ResponseEntity getFollowersList(@PathVariable int userId, @RequestParam(required = false) String order) throws ApiException {
        FollowerListResponse followerList = userService.getFollowerList(userId, order);

        return new ResponseEntity(followerList, HttpStatus.OK);
    }

    @GetMapping("/{userId}/followed/list")
    public ResponseEntity getFollowedList(@PathVariable int userId, @RequestParam(required = false) String order) throws ApiException {
        FollowingListResponse followedList = userService.getFollowingList(userId, order);

        return new ResponseEntity(followedList, HttpStatus.OK);
    }

    @PostMapping
    public User create(@RequestBody User user){
        return userService.create(user);
    }

    @GetMapping("/getAll")
    public ResponseEntity getAll(){
        return new ResponseEntity(userService.getAll(), HttpStatus.OK);
    }
}
