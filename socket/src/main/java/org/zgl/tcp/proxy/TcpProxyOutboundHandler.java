package org.zgl.tcp.proxy;

import org.zgl.tcp.proxy.message.IoMessage;
import org.zgl.tcp.proxy.message.IoMessageSplice;
import org.zgl.tcp.proxy.socket.session.ISession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @作者： big
 * @创建时间： 2018/6/8
 * @文件描述：下发通知（远程调用客户端接口） 也算回调
 */
public class TcpProxyOutboundHandler {
    @SuppressWarnings("unchecked")
    public static <T> T getRemoteProxyObj(final Class serviceInterFace, final ISession session, final short dataDest){
        return (T) Proxy.newProxyInstance(serviceInterFace.getClassLoader(), new Class<?>[]{serviceInterFace}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Class<?>[] parameterTypes = method.getParameterTypes();
                boolean isPrimitive = true;
                for(Class c : parameterTypes){
                    if(!c.isPrimitive()){
                        isPrimitive = false;
                        break;
                    }
                }
                IoMessage ioMessage = IoMessageSplice.getIoMessage(serviceInterFace.getName(),method.getName(),args,dataDest,isPrimitive);
                session.write(ioMessage);
                return null;
            }
        });
    }
}
