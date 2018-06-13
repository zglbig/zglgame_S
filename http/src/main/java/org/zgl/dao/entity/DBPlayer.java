package org.zgl.dao.entity;

import java.sql.Date;

/**
 * @作者： big
 * @创建时间： 2018/6/13
 * @文件描述：
 */
public class DBPlayer {
    private Integer id;
    private Long uid;
    private String account;
    private String password;
    private String userName;
    private String headIcon;
    private Date createTime;
    private Date lastEditTime;
    private String weath;
    private String task;
    private DBWeath dbWeath;
    private DBTask dbTask;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getHeadIcon() {
        return headIcon;
    }

    public void setHeadIcon(String headIcon) {
        this.headIcon = headIcon;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastEditTime() {
        return lastEditTime;
    }

    public void setLastEditTime(Date lastEditTime) {
        this.lastEditTime = lastEditTime;
    }

    public String getWeath() {
        return weath;
    }

    public void setWeath(String weath) {
        this.weath = weath;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public DBWeath getDbWeath() {
        if(dbWeath == null && weath != null && !weath.equals("") && !weath.equals("{}")){
//            dbWeath = JSON.toObject(weath,DBWeath.class);
        }
        return dbWeath;
    }


    public DBTask getDbTask() {
        if(dbTask == null && task != null && !task.equals("") && !task.equals("{}")){
//            dbWeath = JSON.toObject(weath,DBWeath.class);
        }
        return dbTask;
    }


    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "DBPlayer{" +
                "id=" + id +
                ", uid=" + uid +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", userName='" + userName + '\'' +
                ", headIcon='" + headIcon + '\'' +
                ", createTime=" + createTime +
                ", lastEditTime=" + lastEditTime +
                ", weath='" + weath + '\'' +
                ", task='" + task + '\'' +
                ", dbWeath=" + dbWeath +
                ", dbTask=" + dbTask +
                '}';
    }
}
