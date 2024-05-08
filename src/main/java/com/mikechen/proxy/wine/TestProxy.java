package com.mikechen.proxy.wine;

public class TestProxy {

    public static void main(String args[]) {

        /**静态代理**/
//        Wine maoTaiProxy = new MaoTaiProxy();
//        maoTaiProxy.sellWine();

        /**动态代理生产具体的代理**/

        /**生产的代理类保存到本地文件*/
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        //绑定该类实现的所有接口
        Wine maoTaiProxy = (Wine) new WineProxyFactory() .bind(new MaoTai());
        maoTaiProxy.sellWine();

        Wine wuLiangYeProxy = (Wine) new WineProxyFactory() .bind(new WuLiangYe());
        wuLiangYeProxy.sellWine();

    }
}
