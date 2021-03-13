package com.currancytrading.controller;

import com.currancytrading.documents.User;
import com.currancytrading.models.AuthenticationRequest;
import com.currancytrading.models.AuthenticationResponse;
import com.currancytrading.service.MyUserDetailsService;
import com.currancytrading.service.UserService;
import com.currancytrading.utils.JwtUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
@RequestMapping("api/currency-trading")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtTokenUtil;

    @Autowired
    private MyUserDetailsService userDetailsService;

    Logger logger = LoggerFactory.getLogger(UserController.class);


    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest)
            throws Exception {

        try {
            logger.trace("Authenticating User is in progress - createAuthenticationToken()");
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
        }
        catch (BadCredentialsException e) {
            logger.error("User Authentication failed due to Incorrect username or password- createAuthenticationToken()");
            throw new Exception("Incorrect username or password", e);
        }


        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());

        final String jwt = jwtTokenUtil.generateToken(userDetails);
        logger.trace("Authenticating User is Successfull - createAuthenticationToken()");
        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

    @RequestMapping(value = "/getUser", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getUsers(){

        logger.trace("Get All User from DB - getUsers()");

        return ResponseEntity.ok(userService.getAllUser());
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addUser(@RequestBody User newUser){
        logger.trace("User Sign up is in progress - addUser()");
        return ResponseEntity.ok(userService.addUser(newUser));
    }

    @RequestMapping(value = "/findUser", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findUser(@RequestBody User newUser){
        logger.trace("Getting User Info from DB - findUser()");
        return ResponseEntity.ok(userService.findByUserNameAndPassword(newUser));
    }

    @RequestMapping(value = "/resetPassword", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> resetPassword(@RequestBody User newUser){
        logger.trace("Password Reset is in Progress -  resetPassword()");
        return ResponseEntity.ok(userService.updateUserPassword(newUser));
    }

}
