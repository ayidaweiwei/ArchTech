package com.mikechen.spring.ioc;

import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

/**
 * IOC 底层源码解析
 * @author  mikechen
 */

public class TestIOC {
    @Test
    public void testUser(){

        //1.完成资源定位,定义BeanDefinition的信息来源
        ClassPathResource classPathResource = new ClassPathResource("applicationContext.xml");

        //2.创建默认的Bean工厂
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();

        //3.创建一个加载BeanDefinition的读取器，通过一个回调配置给BeanFactory
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(defaultListableBeanFactory);

        //4.从信息来源中加载BeanDefinition
        beanDefinitionReader.loadBeanDefinitions(classPathResource);
//        BeanDefinition

        System.out.println(defaultListableBeanFactory.getBeanDefinitionCount());

        //5.可以得bean实例
        User user = (User)defaultListableBeanFactory.getBean("user");

        //6.调用方法
        user.add();

        //7.销毁Bean
        defaultListableBeanFactory.destroySingleton("user");



        //1.加载 spring 配置文件,根据创建对象
//        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//
//        //2.得到配置创建的对象
//        User user = (User) context.getBean("user");
//        user.add();
    }
}
