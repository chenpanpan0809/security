package com.panpan.security.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.panpan.security.service.UserDbService;
import com.panpan.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDbService userDbService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        QueryWrapper<com.panpan.security.entity.User> queryWrapper = new QueryWrapper<com.panpan.security.entity.User>();
        queryWrapper.eq("USERNAME",userName).or().eq("PHONE",userName);
        com.panpan.security.entity.User one = userDbService.getOne(queryWrapper);
        if (one == null){
            throw new UsernameNotFoundException("用户名不存在!");
        }
        List<GrantedAuthority> authorities = new ArrayList<>();
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ADMIN");
        authorities.add(grantedAuthority);
        UserDetails userDetails = new User(one.getUsername(),one.getPassword(),authorities);
        return userDetails;
    }


}
