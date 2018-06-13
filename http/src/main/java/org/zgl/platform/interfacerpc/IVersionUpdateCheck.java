package org.zgl.platform.interfacerpc;

import org.zgl.platform.dto.StaticDataDto;
import org.zgl.platform.dto.VersionCheckDto;
import org.zgl.http.desc.ClassDesc;
import org.zgl.http.desc.MethodDesc;
import org.zgl.http.rule.IHttpSyncService;

/**
 * @作者： big
 * @创建时间： 2018/6/12
 * @文件描述：
 */
@ClassDesc("版本更新检测")
public interface IVersionUpdateCheck extends IHttpSyncService {
    @MethodDesc("版本更新检测")
    VersionCheckDto versionCheck();
    @MethodDesc("静态数据下载更新")
    StaticDataDto staticDataUpdate();
}
