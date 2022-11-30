package com.studentTest.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionFactory {
    //获取数据源，自动选择c3p0-config.xml文件
    private static DataSource dataSource = new ComboPooledDataSource();
    //获取连接
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    //资源关闭工具
    public static void close(Connection connection, PreparedStatement ps, ResultSet rs) throws SQLException {
        if(rs != null) rs.close();
        if(ps != null) ps.close();
        if(connection != null) connection.close();

    }

}
