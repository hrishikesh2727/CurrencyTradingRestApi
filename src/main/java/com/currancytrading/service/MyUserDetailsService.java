package com.currancytrading.service;

import com.currancytrading.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        com.currancytrading.documents.User userObj = new com.currancytrading.documents.User();
        userObj.setUserName(userName);
        Iterable<com.currancytrading.documents.User> users =userService.findByUserName(userObj);

        User newUser = null;
        if(users != null)
        {
            int i = 0;
            for (com.currancytrading.documents.User user : users) {
                if (i == 0) {
                    newUser = new User(user.getUserName(), user.getPassword(), new ArrayList<>());
                }
                i++;
            }
        }

        return newUser;
    }
}
