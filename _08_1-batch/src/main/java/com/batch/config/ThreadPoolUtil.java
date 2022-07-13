package com.batch.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @BelongsProject: ideaproject
 * @BelongsPackage: com.batch.config
 * @Author: mos
 * @CreateTime: 2022-07-07  11:01
 * @Description: TODO
 * @Version: 1.0
 */
@Configuration
public class ThreadPoolUtil {
    @Bean
    public ThreadPoolExecutor threadPoolExecutor(){
        ThreadPoolExecutor threadPoolExecutor =
                new ThreadPoolExecutor(6,8,5, TimeUnit.SECONDS,new ArrayBlockingQueue<>(100));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }
}
