package com.tyler.adapter;

/**
 * @author ：Tyler Zhang
 * @date ：Created in 2020-02-14 22:13
 */
public class TwoPlugAdapterByExtends extends GBTwoPlug implements ThreePlugIn {

    @Override
    public void powerOfThree() {
        System.out.println("通过继承实现适配器");
        this.powerWithTwo();
    }
}
