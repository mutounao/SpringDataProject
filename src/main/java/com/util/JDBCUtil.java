package com.util;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @desc:工具类
 * @className: JDBCUtil
 * @author: Dong Yu
 * @date: 2019/2/28 16:02
 */
public class JDBCUtil {

    /**
     * @Description: 获取Connection
     * @Param: []
     * @return: java.sql.Connection
     * @Author: Dong Yu
     * @date: 2019/2/28
     */
    public static Connection getConnection() throws Exception {

        /**
         * 不建议大家把配置文件编码带代码中
         *
         * 最好写到配置文件中
         */
//        String driverClass = "com.mysql.jdbc.Driver";
//        String url = "jdbc:mysql:///studentdb";
//        String user = "root";
//        String password = "123456";

        InputStream inputStream = JDBCUtil.class.getClassLoader().getResourceAsStream("db.properties");
        Properties properties = new Properties();
        properties.load(inputStream);

        String driverClass = properties.getProperty("jdbc.driverClass");
        String url = properties.getProperty("jdbc.url");
        String user = properties.getProperty("jdbc.user");
        String password = properties.getProperty("jdbc.password");

        Class.forName(driverClass);
        Connection connection = DriverManager.getConnection(url, user, password);

        return connection;
    }

    /**
     * @Description: 释放资源
     * @Param: [resultSet, statement, connection]
     * @return: void
     * @Author: Dong Yu
     * @date: 2019/2/28
     */
    public static void release(ResultSet resultSet, Statement statement, Connection connection) {


        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

}