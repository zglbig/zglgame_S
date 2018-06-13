package org.zgl.platform.interfacerpc.impl;

import org.zgl.platform.dto.StaticDataDto;
import org.zgl.platform.dto.VersionCheckDto;
import org.zgl.platform.interfacerpc.IVersionUpdateCheck;
import org.zgl.http.desc.ProxyService;

/**
 * @作者： big
 * @创建时间： 2018/6/12
 * @文件描述：
 */
@ProxyService
public class VersionUpdateCheckImpl implements IVersionUpdateCheck {
    @Override
    public VersionCheckDto versionCheck() {
        VersionCheckDto dto = new VersionCheckDto();
        dto.setSecretKey("asdasdasdasdqwrzxscasdas");
        dto.setTcpIp("192.168.1.101:8082");
        return new VersionCheckDto();
    }

    @Override
    public StaticDataDto staticDataUpdate() {
        return null;
    }
}
