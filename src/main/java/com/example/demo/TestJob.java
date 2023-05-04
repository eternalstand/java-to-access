package com.example.demo;

import com.alibaba.fastjson.JSON;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * 定时任务
 */
@Component
public class TestJob implements Job {

    private static Log logger = LogFactory.getLog(TestJob.class);
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        List<Map<String, Object>> result = jdbcTemplate.queryForList("select * from test limit 2");

        logger.info("TestJob execute...." + JSON.toJSONString(result));
    }
}
