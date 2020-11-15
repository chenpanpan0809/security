package com.panpan.security.service.impl;

import com.panpan.security.service.UserService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        if (!"panpan".equals(s)){
            return null;
        }
        List<GrantedAuthority> authorities = new ArrayList<>();
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ADMIN");
        authorities.add(grantedAuthority);
        UserDetails userDetails = new User(s,"$2a$10$G4tztt1Wi.ZGF4zGJ0lKwON1Z.swvkRa8AWHNx1KftTbL7VH/KByK",authorities);
        return userDetails;
    }
}
