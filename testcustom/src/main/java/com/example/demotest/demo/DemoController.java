package com.example.demotest.demo;

import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author LF--liufang@maxrocky.com
 * @date 2018/4/16 15:50
 * @desc 定时任务
 */
@Component
@EnableScheduling
public class DemoController implements SchedulingConfigurer {
    //时间表达式  每2秒执行一次
    private String cron = "0/2 * * * * ?";

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        scheduledTaskRegistrar.addTriggerTask(new Runnable() {
            @Override
            public void run() {
                //任务逻辑
                System.out.println("---------------start-------------------");
                System.out.println("动态修改定时任务参数，时间表达式cron为：" + cron);
                System.out.println("当前时间为：" + sdf.format(new Date()));
                System.out.println("----------------end--------------------");
            }
        }, new Trigger() {
            @Override
            public Date nextExecutionTime(TriggerContext triggerContext) {
                CronTrigger cronTrigger = new CronTrigger(cron);
                Date nextExecDate = cronTrigger.nextExecutionTime(triggerContext);
                return nextExecDate;
            }
        });
    }

    public void setCron(String cron) {
        this.cron = cron;
    }

}

