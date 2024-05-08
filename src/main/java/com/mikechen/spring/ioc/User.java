package com.mikechen.spring.ioc;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

/**
 * Spring Bean生命周期讲解使用
 *
 * @author mikechen
 */
public class User implements DisposableBean, InitializingBean, BeanFactoryAware, BeanNameAware {

    private String name;

    User() {
        System.out.println("Constructor of user bean is invoked!");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("setName property of user is invoked");
    }

    public void add(){
        System.out.println("add......");
    }

    public void init() {

        System.out.println("custom init method of user bean is invoked!");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("setBeanFactory method of user is invoked");
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("setBeanName method of user is invoked");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean Destroy method of user bean is invoked!");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet method of user bean is invoked!");
    }

    public void destroyMethod() {
        System.out.println("custom Destroy method of user bean is invoked!");
    }

}

