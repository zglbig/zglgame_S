package org.zgl.http;

import org.zgl.http.desc.ProxyService;
import org.zgl.http.message.*;
import org.zgl.utils.ProtostuffUtils;
import org.zgl.utils.StringUtils;
import org.zgl.utils.builder_rpc_interface.CheckType;
import org.zgl.utils.builder_rpc_interface.GetFileAllInit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @作者： big
 * @创建时间： 2018/6/11
 * @文件描述：
 */
public class HttpServerSimpleChannelInboundHandler {
    private static HttpServerSimpleChannelInboundHandler instance;
    private final Map<String, Class<?>> proxyObj;
    public static HttpServerSimpleChannelInboundHandler getInstance() {
        if (instance == null)
            instance = new HttpServerSimpleChannelInboundHandler();
        return instance;
    }
    private HttpServerSimpleChannelInboundHandler() {
        proxyObj = new HashMap<>();
        scan("org.zgl");
    }


    public void handle(HttpServletRequest request, HttpServletResponse response) {
        try (DataInputStream dataInputStream = new DataInputStream(request.getInputStream())) {
            int head = dataInputStream.readInt();
            if (head != -777888)
                return;
            short dataSrc = dataInputStream.readShort();
            //读取数据长度
            short length = dataInputStream.readShort();
            byte[] data = dataInputStream.readAllBytes();
            IoMessage ioMessage = null;
            switch (dataSrc) {
                case 1:
                    ioMessage = ProtostuffUtils.deserializer(data, IoMessageBaseTypeImpl.class);
                    break;
                case 2:
                    ioMessage = ProtostuffUtils.deserializer(data, IoMessageJavaTpeImpl.class);
                    break;
            }
            IoMessagePackage ioMessagePackage = new IoMessagePackage(dataSrc, ioMessage);
            handler(ioMessagePackage, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void handler(IoMessagePackage ioMessagePackage, HttpServletResponse response) {
        IoMessage ioMessage = ioMessagePackage.getIoMessage();
        try {
            Class<?> clazz = proxyObj.getOrDefault(ioMessage.getInterfaceName(), null);
            if (clazz == null) {
                //异常
            }
            Method method = getMethodFordataSrc(ioMessage,clazz);
            Object[] params = null;
            switch (ioMessagePackage.getDataSrc()) {
                case 1:
                    params = getParamsFordataSrc1(ioMessage,method);
                    break;
                case 2:
                    params = (Object[]) ioMessage.getArgs();
                    break;
            }
            Object obj = clazz.getDeclaredConstructor().newInstance();
            Object o = method.invoke(obj, params);
            IoMessage ioMessage1 = IoMessageSplice.getIoMessage(ioMessage.getInterfaceName(),
                    ioMessage.getMethodName(),
                    new Object[]{o}, ioMessagePackage.getDataSrc(),CheckType.isPrimitive(o.getClass()));
            write(response,ioMessage1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void write(HttpServletResponse httpServletResponse, IoMessage ioMessage1) {
        try (DataOutputStream dos = new DataOutputStream(httpServletResponse.getOutputStream())) {
            if(ioMessage1 == null){
                throw new RuntimeException("数据回发异常,消息踢不能为空");
            }
            //数据类型
            short dataDest = -55;
            if(ioMessage1 instanceof IoMessageJavaTpeImpl){
                dataDest = 2;
            }else if(ioMessage1 instanceof IoMessageBaseTypeImpl){
                dataDest = 1;
            }else if(ioMessage1 instanceof IoMessagePBTypeImpl){
                dataDest = 2;
            }
            dos.writeInt(-777888);//包头:请使用一个不常用到的int类型数据
            dos.writeShort(dataDest);
            dos.writeShort(200);
            byte[] buf = ProtostuffUtils.serializer(ioMessage1);
            dos.writeShort(buf.length);
            dos.write(buf);//数据
            httpServletResponse.getOutputStream().flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    private Method getMethodFordataSrc(IoMessage ioMessage, Class<?> clazz){
        //分割时用$以防使用json时的逗号分割
        Method[] methods = clazz.getDeclaredMethods();
        for (Method m : methods) {
            if (m.getName().equals(ioMessage.getMethodName())) {
                return m;
            }
        }
        return null;
    }
    private Object[] getParamsFordataSrc1(IoMessage ioMessage,Method method){
        Parameter[] p = method.getParameters();
        String[] param = StringUtils.split((String) ioMessage.getArgs(), "$");
        if (p.length != param.length)
            throw new RuntimeException("数据参数异常");
        Object[] params = new Object[p.length];
        for (int i = 0; i < params.length; i++) {
            params[i] = CheckType.stringToType(param[i], p[i].getType().getSimpleName());
        }
        return params;
    }
    private void scan(String scanPath){
        List<Class> classList = GetFileAllInit.getClasssFromPackage(scanPath);
        for (Class c:classList) {
            Annotation proxy = c.getAnnotation(ProxyService.class);
            if(proxy instanceof ProxyService){
                Class i = c.getInterfaces()[0];
                proxyObj.put(i.getName(),c);
            }
        }
    }
}
