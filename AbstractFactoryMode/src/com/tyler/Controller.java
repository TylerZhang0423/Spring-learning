package com.tyler;

/**
 * @author ：Tyler Zhang
 * @date ：Created in 2020-02-12 22:09
 */
public class Controller {
    public static void main(String[] args) {
        HumanFactory chinaFactory = new ChinaFactory();
        Boy chinaBoy = chinaFactory.getBoy();
        chinaBoy.draw();

        HumanFactory americaFactory = new AmericaFactory();
        Girl americaGirl = americaFactory.getGirl();
        americaGirl.draw();
    }
}
