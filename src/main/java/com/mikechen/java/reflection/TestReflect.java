package com.mikechen.java.reflection;

import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * 反射源码案例
 *
 * @author  mikechen
 */

public class TestReflect {
    public static void main(String[] args) throws Exception {
        // 1.加载配置文件
        Properties properties = new Properties();

        // 1.1创建Properties对象
        // 1.2加载配置文件并转换为一个集合
        // 1.2.1获取class目录下的配置文件
        ClassLoader classLoader = TestReflect.class.getClassLoader();
        InputStream stream = classLoader.getResourceAsStream("reflect.properties");
        properties.load(stream);

        // 2.获取配置文件中定义的数据
        String className = properties.getProperty("className");
        String methodName = properties.getProperty("methodName");

        // 3.加载此类进入内存
        Class cls = Class.forName(className);

        Method[] methods = cls.getDeclaredMethods();
        for (Method m:methods){
            System.out.println("--------"+"反射方法"+"-----------");
            System.out.println(m);
        }

        Field[] fields = cls.getDeclaredFields();
        for (Field f:fields) {
            System.out.println("--------"+"反射属性"+"-----------");
            System.out.println(f);
        }

        /* 所有的构造体 */
        Constructor[] constructors = cls.getDeclaredConstructors();
        for (Constructor c:constructors){
            System.out.println("--------"+"反射构造函数"+"-----------");
            System.out.println(c);
        }


        // 4.创建对象
        Object obj = cls.newInstance();

        // 5.获取方法对象
        Method method = cls.getMethod(methodName);

        // 6.执行方法
        method.invoke(obj);
    }
}

