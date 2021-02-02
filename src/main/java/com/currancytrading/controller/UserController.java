package com.currancytrading.controller;

import com.currancytrading.entity.User;
import com.currancytrading.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/getuser", method = RequestMethod.GET)
    public ResponseEntity<?> getUsers(){
        return ResponseEntity.ok("userRepository.findAll()");
    }

    @RequestMapping(value = "/getusers", method = RequestMethod.GET)
    public ArrayList<User> getUserss(){
        return (ArrayList<User>) userRepository.findAll();
    }

}
