package com.mikechen.proxy.wine;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class WineProxyFactory {

    private Object brand;

    //绑定委托对象，并返回代理类
    public Object bind(Object brand)
    {
        this.brand = brand;

        //绑定该类实现的所有接口，取得代理类
        return Proxy.newProxyInstance(
                brand.getClass().getClassLoader(),
                brand.getClass().getInterfaces(),
                new InvocationHandler(){
                    @Override
                    public Object invoke(Object proxy , Method method , Object[] args)throws Throwable {
                        Object result = null;
                        //这里就可以进行所谓的AOP编程了
                        //在调用具体函数方法前，执行功能处理
                        //beforeService
                        System.out.println("售前：与用户亲切交流");

                        result = method.invoke(brand,args);

                        //afterService
                        System.out.println("售后：拿到钱+提供售后服务");

                        return result;
                    }
                });
    }


}
