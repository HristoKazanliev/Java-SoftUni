package com.dictionaryapp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

@EnableScheduling
@Configuration
public class Scheduler {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    //every 10 seconds
    @Scheduled(cron = "*/10 * * * * *")
    public void cronSchedule() {
        System.out.println("The time is now " + dateFormat.format(new Date()));
    }
}
