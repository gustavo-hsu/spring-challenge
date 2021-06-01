package com.br.meli.springchallenge.boundaries.controller;

import com.br.meli.springchallenge.application.UserService;
import com.br.meli.springchallenge.boundaries.dto.FollowerCountResponse;
import com.br.meli.springchallenge.boundaries.dto.FollowerListResponse;
import com.br.meli.springchallenge.model.User;
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
    public ResponseEntity follow(@PathVariable int userId, @PathVariable int userIdToFollow){
        userService.follow(userId, userIdToFollow);

        //falta retornar bad request quando dá errado
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/{userId}/followers/count")
    public ResponseEntity getNumberOfFollowers(@PathVariable int userId){
        FollowerCountResponse numberOfFollowers = userService.getNumberOfFollowers(userId);

        return new ResponseEntity(numberOfFollowers, HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/list")
    public ResponseEntity getFollowersList(@PathVariable int userId){
        FollowerListResponse followerList = userService.getFollowerList(userId);

        return new ResponseEntity(followerList, HttpStatus.OK);
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
