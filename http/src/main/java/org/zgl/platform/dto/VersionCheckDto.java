package org.zgl.platform.dto;

import org.zgl.IDto;

/**
 * @作者： big
 * @创建时间： 2018/6/12
 * @文件描述：版本更新信息
 */
public class VersionCheckDto implements IDto {
    //游戏版本更新 如果为空则没有更新 如多有则是更新地址
    private String gameVersionUrl;
    //ab包更新
    private String abVersionUrl;
    //静态数据更新
    private boolean hasStaticVersoin;
    //tcp链接的ip
    private String tcpIp;
    //数据加密的密钥
    private String secretKey;

    public VersionCheckDto() {
    }

    public VersionCheckDto(String gameVersionUrl, String abVersionUrl, boolean hasStaticVersoin, String tcpIp, String secretKey) {
        this.gameVersionUrl = gameVersionUrl;
        this.abVersionUrl = abVersionUrl;
        this.hasStaticVersoin = hasStaticVersoin;
        this.tcpIp = tcpIp;
        this.secretKey = secretKey;
    }

    public String getGameVersionUrl() {
        return gameVersionUrl;
    }

    public void setGameVersionUrl(String gameVersionUrl) {
        this.gameVersionUrl = gameVersionUrl;
    }

    public String getAbVersionUrl() {
        return abVersionUrl;
    }

    public void setAbVersionUrl(String abVersionUrl) {
        this.abVersionUrl = abVersionUrl;
    }

    public boolean isHasStaticVersoin() {
        return hasStaticVersoin;
    }

    public void setHasStaticVersoin(boolean hasStaticVersoin) {
        this.hasStaticVersoin = hasStaticVersoin;
    }

    public String getTcpIp() {
        return tcpIp;
    }

    public void setTcpIp(String tcpIp) {
        this.tcpIp = tcpIp;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }
}
