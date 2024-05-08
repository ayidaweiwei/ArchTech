package com.mikechen.proxy;
/**
 * TestProxy
 *
 * @author mikechen
 */
public class TestProxy {

    public static void main(String args[]) {
        /**静态代理**/
        Subject sub = new SubjectProxy();
        sub.doSomething();

        /**动态代理**/
//        ProxyHandler dynamicProxy  = new ProxyHandler();
//        //绑定该类实现的所有接口
//        Subject sub = (Subject) dynamicProxy .bind(new RealSubject());
//        sub.doSomething();

    }
}
