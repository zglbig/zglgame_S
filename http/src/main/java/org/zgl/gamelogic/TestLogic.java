package org.zgl.gamelogic;

import org.zgl.http.desc.ProxyService;

/**
 * @作者： big
 * @创建时间： 2018/6/12
 * @文件描述：
 */
@ProxyService
public class TestLogic implements ITestLogic {
    @Override
    public int test() {
        return 10;
    }
}
