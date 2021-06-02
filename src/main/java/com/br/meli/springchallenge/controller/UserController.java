package com.br.meli.springchallenge.controller;

import com.br.meli.springchallenge.application.service.UserService;
import com.br.meli.springchallenge.dto.FollowerCountResponse;
import com.br.meli.springchallenge.dto.FollowerListResponse;
import com.br.meli.springchallenge.domain.model.User;
import com.br.meli.springchallenge.dto.FollowingListResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity follow(@PathVariable int userId, @PathVariable int userIdToFollow) throws Exception {
        userService.follow(userId, userIdToFollow);

        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/{userId}/unfollow/{userIdToFollow}")
    public ResponseEntity unfollow(@PathVariable int userId, @PathVariable int userIdToFollow) throws Exception {
        userService.unfollow(userId, userIdToFollow);

        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/count")
    public ResponseEntity getNumberOfFollowers(@PathVariable int userId){
        FollowerCountResponse numberOfFollowers = userService.getNumberOfFollowers(userId);

        return new ResponseEntity(numberOfFollowers, HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/list")
    public ResponseEntity getFollowersList(@PathVariable int userId){
        FollowerListResponse followerList = userService.getFollowerList(userId);

        return new ResponseEntity(followerList, HttpStatus.OK);
    }

    @GetMapping("/{userId}/followed/list")
    public ResponseEntity getFollowedList(@PathVariable int userId){
        FollowingListResponse followedList = userService.getFollowingList(userId);

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
