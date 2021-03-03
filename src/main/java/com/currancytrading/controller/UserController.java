package com.currancytrading.controller;

import com.currancytrading.documents.User;
import com.currancytrading.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
@RequestMapping("api/currency-trading")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/getUser", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getUsers(){
        return ResponseEntity.ok(userService.getAllUser());
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addUser(@RequestBody User newUser){
        return ResponseEntity.ok(userService.addUser(newUser));
    }

    @RequestMapping(value = "/findUser", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findUser(@RequestBody User newUser){
        return ResponseEntity.ok(userService.findByUserNameAndPassword(newUser));
    }

    @RequestMapping(value = "/resetPassword", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> resetPassword(@RequestBody User newUser){
        return ResponseEntity.ok(userService.updateUserPassword(newUser));
    }

}
