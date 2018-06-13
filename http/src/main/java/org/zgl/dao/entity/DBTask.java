package org.zgl.dao.entity;

/**
 * @作者： big
 * @创建时间： 2018/6/13
 * @文件描述：任务
 */
public class DBTask {
    private String systemTask;
    private String everyDayTask;

    public String getSystemTask() {
        return systemTask;
    }

    public void setSystemTask(String systemTask) {
        this.systemTask = systemTask;
    }

    public String getEveryDayTask() {
        return everyDayTask;
    }

    public void setEveryDayTask(String everyDayTask) {
        this.everyDayTask = everyDayTask;
    }
}
