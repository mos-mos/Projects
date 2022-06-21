package com.mp.test;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mp.MpApplication;
import com.mp.mapper.AccountMapper;
import com.mp.mapper.UserMapper;
import com.mp.pojo.Account;
import com.mp.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
    @Autowired
    private AccountMapper accountMapper;

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


//        queryWrapper.like("user_name","靓仔");
        //  queryWrapper.likeLeft("user_name","靓");
        // queryWrapper.orderBy(true,true,"age","id");
        queryWrapper.orderByAsc("age");  //升序
        // queryWrapper.orderByDesc("age");  //升序
//        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
//        lambdaQueryWrapper.eq(User::getAge,18);  //获取对应的属性
        List<User> users = userMapper.selectList(queryWrapper);
        users.stream().forEach(m -> {System.out.println(m);});

    }

    @Test
    public void test06() {
        //删除记录
        int i = userMapper.deleteById(5);
        System.out.println(i);
    }

    @Test
    public void test07() {
        //删除记录
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(3);
        int i = userMapper.deleteBatchIds(list);
        System.out.println(i);
    }

    @Test
    public void test08() {
        String replace = UUID.randomUUID().toString().replace("-", "");
        System.out.println(replace.length());
        Account account = new Account();
        account.setAddress("hz");
        account.setUsername("steek");
        int insert = accountMapper.insert(account);
        System.out.println(insert);
        System.out.println(account.getId().length());
    }

    @Test
    public void test09() {
        // limit 关键字   limit  1,5   代表的是从索引下标为1的数据，查询5条
        //条件构造器
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
//        queryWrapper.gt("age",18);
        Page<User> page  = new Page<>(2,5);

        Page<User> page1 = userMapper.selectPage(page, queryWrapper);
//        System.out.println(page1.getTotal());
//        System.out.println(page1.getRecords().size());
//        System.out.println(page1.getSize());
//        System.out.println(page1.getPages());
//        System.out.println(page1.getCurrent());
        for (User user : page1.getRecords()) {
            System.out.println(user);
        }
    }
}
