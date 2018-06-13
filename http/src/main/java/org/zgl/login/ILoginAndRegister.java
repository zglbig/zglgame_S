package org.zgl.login;

import org.zgl.http.desc.ClassDesc;
import org.zgl.http.desc.MethodDesc;
import org.zgl.http.rule.IHttpSyncService;
import org.zgl.login.dto.LoginInfoDto;

/**
 * @作者： big
 * @创建时间： 2018/6/13
 * @文件描述：
 */
@ClassDesc("登陆注册")
public interface ILoginAndRegister extends IHttpSyncService {
    @MethodDesc("使用uid登陆")
    LoginInfoDto loginByAccount(long uid, String password);
    @MethodDesc("resultCode:登陆平台返回的结果码")
    LoginInfoDto loginByWX(String account,String userName,String headIcon, int resultCode);
    LoginInfoDto loginByQQ(String account, String userName,String headIcon,int resultCode);
    LoginInfoDto loginByPhone(String account,int resultCode);
    @MethodDesc("游客登陆")
    LoginInfoDto loginByTourist(String account,int resultCode);
}
