package com.eclouw.SpringSecurityExample.service;

import com.eclouw.SpringSecurityExample.model.UserPrincipal;
import com.eclouw.SpringSecurityExample.model.Users;
import com.eclouw.SpringSecurityExample.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Users user = repo.findByUsername(username);

        if (user == null){
            System.out.println("User not found");
            throw new UsernameNotFoundException("User not found");
        }
            System.out.println("Password:");
            System.out.println(user);


        return new UserPrincipal(user);

    }
}
