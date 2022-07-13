package com.batch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @BelongsProject: ideaproject
 * @BelongsPackage: com.batch
 * @Author: mos
 * @CreateTime: 2022-07-07  10:56
 * @Description: Application
 * @Version: 1.0
 */

@SpringBootApplication
@EnableScheduling  //开启定时任务
public class BatchApplication {
    public static void main(String[] args) {
        SpringApplication.run(BatchApplication.class,args);
    }
}
