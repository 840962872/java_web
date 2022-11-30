package com.studentTest.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.studentTest.bean.User;
import com.studentTest.dao.loginDao;
import com.studentTest.dao.loginDaoImpl;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class Test {
    public static void main(String[] args) throws SQLException {
//        DataSource dataSource = new ComboPooledDataSource();
//        Connection connection = dataSource.getConnection();
//        PreparedStatement ps = connection.prepareStatement("select u_id,u_name,u_pwd from user ;");
//        //ps.setString(1, "明华");
//        ResultSet rs = ps.executeQuery();
//        while (rs.next()) {
//            System.out.print("id: " + rs.getInt("u_id"));
//            System.out.print(", username: " + rs.getString("u_name"));
//            System.out.print(", password: " + rs.getString("u_pwd"));
//            System.out.println();
//        }
//        rs.close();
//        ps.close();
//        connection.close();


        int u_id = 1001;
        String u_pwd = "1";
        User user = new User();
        user.setU_id(u_id);
        user.setU_pwd(u_pwd);

        String sql = "select * from user where u_id="+u_id+" AND u_pwd='"+u_pwd+"'";
        loginDao ld = new loginDaoImpl();
        User resultUser = ld.logindao(user);
        if(resultUser != null){
            System.out.println(resultUser.toString());
            System.out.printf("账户密码一致");

        }else {
            System.out.printf("账户密码不对");
        }

       // System.out.printf(sql);
    }
}
