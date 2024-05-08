package com.mikechen.proxy.wine;

public class MaoTaiProxy implements  Wine{

    MaoTai maoTai=new MaoTai();

    @Override
    public void sellWine() {
        //beforeService
        System.out.println("售前：与用户亲切交流");

        maoTai.sellWine();

        //afterService
        System.out.println("售后：拿到钱+提供售后服务");

    }
}
