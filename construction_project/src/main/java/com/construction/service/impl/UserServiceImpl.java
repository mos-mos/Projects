package com.construction.service.impl;


import com.construction.mapper.UserMapper;
import com.construction.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserServiceImpl implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //校验用户名
        User userByUsername = userMapper.findUserByUsername(username);
        if (userByUsername==null){
            System.out.println("用户名或者密码错误");
            return null;
        }
        //授权
        List<GrantedAuthority> list = new ArrayList<>();
        return new org.springframework.security.core.userdetails.User(username,userByUsername.getPassword(),list);
    }
}
