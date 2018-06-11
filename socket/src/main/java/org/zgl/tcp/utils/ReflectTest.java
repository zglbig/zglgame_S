package org.zgl.tcp.utils;

import org.zgl.tcp.test.ITest;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * @作者： big
 * @创建时间： 2018/6/6
 * @文件描述：
 */
public class ReflectTest {
    public static void main(String[] args) throws ClassNotFoundException {
        Class c = Class.forName(ITest.class.getName());
        Method[] methods = c.getDeclaredMethods();
        for(Method m : methods){
            System.out.println("return "+m.getReturnType().getName());
            System.out.println("methodname "+m.getName());
            Parameter[] parameter = m.getParameters();
            for(Parameter p : parameter){
                System.out.println("paramType "+p.getParameterizedType().getTypeName());
                System.out.println("paramName "+p.getName());
            }
        }
    }
}
