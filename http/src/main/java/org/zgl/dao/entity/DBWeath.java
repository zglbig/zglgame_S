package org.zgl.dao.entity;

import java.sql.Date;
import java.util.Map;

/**
 * @作者： big
 * @创建时间： 2018/6/13
 * @文件描述：
 */
public class DBWeath {
    private Integer weathId;
    private Long gold;
    private Long daimond;
    private Long integral;
    private Integer vipLv;
    private Long vipExp;
    /**礼物值*/
    private Long giftNum;
    /**人品值*/
    private Long characterNum;
    //当前使用的座驾id
    private Integer nowUseAutoId;
    //这三个将以json的形式存在
    private Map<String,Integer> gift;
    private Map<String,Integer> prop;
    private Map<String,Integer> autos;
    //摇钱树购买时间
    private Date moneyTreeCreateTime;
    //摇钱树最后领取时间
    private Date moneyTreeLastEditTime;

    public Integer getWeathId() {
        return weathId;
    }

    public void setWeathId(Integer weathId) {
        this.weathId = weathId;
    }

    public Long getGold() {
        return gold;
    }

    public void setGold(Long gold) {
        this.gold = gold;
    }

    public Long getDaimond() {
        return daimond;
    }

    public void setDaimond(Long daimond) {
        this.daimond = daimond;
    }

    public Long getIntegral() {
        return integral;
    }

    public void setIntegral(Long integral) {
        this.integral = integral;
    }

    public Integer getVipLv() {
        return vipLv;
    }

    public void setVipLv(Integer vipLv) {
        this.vipLv = vipLv;
    }

    public Long getVipExp() {
        return vipExp;
    }

    public void setVipExp(Long vipExp) {
        this.vipExp = vipExp;
    }

    public Integer getNowUseAutoId() {
        return nowUseAutoId;
    }

    public void setNowUseAutoId(Integer nowUseAutoId) {
        this.nowUseAutoId = nowUseAutoId;
    }

    public Map<String, Integer> getGift() {
        return gift;
    }

    public void setGift(Map<String, Integer> gift) {
        this.gift = gift;
    }

    public Map<String, Integer> getProp() {
        return prop;
    }

    public void setProp(Map<String, Integer> prop) {
        this.prop = prop;
    }

    public Map<String, Integer> getAutos() {
        return autos;
    }

    public void setAutos(Map<String, Integer> autos) {
        this.autos = autos;
    }

    public Long getGiftNum() {
        return giftNum;
    }

    public void setGiftNum(Long giftNum) {
        this.giftNum = giftNum;
    }

    public Long getCharacterNum() {
        return characterNum;
    }

    public void setCharacterNum(Long characterNum) {
        this.characterNum = characterNum;
    }

    public Date getMoneyTreeCreateTime() {
        return moneyTreeCreateTime;
    }

    public void setMoneyTreeCreateTime(Date moneyTreeCreateTime) {
        this.moneyTreeCreateTime = moneyTreeCreateTime;
    }

    public Date getMoneyTreeLastEditTime() {
        return moneyTreeLastEditTime;
    }

    public void setMoneyTreeLastEditTime(Date moneyTreeLastEditTime) {
        this.moneyTreeLastEditTime = moneyTreeLastEditTime;
    }
}
