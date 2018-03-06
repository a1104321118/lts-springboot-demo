package com.pingpongx.tasktracker.commiter;

import com.github.ltsopensource.core.domain.Job;
import com.github.ltsopensource.jobclient.JobClient;
import com.github.ltsopensource.jobclient.domain.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by huangrui on 2018/3/6.
 *
 * 任务提交者
 */
@Component
public class JobCommiter {

    @Autowired
    JobClient jobClient;

    @PostConstruct
    public void init(){
        System.out.println(111111);
        submitCronJob("job1");
        submitCronJob("job2");
    }


    private void submitCronJob(String jobKey) {
        Job job = new Job();
        job.setParam("jobKey", jobKey); //通过自定义的jobkey 来表示不同任务
        job.setTaskId("task_" + jobKey);
        job.setTaskTrackerNodeGroup("test_trade_TaskTracker");      // 执行要执行该任务的taskTracker的节点组名称
        job.setNeedFeedback(true);// 配合handler 使用
        job.setReplaceOnExist(false);        // 当任务队列中存在这个任务的时候，是否替换更新
        job.setCronExpression("0 0/1 * * * ?");
        Response response = jobClient.submitJob(job);
        System.out.println(response);
    }
}
