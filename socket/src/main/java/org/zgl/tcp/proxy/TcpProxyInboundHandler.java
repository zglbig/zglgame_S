package org.zgl.tcp.proxy;

import org.zgl.tcp.proxy.desc.ProxyService;
import org.zgl.tcp.proxy.message.IoMessage;
import org.zgl.tcp.proxy.message.IoMessageJavaTpeImpl;
import org.zgl.tcp.proxy.message.IoMessagePackage;
import org.zgl.tcp.proxy.message.IoMessageSplice;
import org.zgl.tcp.proxy.socket.session.ISession;
import org.zgl.tcp.test.TestImpl;
import org.zgl.tcp.utils.StringUtils;
import org.zgl.tcp.utils.builder_rpc_interface.CheckType;
import org.zgl.tcp.utils.builder_rpc_interface.GetFileAllInit;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @作者： big
 * @创建时间： 2018/6/5
 * @文件描述：代理处理
 */
public class TcpProxyInboundHandler {
    private final Map<String,Class<?>> proxyObj;
    private static TcpProxyInboundHandler instance;

    public static TcpProxyInboundHandler getInstance() {
        if(instance == null)
            instance = new TcpProxyInboundHandler();
        return instance;
    }
    private TcpProxyInboundHandler(){
        proxyObj = new HashMap<>();
        scan("org.zgl");
    }
    /**
     * 扫描所有代理接口
     * @param scanPath
     */
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
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> c = Class.forName(TestImpl.class.getName());
        TestImpl o = (TestImpl) c.getDeclaredConstructor().newInstance();
        Method method = c.getMethod("testbb",null);
        method.invoke(o,null);
//        getInstance().scanAnnotation("org.zgl");
    }
    /**
     * 应该还要个session
     * @param
     */
    public void handler(IoMessagePackage ioMessagePackage, ISession session){
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
            session.write(ioMessage1);
        }catch (Exception e){

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
