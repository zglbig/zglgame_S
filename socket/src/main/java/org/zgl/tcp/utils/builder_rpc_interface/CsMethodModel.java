package org.zgl.tcp.utils.builder_rpc_interface;

/**
 * @作者： big
 * @创建时间： 2018/6/6
 * @文件描述：
 */
public class CsMethodModel {
    //方法名 参数名 参数类型 返回类型
    private String methodName;//方法名
    private String returnType;//返回类型
    private String methodDesc;//参数注释
    private ParamertModel[] methodTypes;//参数对应的参数类型

    public CsMethodModel() {
    }

    public CsMethodModel(String methodName, String returnType, String methodAnnotation, ParamertModel[] methodTypes) {
        this.methodName = methodName;
        this.returnType = returnType;
        this.methodDesc = methodAnnotation;
        this.methodTypes = methodTypes;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public ParamertModel[] getMethodTypes() {
        return methodTypes;
    }

    public void setMethodTypes(ParamertModel[] methodTypes) {
        this.methodTypes = methodTypes;
    }

    public String getReturnType() {
        return returnType;
    }

    public void setReturnType(String returnType) {
        this.returnType = returnType;
    }

    public String getMethodDesc() {
        return methodDesc;
    }

    public void setMethodDesc(String methodDesc) {
        this.methodDesc = methodDesc;
    }

}
