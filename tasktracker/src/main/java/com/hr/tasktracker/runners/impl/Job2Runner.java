package com.hr.tasktracker.runners.impl;

import com.github.ltsopensource.core.domain.Action;
import com.github.ltsopensource.core.domain.Job;
import com.github.ltsopensource.tasktracker.Result;
import com.github.ltsopensource.tasktracker.runner.JobContext;
import com.hr.tasktracker.runners.JobKey;
import com.hr.tasktracker.runners.Runner;
import org.springframework.stereotype.Component;

/**
 * Created by huangrui on 2018/2/27.
 */
@Component(JobKey.JOB2)
public class Job2Runner implements Runner {

    @Override
    public Result doJob(JobContext jobContext) {
        Job job = jobContext.getJob();
        System.out.println("开始任务：job=" + job);

        return new Result(Action.EXECUTE_SUCCESS, "执行job2成功");
    }
}
