package com.currancytrading.controller;

import com.currancytrading.documents.User;
import com.currancytrading.models.AuthenticationRequest;
import com.currancytrading.models.AuthenticationResponse;
import com.currancytrading.repository.UserRepository;
import com.currancytrading.service.MyUserDetailsService;
import com.currancytrading.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Optional;

@RestController
public class CurrencyTradingController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtTokenUtil;

    @Autowired
    private MyUserDetailsService userDetailsService;

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

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public ResponseEntity<?> addUser(@RequestBody User newUser){
        return ResponseEntity.ok(userRepository.save(newUser));
    }

    @RequestMapping(value = "/findUser", method = RequestMethod.POST)
    public ResponseEntity<?> findUser(@RequestBody User newUser){
        return ResponseEntity.ok(userRepository.findByuserNameAndPassword(newUser.getUserName(),newUser.getPassword()));
    }

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
        }
        catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }


        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());

        final String jwt = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

}
