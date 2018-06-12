package org.zgl.gamelogic;

import org.zgl.http.desc.ClassDesc;
import org.zgl.http.desc.MethodDesc;
import org.zgl.http.rule.IHttpSyncService;

/**
 * @作者： big
 * @创建时间： 2018/6/12
 * @文件描述：
 */
@ClassDesc("http测试接口")
public interface ITestLogic extends IHttpSyncService {
    @MethodDesc("http测试接口测试方法")
    int test();
}
