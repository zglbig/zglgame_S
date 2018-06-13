package org.zgl.login.dto;

import org.zgl.IDto;
import org.zgl.dao.entity.DBPlayer;

/**
 * @作者： big
 * @创建时间： 2018/6/13
 * @文件描述：
 */
public class LoginInfoDto implements IDto {
    private int id;
    private long uid;
    private long gold;
    private long daimond;
    private long integral;
    private int vipLv;
    private String account;
    private String userName;
    private String headIcon;
    //是否有新消息
    private boolean hasNewMessage;
    //是否有任务完成
    private boolean hasTask;
    /**成长礼包*/
    private int giftBagDay;
    /**当天是否已经领取*/
    private boolean hasGiftBag;
    /**签到天数*/
    private int signInDay;
    /**今天是否签到*/
    private boolean hasSignIn;
    /**距离下次在线奖励可以领取的时间*/
    private int onlineAwardTime;
    private int onlineAwardCount;//这次是第几次领取
    /**是否已经购买摇钱树 等级大于0已经购买*/
    private int moneyTreeLv;
    /**当前使用座驾*/
    private int auto;
    /**礼物值*/
    private long giftNum;
    /**人品值*/
    private long characterNum;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public long getGold() {
        return gold;
    }

    public void setGold(long gold) {
        this.gold = gold;
    }

    public long getDaimond() {
        return daimond;
    }

    public void setDaimond(long daimond) {
        this.daimond = daimond;
    }

    public long getIntegral() {
        return integral;
    }

    public void setIntegral(long integral) {
        this.integral = integral;
    }

    public int getVipLv() {
        return vipLv;
    }

    public void setVipLv(int vipLv) {
        this.vipLv = vipLv;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
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

    public boolean isHasNewMessage() {
        return hasNewMessage;
    }

    public void setHasNewMessage(boolean hasNewMessage) {
        this.hasNewMessage = hasNewMessage;
    }

    public boolean isHasTask() {
        return hasTask;
    }

    public void setHasTask(boolean hasTask) {
        this.hasTask = hasTask;
    }

    public int getGiftBagDay() {
        return giftBagDay;
    }

    public void setGiftBagDay(int giftBagDay) {
        this.giftBagDay = giftBagDay;
    }

    public boolean isHasGiftBag() {
        return hasGiftBag;
    }

    public void setHasGiftBag(boolean hasGiftBag) {
        this.hasGiftBag = hasGiftBag;
    }

    public int getSignInDay() {
        return signInDay;
    }

    public void setSignInDay(int signInDay) {
        this.signInDay = signInDay;
    }

    public boolean isHasSignIn() {
        return hasSignIn;
    }

    public void setHasSignIn(boolean hasSignIn) {
        this.hasSignIn = hasSignIn;
    }

    public int getOnlineAwardTime() {
        return onlineAwardTime;
    }

    public void setOnlineAwardTime(int onlineAwardTime) {
        this.onlineAwardTime = onlineAwardTime;
    }

    public int getOnlineAwardCount() {
        return onlineAwardCount;
    }

    public void setOnlineAwardCount(int onlineAwardCount) {
        this.onlineAwardCount = onlineAwardCount;
    }

    public int getMoneyTreeLv() {
        return moneyTreeLv;
    }

    public void setMoneyTreeLv(int moneyTreeLv) {
        this.moneyTreeLv = moneyTreeLv;
    }

    public int getAuto() {
        return auto;
    }

    public void setAuto(int auto) {
        this.auto = auto;
    }

    public long getGiftNum() {
        return giftNum;
    }

    public void setGiftNum(long giftNum) {
        this.giftNum = giftNum;
    }

    public long getCharacterNum() {
        return characterNum;
    }

    public void setCharacterNum(long characterNum) {
        this.characterNum = characterNum;
    }
    public LoginInfoDto dto(DBPlayer player){
        return this;
    }
}
