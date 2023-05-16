package com.wbu.hw.dao;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import static com.wbu.hw.util.DBConfigUtils.*;

public class DBCommon {

//    public static void main(String[] args) throws SQLException {
//        System.out.println(dataSource);
//        System.out.println(dataSource.getConnection());
//    }

    static BasicDataSource dataSource = new BasicDataSource();

    static {
        //设置驱动
        dataSource.setDriverClassName(getValue("driver_name"));
        //数据库
        dataSource.setUrl(getValue("url"));
        //账号
        dataSource.setUsername(getValue("user_name"));
        //密码
        dataSource.setPassword(getValue("user_pwd"));

    }

    public static DataSource getDS(){
        return dataSource;
    }

}
