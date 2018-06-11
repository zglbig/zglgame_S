package org.zgl.tcp.proxy.message;

/**
 * @作者： big
 * @创建时间： 2018/6/8
 * @文件描述：
 */
public class IoMessageBaseTypeImpl implements IoMessage {
    /**接口名*/
    private String interfaceName;
    /**方法名*/
    private String methodName;
    /**参数*/
    private String args;

    public String getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getArgs() {
        return args;
    }

    public void setArgs(String args) {
        this.args = args;
    }
}
