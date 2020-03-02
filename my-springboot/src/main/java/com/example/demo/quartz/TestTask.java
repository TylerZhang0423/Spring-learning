package com.example.demo.quartz;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author ：Tyler Zhang
 * @date ：Created in 2020-03-02 17:24
 */
public class TestTask {
    private static final Logger logger  = LogManager.getLogger(TestTask.class);

    public void run() {
        logger.info("定时器运行了");
    }
}
