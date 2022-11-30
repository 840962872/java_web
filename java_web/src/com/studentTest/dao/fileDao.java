package com.studentTest.dao;

import com.studentTest.bean.Major;
import com.studentTest.bean.User;

import java.util.ArrayList;

public interface fileDao {
    ArrayList<User> gerAllStudent();

    User getfileByNameOrId(String v);

    User gerNameById(int id);

    ArrayList<Major> getPersonfile(int studentId);

    void del(int stu);

    void updateScore(int stuid, int a1, int a2, int a3);
}
