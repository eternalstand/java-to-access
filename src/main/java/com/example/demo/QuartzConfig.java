package com.example.demo;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置定时任务
 */
@Configuration
public class QuartzConfig {

    @Bean
    public JobDetail jobDetail() {
        JobDetail jobDetail = JobBuilder.newJob(TestJob.class)
                .withIdentity("testJob")
                .storeDurably()
                .build();

        return jobDetail;
    }

    @Bean
    public Trigger trigger() {
        // 触发器 定义多长时间触发 JobDetail
        Trigger trigger = org.quartz.TriggerBuilder.newTrigger()
                .forJob(jobDetail())
                .withIdentity("testTrigger")
                .withSchedule(CronScheduleBuilder.cronSchedule("0 0/1 * * * ?"))
                .startNow()
                .build();
        return trigger;
    }

}
