package org.zgl.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @作者： big
 * @创建时间： 2018/6/11
 * @文件描述：
 */
public class LoggerUtil {
    private static final Logger logger = LoggerFactory.getLogger("org.zgl");
    public static Logger getLogger(){
        return logger;
    }
}
