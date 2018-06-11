package org.zgl.utils;

import org.zgl.tcp.proxy.desc.ProxyService;
import org.zgl.tcp.utils.builder_rpc_interface.CodeModel;
import org.zgl.tcp.utils.builder_rpc_interface.GetFileAllInit;

import java.lang.annotation.Annotation;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @作者： big
 * @创建时间： 2018/6/6
 * @文件描述：
 */
public class ScanPath {
    /**
     * 获取拥有Service注解的所有类
     * @param path 包路径
     * @return
     */
    public static void scanPath(String path){
        List<Class> clazzs = GetFileAllInit.getClasssFromPackage(path);
        Set<CodeModel> protocolSet = new HashSet<>();
        if (clazzs.size()<=0)
            return;
        for (Class c:clazzs) {
            Annotation proco = c.getAnnotation(ProxyService.class);
            if(proco instanceof ProxyService){
                ProxyService proco1 = (ProxyService) proco;
                protocolSet.add(new CodeModel("",c));
            }
        }
    }
}
