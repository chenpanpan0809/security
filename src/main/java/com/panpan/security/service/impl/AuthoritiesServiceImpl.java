package com.panpan.security.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.panpan.security.entity.Authorities;
import com.panpan.security.mapper.AuthorititesMapper;
import com.panpan.security.service.AuthoritiesService;
import org.springframework.stereotype.Service;

@Service
public class AuthoritiesServiceImpl extends ServiceImpl<AuthorititesMapper, Authorities> implements AuthoritiesService {
}
