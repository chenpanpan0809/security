package com.panpan.security.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.panpan.security.entity.User;
import com.panpan.security.mapper.UserMapper;
import com.panpan.security.service.UserDbService;
import org.springframework.stereotype.Service;

@Service
public class UserDbServiceImpl extends ServiceImpl<UserMapper, User> implements UserDbService {
}
