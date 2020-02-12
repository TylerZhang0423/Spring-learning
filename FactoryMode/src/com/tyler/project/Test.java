package com.tyler.project;

/**
 * @author ：Tyler Zhang
 * @date ：Created in 2020-02-11 17:06
 * 模拟客户端实现
 */
public class Test {
    public static void main(String[] args) {
        HairFactory hairFactory = new HairFactory();
        HairInterface left = hairFactory.getHairByClassKey("left");
        left.draw();
    }
}
