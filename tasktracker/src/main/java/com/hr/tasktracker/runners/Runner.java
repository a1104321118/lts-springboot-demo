package com.hr.tasktracker.runners;

import com.github.ltsopensource.tasktracker.Result;
import com.github.ltsopensource.tasktracker.runner.JobContext;

/**
 * Created by huangrui on 2018/2/27.
 *
 * 自定义的任务接口
 */
public interface Runner {

    /**
     * 开始做任务
     * @param jobContext
     */
    Result doJob(JobContext jobContext);
}
