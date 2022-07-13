package com.batch.utils;

import com.batch.model.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @version 1.0
 * 公众号：Java架构栈
 * @Author: 卓不凡
 */
public class UserUtil {
    private static Random random = new Random();
    public static List<User>   userList(int num){
        List<User>  list = new ArrayList<>();
        for (int i = 0; i <num ; i++) {
            User user = new User();
            user.setBirthday(new Date());
            user.setSex(random.nextInt(2));
            user.setUsername("batch"+random.nextInt(100000));
            user.setPwd("123"+random.nextInt(10000));
            list.add(user);
        }
        return list;
    }
}
