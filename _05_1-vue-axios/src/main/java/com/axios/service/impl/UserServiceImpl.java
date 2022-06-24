package com.axios.service.impl;



import com.axios.mapper.UserMapper;
import com.axios.model.User;
import com.axios.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
