package com.batch;

import com.batch.mapper.UserMapper;
import com.batch.model.NewUser;
import com.batch.utils.UserUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @BelongsProject: ideaproject
 * @BelongsPackage: com.batch
 * @Author: mos
 * @CreateTime: 2022-07-07  11:45
 * @Description: 测试
 * @Version: 1.0
 */
@SpringBootTest(classes = {BatchApplication.class})
@RunWith(SpringRunner.class)
public class Demo {
    @Autowired
    private UserMapper userMapper;
    @Test
    public void demo(){
        userMapper.insertBatch(UserUtil.userList(5000));

    }

    @Test
    public void demo1() {
        // 创建三个user
        NewUser user1 = new NewUser("111", 18, 180);
        NewUser user2 = new NewUser("222", 18, 175);
        NewUser user3 = new NewUser("333", 19, 170);
        NewUser user4 = new NewUser("444", 20, 172);
        NewUser user5 = new NewUser("555", 21, 172);
        NewUser user6 = new NewUser("666", 22, 173);
        NewUser user7 = new NewUser("777", 23, 174);
        NewUser user8 = new NewUser("888", 24, 175);

        List<NewUser> userList = Stream.of(user1, user2, user3,user4,user5,user6,user7,user8).collect(Collectors.toList());

    }
}
