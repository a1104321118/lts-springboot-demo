package com.pingpongx.tasktracker.runners;

import com.github.ltsopensource.core.domain.Action;
import com.github.ltsopensource.core.domain.Job;
import com.github.ltsopensource.spring.boot.annotation.JobRunner4TaskTracker;
import com.github.ltsopensource.tasktracker.Result;
import com.github.ltsopensource.tasktracker.runner.JobContext;
import com.github.ltsopensource.tasktracker.runner.JobRunner;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * 这个类被 LTS 认为是唯一的runner
 * 通过这个类进行分发任务
 *
 */
@JobRunner4TaskTracker
public class DispatcherRunner implements JobRunner{

    @Autowired
    Map<String, Runner> runnerMap;

    @Override
    public Result run(JobContext jobContext) throws Throwable {

        //根据jobKey选择对应的Runner运行
        Job job = jobContext.getJob();
        String jobKey = job.getParam("jobKey");
        Runner runner = runnerMap.get(jobKey);

        if(null == runner){
            //throw new RuntimeException("未找到相应的任务执行者, jobKey=" + jobKey);
            return new Result(Action.EXECUTE_FAILED, "未找到相应的任务执行者, jobKey=" + jobKey);
        }

        return runner.doJob(jobContext);

    }

}

