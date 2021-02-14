package com.currancytrading.controller;

import com.currancytrading.documents.User;
import com.currancytrading.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin
@RestController
@RequestMapping("api/currency-trading")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public ResponseEntity<?> getHello(){
        String displayString = "Welcome Couch bases";
        return ResponseEntity.ok(displayString);
    }

    @RequestMapping(value = "/getUser", method = RequestMethod.GET)
    public ResponseEntity<?> getUsers(){
        Iterable<User> list = new ArrayList<User>();
        list = userRepository.findAll();
        return ResponseEntity.ok(userRepository.findAll());
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public ResponseEntity<?> addUser(@RequestBody User newUser){
        return ResponseEntity.ok(userRepository.save(newUser));
    }

    @RequestMapping(value = "/findUser", method = RequestMethod.POST)
    public ResponseEntity<?> findUser(@RequestBody User newUser){
        return ResponseEntity.ok(userRepository.findByuserNameAndPassword(newUser.getUserName(),newUser.getPassword()));
    }

}
