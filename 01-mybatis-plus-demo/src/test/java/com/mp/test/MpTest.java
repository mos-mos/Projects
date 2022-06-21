package com.mp.test;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mp.MpApplication;
import com.mp.mapper.UserMapper;
import com.mp.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

//@SpringBootApplication
@SpringBootTest(classes = {MpApplication.class})
@RunWith(SpringRunner.class)
public class MpTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void test() {
        List<User> list = userMapper.selectList(null);

        list.stream().forEach(m -> {
            System.out.println(m);
        });
//        for (User userMapper : list) {
//            System.out.println(userMapper);
//        }
    }

    @Test
    public void test02() {
        User user = userMapper.selectById(1);
        System.out.println(user);
    }

    @Test
    public void test03() {
        User user = new User();
        user.setUserName("aabb");
        user.setPassword("1234");
        user.setName("张三");
        user.setAge(22);
        user.setEmail("sada@123.com");
        int insert = userMapper.insert(user);
        System.out.println(insert);
    }
    @Test
    public void test04() {
        //条件构造器
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("name","张三");
        //eq   equal    等于   第一个参数：字段名称  第二个参数：值
//        queryWrapper.eq("age",18);
        //greater than  大于
         queryWrapper.gt("age",23).lt("age", 30);
        //less than  小于
        // queryWrapper.lt("age", 30);
        //测试CRUD

        List<User> users = userMapper.selectList(queryWrapper);
        users.stream().forEach(m -> {System.out.println(m);});

//        queryWrapper.like("user_name","靓仔");
        //  queryWrapper.likeLeft("user_name","靓");
        // queryWrapper.orderBy(true,true,"age","id");
        //queryWrapper.orderByAsc("age");  //升序
        // queryWrapper.orderByDesc("age");  //升序
//        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
//        lambdaQueryWrapper.eq(User::getAge,18);  //获取对应的属性
//        List<User> list = userMapper.selectList(lambdaQueryWrapper);
        //list.stream().forEach(o-> System.out.println(o));
//        for (User u : list) {
//            System.out.println(u);
//        }
    }
}
