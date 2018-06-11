package org.zgl.utils.builder_rpc_interface;

/**
 * @作者： big
 * @创建时间： 2018/6/5
 * @文件描述：
 */
public class ParamTypes {
    private Class<?>[] paramTypes;
    private Object[] params;

    public ParamTypes() {
    }

    public ParamTypes(Class<?>[] paramTypes, Object[] params) {
        this.paramTypes = paramTypes;
        this.params = params;
    }

    public Class<?>[] getParamTypes() {
        return paramTypes;
    }

    public void setParamTypes(Class<?>[] paramTypes) {
        this.paramTypes = paramTypes;
    }

    public Object[] getParams() {
        return params;
    }

    public void setParams(Object[] params) {
        this.params = params;
    }
}
