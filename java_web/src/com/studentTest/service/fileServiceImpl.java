package com.studentTest.service;

import com.studentTest.bean.Major;
import com.studentTest.bean.User;
import com.studentTest.dao.fileDao;
import com.studentTest.dao.fileDaoImpl;

import java.util.ArrayList;

public class fileServiceImpl implements fileService{
    fileDao fd = new fileDaoImpl();
    @Override
    public ArrayList<User> getAllStudent() {


        return fd.gerAllStudent();
    }

    @Override
    public User getFIleByNameOrId(String v) {
        return fd.getfileByNameOrId(v);
    }

    @Override
    public User getNameById(int id) {
        return fd.gerNameById(id);
    }

    @Override
    public ArrayList<Major> getPersonInfo(int studentId) {
        return fd.getPersonfile(studentId);
    }

    @Override
    public void del(int stu) {
        fd.del(stu);
    }

    @Override
    public void updateScore(int stuid, int a1, int a2, int a3) {
        fd.updateScore(stuid,a1,a2,a3);
    }
}
