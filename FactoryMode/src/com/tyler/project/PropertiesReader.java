package com.tyler.project;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author ：Tyler Zhang
 * @date ：Created in 2020-02-11 20:26
 */
public class PropertiesReader {

    public Map<String, String> getProperties() {

        Properties props = new Properties();
        Map<String, String> map = new HashMap<String, String>();
        try {

            InputStream in = getClass().getResourceAsStream("type.properties");
            props.load(in);
            Enumeration en = props.propertyNames();
            while (en.hasMoreElements()) {
                String key = (String) en.nextElement();
                String property = props.getProperty(key);
                map.put(key, property);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }
}
