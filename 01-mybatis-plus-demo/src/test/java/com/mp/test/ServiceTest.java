package com.mp.test;


import com.mp.MpApplication;
import com.mp.pojo.User;
import com.mp.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = MpApplication.class)
@RunWith(SpringRunner.class)
public class ServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void demo() {
        User user = userService.getById(3);
        System.out.println(user);
         /*BaseMapper<User> baseMapper = userService.getBaseMapper();
         baseMapper.selectById()*/
    }
}
