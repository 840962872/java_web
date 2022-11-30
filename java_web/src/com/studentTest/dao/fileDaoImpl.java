package com.studentTest.dao;

import com.studentTest.bean.Major;
import com.studentTest.bean.User;
import com.studentTest.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class fileDaoImpl implements fileDao{
    @Override
    public ArrayList<User> gerAllStudent() {
        String sql = "select * from user where u_role=0 AND u_isdelete=0;";
        ArrayList<User> arrUser = new ArrayList<>();

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
                arrUser.add(user);
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }



        return arrUser;
    }



    @Override
    public User getfileByNameOrId(String v) {
        String sql = "select * from user where u_name='"+v+"'";

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

    @Override
    public User gerNameById(int id) {
        //int intid = Integer.valueOf(id);
        String sql = "select u_id,u_name from user where u_id="+id;
        //System.out.println(sql);
        User user = new User();
        try {
            Connection connection = ConnectionFactory.getConnection();
            PreparedStatement ps = null;
            ResultSet rs = null;
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()){

                user.setU_id(rs.getInt("u_id"));
                user.setU_name(rs.getString("u_name"));

            }
            connection.close();
            return user;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //return null;
    }

    @Override
    public ArrayList<Major> getPersonfile(int studentId) {

        String sql = "select c_id, c_score from choose where u_id="+studentId;
        //System.out.println(sql);
        User user = new User();
        try {
            Connection connection = ConnectionFactory.getConnection();
            PreparedStatement ps = null;
            ResultSet rs = null;
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            ArrayList<Major> arrMajor = new ArrayList<>();
            while (rs.next()){
                Major m = new Major();
                m.setA(rs.getInt("c_id"));
                m.setB(rs.getInt("c_score"));
                arrMajor.add(m);
            }
            connection.close();
            return arrMajor;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void del(int stu) {
        String sql = "delete from user where u_id="+stu;
        String sql2 = "delete from choose where u_id="+stu;
        try {
            Connection connection = ConnectionFactory.getConnection();
            PreparedStatement ps = null;
            ResultSet rs = null;
            ps = connection.prepareStatement(sql);
            ps.executeUpdate();
            ps = connection.prepareStatement(sql2);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateScore(int stuid, int a1, int a2, int a3) {
        String sql = "update choose set c_score="+a1+" where u_id="+stuid+" and c_id=1001";
        String sql2 = "update choose set c_score="+a2+" where u_id="+stuid+" and c_id=1002";
        String sql3 = "update choose set c_score="+a3+" where u_id="+stuid+" and c_id=1003";
        try {
            Connection connection = ConnectionFactory.getConnection();
            PreparedStatement ps = null;
            ResultSet rs = null;
            ps = connection.prepareStatement(sql);
            ps.executeUpdate();
            ps = connection.prepareStatement(sql2);
            ps.executeUpdate();
            ps = connection.prepareStatement(sql3);
            ps.executeUpdate();
        connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
