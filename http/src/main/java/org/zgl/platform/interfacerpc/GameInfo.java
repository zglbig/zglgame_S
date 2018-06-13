package org.zgl.platform.interfacerpc;

import org.zgl.platform.dto.VersionCheckDto;

/**
 * @作者： big
 * @创建时间： 2018/6/12
 * @文件描述：程序启动时需要初始化这个对象
 */
public class GameInfo {
    private static VersionCheckDto versionInfo;

    public GameInfo() {
    }

    public static VersionCheckDto getVersionInfo() {
        return versionInfo;
    }

    public static void setVersionInfo(VersionCheckDto versionInfo) {
        GameInfo.versionInfo = versionInfo;
    }
}
