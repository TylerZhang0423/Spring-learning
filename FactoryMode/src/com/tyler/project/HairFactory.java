package com.tyler.project;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @author ：Tyler Zhang
 * @date ：Created in 2020-02-11 19:37
 */
public class HairFactory {

    public HairInterface getHairByClassKey(String key) {
        try {
            Map<String, String> map = new PropertiesReader().getProperties();

            HairInterface hair = (HairInterface) Class.forName(map.get(key)).getDeclaredConstructor().newInstance();
            //Class.forName(map).newInstance();这种写法已经淘汰
            return hair;
        }catch (InstantiationException e) {
            e.printStackTrace();
        }catch (IllegalAccessException e) {
            e.printStackTrace();
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return null;
    }
}
