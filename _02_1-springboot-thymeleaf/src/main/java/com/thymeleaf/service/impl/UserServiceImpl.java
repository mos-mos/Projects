package com.thymeleaf.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.thymeleaf.mapper.UserMapper;
import com.thymeleaf.model.User;
import com.thymeleaf.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
