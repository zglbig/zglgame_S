package org.zgl.utils.builder_rpc_interface;

import org.zgl.tcp.utils.StringUtils;

public class CheckType {
    public static Class<?> stringToClass(String str){
        Class<?> type = Object.class;
        switch (str){
            case "boolean":
                type = boolean.class;
                break;
            case "bool":
                type = boolean.class;
                break;
            case "int":
                type = int.class;
                break;
            case "short":
                type = short.class;
                break;
            case "byte":
                type = byte.class;
                break;
            case "long":
                type = long.class;
                break;
            case "float":
                type = float.class;
                break;
            case "double":
                type = double.class;
                break;

            case "Bool":
                type = Boolean.class;
                break;
            case "Boolean":
                type = Boolean.class;
                break;
            case "Integer":
                type = Integer.class;
                break;
            case "Short":
                type = Short.class;
                break;
            case "Byte":
                type = Byte.class;
                break;
            case "Long":
                type = Long.class;
                break;
            case "Float":
                type = Float.class;
                break;
            case "Double":
                type = Double.class;
                break;
            case "string":
                type = String.class;
                break;
            case "String":
                type = String.class;
                break;
                default:
                    try {
                        type = Class.forName(str);
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
        }
        return type;
    }
    public static ParamTypes stringToClasss(String paramTypes, String params){
        if(params == null|| params.equals("")){
            return new ParamTypes(null,null);
        }
        String[] str = StringUtils.split(paramTypes,"$");
        String[] str1 = StringUtils.split(params,"$");
        if(str1.length != str.length)
            throw new RuntimeException("接受到的数据长度不一样");

        Class<?>[] c = new Class<?>[str.length];
        Object[] o = new Object[str.length];
        for(int i = 0;i<str.length;i++){
            c[i] = stringToClass(str[i]);
            o[i] = stringToType(str[i],str1[i]);
        }
        return new ParamTypes(c,o);
    }
    public static Object stringToType(String param,String paramTypStr){
        Object type = null;
        switch (paramTypStr){
            case "boolean":
                type = Boolean.parseBoolean(param);
                break;
            case "bool":
                type = Boolean.parseBoolean(param);
                break;
            case "int":
                type = Integer.parseInt(param);
                break;
            case "short":
                type = Short.parseShort(param);
                break;
            case "byte":
                type = Byte.parseByte(param);
                break;
            case "long":
                type = Long.parseLong(param);
                break;
            case "float":
                type = Float.parseFloat(param);
                break;
            case "double":
                type = Double.parseDouble(param);
                break;

            case "Bool":
                type = Boolean.parseBoolean(param);
                break;
            case "Boolean":
                type = Boolean.parseBoolean(param);
                break;
            case "Integer":
                type = Integer.parseInt(param);
                break;
            case "Short":
                type = Short.parseShort(param);
                break;
            case "Byte":
                type = Byte.parseByte(param);
                break;
            case "Long":
                type = Long.parseLong(param);
                break;
            case "Float":
                type = Float.parseFloat(param);
                break;
            case "Double":
                type = Double.parseDouble(param);
                break;
            case "string":
                type = param;
                break;
            case "String":
                type = param;
                break;
            default:
                try {
                    type = Class.forName(param).getDeclaredConstructor().newInstance();
                } catch (Exception e) {
                    e.printStackTrace();
                }
        }
        return type;
    }
}