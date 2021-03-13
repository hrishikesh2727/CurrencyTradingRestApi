package com.currancytrading.service;


import com.currancytrading.controller.UserController;
import com.currancytrading.documents.User;
import com.currancytrading.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    Logger logger = LoggerFactory.getLogger(UserController.class);
    public Iterable<User> getAllUser(){
        return userRepository.findAll();
    }

    public ResponseEntity<?> addUser(User user){
        logger.trace("Adding USer - addUser()");
        if(userRepository.findByuserName(user.getUserName()).iterator().hasNext()) {
            logger.trace("this  User name already present.- addUser()");
            return new ResponseEntity<>(
                    "User name already present.",
                    HttpStatus.BAD_REQUEST);
        }
        else{
            //return ResponseEntity.ok(userRepository.save(user));
            logger.trace("User Added Successfully " +user + "- addUser()");
            return new ResponseEntity<>(
                    userRepository.save(user),
                    HttpStatus.ACCEPTED);
        }
    }

    public Iterable<User> findUser(User user){
        return userRepository.findByuserNameAndPassword(user.getUserName(),user.getPassword());
    }

    public Iterable<User> findDistinctUserByUserNameOrPassword(User user){
        return userRepository.findDistinctUserByUserNameOrPassword(user.getUserName(),user.getPassword());
    }

    public Iterable<User> findByUserName(User user){
        return userRepository.findByuserName(user.getUserName());
    }

    public Iterable<User> findByEmail(User user){
        return userRepository.findByEmail(user.getEmail());
    }

    public Iterable<User> findByUserNameAndPassword(User user){
        return userRepository.findByuserNameAndPassword(user.getUserName(),user.getPassword());
    }

    public ResponseEntity<?> updateUserPassword(User user){
        logger.trace("Reset User Password - updateUserPassword()");
        if(!userRepository.findByuserName(user.getUserName()).iterator().hasNext()) {
            logger.trace("Reset  Password failed- updateUserPassword()");
            return new ResponseEntity<>(
                    "Please enter the valid Email Id.",
                    HttpStatus.BAD_REQUEST);
        }
        else{
            logger.trace("Reset  Password Successfull- updateUserPassword()");
            User findUser =  userRepository.findByuserName(user.getUserName()).iterator().next();
            findUser.setPassword(user.getPassword());
            return new ResponseEntity<>(
                    userRepository.save(findUser),
                    HttpStatus.ACCEPTED);
        }
    }
}
