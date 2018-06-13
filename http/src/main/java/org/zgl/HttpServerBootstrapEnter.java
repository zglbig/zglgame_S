package org.zgl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.zgl.dao.mapper.IDBPlayerMapper;
import org.zgl.dao.entity.DBPlayer;
import org.zgl.utils.SpringUtils;

import java.util.List;


@SpringBootApplication
@MapperScan("org.zgl.dao.mapper")
public class HttpServerBootstrapEnter {
    public static void main(String[] args) {
        SpringApplication.run(HttpServerBootstrapEnter.class, args);
        IDBPlayerMapper playerDao = SpringUtils.getBean(IDBPlayerMapper.class);
        List<DBPlayer> player = playerDao.queryDBPlayerList(1);
        System.out.println(player);
    }
}
