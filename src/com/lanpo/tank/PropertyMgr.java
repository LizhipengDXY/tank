package com.lanpo.tank;

import java.io.IOException;
import java.util.Properties;

/**
 * @author li zhipeng
 * @date 2021/5/21
 * @Description:
 */
public class PropertyMgr {
    private static Properties properties = new Properties();
    static {
        try {
            properties.load(PropertyMgr.class.getClassLoader().getResourceAsStream("config"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object getKey(String key){
        if(properties == null){
            return null;
        }
        return properties.get(key);
    }

    public static void main(String[] args) {
        System.out.println(properties.get("initTankCount"));
    }

}
