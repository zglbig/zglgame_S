package org.zgl.login.impl;

import org.zgl.dao.mapper.IDBPlayerMapper;
import org.zgl.dao.entity.DBPlayer;
import org.zgl.http.desc.ProxyService;
import org.zgl.login.ILoginAndRegister;
import org.zgl.login.dto.LoginInfoDto;
import org.zgl.utils.SpringUtils;

import java.util.Date;

/**
 * @作者： big
 * @创建时间： 2018/6/13
 * @文件描述：
 */
@ProxyService
public class LoginAndRegister implements ILoginAndRegister {
    @Override
    public LoginInfoDto loginByAccount(long uid, String password) {
        IDBPlayerMapper playerDao = SpringUtils.getBean(IDBPlayerMapper.class);
        DBPlayer player = playerDao.queryDBPlayerByUid(uid);
        if(player == null){
            //当前还没这个账号
        }
        if(!player.getPassword().equals(password)){
            //密码错误
        }
        LoginInfoDto infoDto = new LoginInfoDto();
        return infoDto;
    }

    @Override
    public LoginInfoDto loginByWX(String account, String userName, String headIcon, int resultCode) {
        if(resultCode != 200){
            //登陆不成功
        }
        IDBPlayerMapper playerDao = SpringUtils.getBean(IDBPlayerMapper.class);
        DBPlayer player = playerDao.queryDBPlayerByAccount(account);
        //注册
        if(player == null){
            player = new DBPlayer();
            player.setAccount(account);
            player.setHeadIcon(headIcon);
            player.setPassword("666666");
            player.setUserName(userName);
            player.setWeath("{}");
            player.setTask("{}");
            java.sql.Date date = new java.sql.Date(new Date().getTime());
            player.setCreateTime(date);
            player.setLastEditTime(date);
            //插入并获取id
            int effectNmu = playerDao.insertDBPlayer(player);
            if(effectNmu <= 0){
                //插入异常
            }
            long uid = player.getId();
            player.setUid(uid);
            DBPlayer player1 = new DBPlayer();
            player1.setId(player.getId());
            player1.setUid(uid);
            //设置uid
            playerDao.updateDBPlayer(player1);
        }
        return  new LoginInfoDto().dto(player);
    }

    @Override
    public LoginInfoDto loginByQQ(String account, String userName, String headIcon, int resultCode) {
        return null;
    }

    @Override
    public LoginInfoDto loginByPhone(String account, int resultCode) {
        return null;
    }

    @Override
    public LoginInfoDto loginByTourist(String account, int resultCode) {
        return null;
    }
}
