package com.tyler;

/**
 * @author ：Tyler Zhang
 * @date ：Created in 2020-02-12 22:15
 */
public class AmericaFactory implements HumanFactory {
    @Override
    public Boy getBoy() {
        return new AmericaBoy();
    }

    @Override
    public Girl getGirl() {
        return new AmericaGirl();
    }
}
