package com.studentTest.service;

import com.studentTest.bean.Major;
import com.studentTest.bean.User;

import java.util.ArrayList;

public interface fileService {
    ArrayList<User> getAllStudent();

    User getFIleByNameOrId(String v);

    User getNameById(int id);

    ArrayList<Major> getPersonInfo(int studentId);

    void del(int stu);

    void updateScore(int stuid, int a1, int a2, int a3);
}
