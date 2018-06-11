package org.zgl.http;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.zgl.http.message.*;
import org.zgl.http.session.ISession;
import org.zgl.utils.ProtostuffUtils;
import org.zgl.utils.StringUtils;
import org.zgl.utils.builder_rpc_interface.CheckType;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.Map;

/**
 * @作者： big
 * @创建时间： 2018/6/11
 * @文件描述：
 */
@Controller
@RequestMapping("/game")

public class HttpServerSimpleChannelInboundHandler {
    private final Map<String,Class<?>> proxyObj = new HashMap<>();

    @RequestMapping(value = "/handle",method = RequestMethod.POST)
    public void handle(HttpServletRequest request, HttpServletResponse response){
        try (DataInputStream dataInputStream = new DataInputStream(request.getInputStream())) {
            int head = dataInputStream.readInt();
            if (head != -777888)
                return;
            short dataSrc = dataInputStream.readShort();
            //读取数据长度
            short length = dataInputStream.readShort();
            byte[] data = dataInputStream.readAllBytes();
            IoMessage ioMessage = null;
            switch (dataSrc){
                case 1:
                    ioMessage = ProtostuffUtils.deserializer(data,IoMessageBaseTypeImpl.class);
                    break;
                case 2:
                    ioMessage = ProtostuffUtils.deserializer(data,IoMessageJavaTpeImpl.class);
                    break;
            }
            IoMessagePackage ioMessagePackage = new IoMessagePackage(dataSrc,ioMessage);
            handler(ioMessagePackage,response);
        } catch (Exception e) {
        }
    }
    private void handler(IoMessagePackage ioMessagePackage, HttpServletResponse response){
        IoMessage ioMessage = ioMessagePackage.getIoMessage();
        try {
            Class<?> clazz = proxyObj.getOrDefault(ioMessage.getInterfaceName(),null);
            if(clazz == null){
                //异常
            }
            Method method = null;
            Object[] params = null;
            switch (ioMessagePackage.getDataSrc()){
                case 1:
                    dataSrc1(ioMessage,clazz,method,params);
                    break;
                case 2:
                    dataSrc2(ioMessage,clazz,method,params);
                    break;
            }
            Object obj = clazz.getDeclaredConstructor().newInstance();
            Object o = method.invoke(obj,params);
            IoMessage ioMessage1 = IoMessageSplice.getIoMessage(ioMessage.getInterfaceName(),
                    ioMessage.getMethodName(),
                    new Object[]{o},ioMessagePackage.getDataSrc(),o.getClass().isPrimitive());
            write(response,ioMessagePackage.getDataSrc(),ioMessage1);
        }catch (Exception e){

        }
    }
    private void write(HttpServletResponse httpServletResponse,short dataScr, IoMessage ioMessage1) {
        try (DataOutputStream dos = new DataOutputStream(httpServletResponse.getOutputStream())) {
            byte[] buf1 = null;
            if (ioMessage1 != null)
                buf1 = ProtostuffUtils.serializer(ioMessage1);
            dos.writeInt(-777888);
            dos.writeShort(dataScr);
            short leng = (short) (buf1 == null ? 0 : buf1.length);
            dos.writeShort(leng);
            if (buf1 != null)
                dos.write(buf1);
            httpServletResponse.getOutputStream().flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void dataSrc1(IoMessage ioMessage,Class<?> clazz,Method method,Object[] params) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //分割时用$以防使用json时的逗号分割
        Method[] methods = clazz.getDeclaredMethods();
        for(Method m : methods){
            if(m.getName().equals(ioMessage.getMethodName())) {
                method = m;
                break;
            }
        }
        Parameter[] p = method.getParameters();
        String[] param = StringUtils.split((String) ioMessage.getArgs(),"$");
        if(p.length != param.length)
            throw new RuntimeException("数据参数异常");
        params = new Object[p.length];
        for(int i = 0;i<params.length;i++){
            params[i] = CheckType.stringToType(param[i],p[i].getType().getSimpleName());
        }
    }
    private void dataSrc2(IoMessage ioMessage,Class<?> clazz,Method method,Object[] params) throws NoSuchMethodException {
        IoMessageJavaTpeImpl ioMessageJavaTpe = (IoMessageJavaTpeImpl) ioMessage;
        method = clazz.getDeclaredMethod(ioMessageJavaTpe.getMethodName(),method.getParameterTypes());
        params = (Object[]) ioMessageJavaTpe.getArgs();
    }
}
