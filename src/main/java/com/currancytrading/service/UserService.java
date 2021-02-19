package com.currancytrading.service;


import com.currancytrading.documents.User;
import com.currancytrading.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public Iterable<User> getAllUser(){
        return userRepository.findAll();
    }

    public ResponseEntity<?> addUser(User user){
        if(userRepository.findByuserName(user.getUserName()).iterator().hasNext()) {
            return new ResponseEntity<>(
                    "User name already present.",
                    HttpStatus.BAD_REQUEST);
        }
        else{
            //return ResponseEntity.ok(userRepository.save(user));
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
}
