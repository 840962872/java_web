package com.studentTest.dao;

import com.studentTest.bean.User;
import com.studentTest.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class loginDaoImpl implements loginDao{

    @Override
    public User logindao(User u) {
        //在这里写数据库的东西
        //int id = u.getU_id();
        //String pwd = u.getU_pwd();
        //访问数据库
       // User user = new User(1001,"明华","1","13166666",1,0);


        int u_id = u.getU_id();
        String u_pwd = u.getU_pwd();
        String sql = "select * from user where u_id="+u_id+" AND u_pwd='"+u_pwd+"'";

        try {
            Connection connection = ConnectionFactory.getConnection();
            PreparedStatement ps = null;
            ResultSet rs = null;
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()){
                User user = new User();
                user.setU_id(rs.getInt("u_id"));
                user.setU_name(rs.getString("u_name"));
                user.setU_pwd(rs.getString("u_pwd"));
                user.setU_phone(rs.getString("u_phone"));
                user.setRole(rs.getInt("u_role"));
                user.setIsdelete(rs.getInt("u_isdelete"));
                connection.close();
                return user;
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }



        return null;
    }
}
