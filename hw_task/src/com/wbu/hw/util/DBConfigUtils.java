package com.wbu.hw.util;

import java.io.FileInputStream;
import java.util.Properties;

public class DBConfigUtils {

//    public static void main(String[] args) {
//        System.out.println(DBConfigUtils.getValue("driver_name"));
//    }

    private static Properties pro = new Properties();

    static {
        try {
            FileInputStream fis = new FileInputStream("conf/db.properties");
            pro.load(fis);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static String getValue(String key){
        return pro.getProperty(key);
    }

}
