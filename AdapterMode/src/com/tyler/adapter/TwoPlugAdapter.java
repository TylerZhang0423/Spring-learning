package com.tyler.adapter;

/**
 * @author ：Tyler Zhang
 * @date ：Created in 2020-02-14 21:46
 * 二相转三相的适配器
 */
public class TwoPlugAdapter implements ThreePlugIn {

    private GBTwoPlug plug;

    public TwoPlugAdapter(GBTwoPlug plug) {
        this.plug = plug;
    }

    @Override
    public void powerOfThree() {
        System.out.println("通过转换");
        plug.powerWithTwo();
    }
}
