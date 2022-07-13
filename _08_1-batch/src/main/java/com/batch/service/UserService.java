package com.batch.service;

import com.batch.mapper.UserMapper;
import com.batch.utils.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @BelongsProject: ideaproject
 * @BelongsPackage: com.batch.service
 * @Author: mos
 * @CreateTime: 2022-07-07  11:03
 * @Description: TODO
 * @Version: 1.0
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ThreadPoolExecutor threadPoolExecutor;

    @Scheduled(cron = "0/20 * * * * ? ")  //每隔20秒执行
    public void insertList() {
        System.out.println("定时任务执行" + new Date());
        for (int i = 0; i < 7; i++) {
          /*  //匿名对象
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {

                }
            });*/
            //lamaba
            Thread thread = new Thread(() -> {
                //一个线程插入10万条
                for (int j = 0; j <20 ; j++) {
                    userMapper.insertBatch(UserUtil.userList(50000));
                }
            });
            threadPoolExecutor.execute(thread);

        }

    }
}
