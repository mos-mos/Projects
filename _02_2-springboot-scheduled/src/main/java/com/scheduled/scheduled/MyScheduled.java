package com.scheduled.scheduled;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.Date;

@Component
public class MyScheduled {
    @Scheduled(cron = "0-10/2 * * * * ?")
    public void scheduled(){
        System.out.println("Scheduled............"+new Date());
    }
}
