package com.tyler;

/**
 * @author ：Tyler Zhang
 * @date ：Created in 2020-02-12 22:08
 */
public class ChinaFactory implements HumanFactory {
    @Override
    public Boy getBoy() {
        return new ChinaBoy();
    }

    @Override
    public Girl getGirl() {
        return new ChinaGirl();
    }
}
