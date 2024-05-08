package com.mikechen.spring.loop;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

/**
 * Spring 循环依赖剖析
 * @author  mikechen
 */

public class TestLoop {
    public static void main(String[] args) {
        //1.完成资源定位,定义BeanDefinition的信息来源
        ClassPathResource classPathResource = new ClassPathResource("loopDependence.xml");

        //2.创建默认的Bean工厂
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();

        //3.创建一个加载BeanDefinition的读取器，通过一个回调配置给BeanFactory
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(defaultListableBeanFactory);

        //4.从信息来源中加载BeanDefinition
        beanDefinitionReader.loadBeanDefinitions(classPathResource);
        //BeanDefinition


        //5.可以得bean实例
        ClassA classA = (ClassA)defaultListableBeanFactory.getBean("classA");
//        ClassB classB = (ClassB)defaultListableBeanFactory.getBean("classB");
//
        classA.sayHello();

//        ClassC user = (ClassC)defaultListableBeanFactory.getBean("classC");



//      //1.加载 spring 配置文件,根据创建对象
//       ApplicationContext context = new ClassPathXmlApplicationContext("loopAOPDependence.xml");
//
//      //2.得到配置创建的对象
//        ClassA classA = (ClassA) context.getBean("classA");
//
//      classA.sayHello();
    }
}

