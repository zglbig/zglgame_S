package org.zgl.dao.mapper;

import org.zgl.dao.entity.DBPlayer;

import java.util.List;

/**
 * @作者： big
 * @创建时间： 2018/6/13
 * @文件描述：
 */
public interface IDBPlayerMapper {
    DBPlayer queryDBPlayerByAccount(String account);
    DBPlayer queryDBPlayerByUid(Long uid);
    DBPlayer queryDBPlayerById(Integer id);
    int insertDBPlayer(DBPlayer player);
    int updateDBPlayer(DBPlayer player);
    int deletDBPlayerByUid(Long uid);
    List<DBPlayer> queryDBPlayerList(Integer id);
}
