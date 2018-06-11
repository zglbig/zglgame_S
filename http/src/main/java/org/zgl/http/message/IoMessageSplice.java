package org.zgl.http.message;

import org.zgl.tcp.utils.ProtostuffUtils;

/**
 * @作者： big
 * @创建时间： 2018/6/8
 * @文件描述：
 */
public class IoMessageSplice {
    public static IoMessage getIoMessage(String interfaceName, String methodName, Object[] args, short dataDest, boolean isPrimitive){
        switch (dataDest){
            case 1:

                if(isPrimitive)
                    return primitive(interfaceName,methodName,args);
                else
                    return pb(interfaceName,methodName,args);
            case 2:
                return javaType(interfaceName,methodName,args);
        }
        throw new RuntimeException("找不到数据发送目的地");
    }
    private static IoMessage javaType(String interfaceName, String methodName, Object[] args){
        IoMessageJavaTpeImpl ioMessageJavaTpe = new IoMessageJavaTpeImpl();
        ioMessageJavaTpe.setInterfaceName(interfaceName);
        ioMessageJavaTpe.setMethodName(methodName);
        ioMessageJavaTpe.setArgs(args);
        return ioMessageJavaTpe;
    }
    private static IoMessage primitive(String interfaceName, String methodName, Object[] args){
        IoMessageBaseTypeImpl ioMessageBaseType = new IoMessageBaseTypeImpl();
        ioMessageBaseType.setInterfaceName(interfaceName);
        ioMessageBaseType.setMethodName(methodName);
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<args.length;i++){
            sb.append(args.toString());
            if(i != args.length - 1){
                sb.append("$");
            }
        }
        ioMessageBaseType.setArgs(sb.toString());
        return ioMessageBaseType;
    }
    private static IoMessage pb(String interfaceName, String methodName, Object[] args){
        IoMessagePBTypeImpl ioMessagePBType = new IoMessagePBTypeImpl();
        ioMessagePBType.setInterfaceName(interfaceName);
        ioMessagePBType.setMethodName(methodName);
        Object o = args[0];
        byte[] buf = ProtostuffUtils.serializer(o);
        ioMessagePBType.setArgs(buf);
        return ioMessagePBType;
    }
}
