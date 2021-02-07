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
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        List<com.currancytrading.documents.User> users =userRepository.findByuserName(userName);

        User newUser = null;
        if(users != null && users.stream().count() > 0) {
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
