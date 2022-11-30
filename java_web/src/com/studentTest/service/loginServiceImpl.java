package com.studentTest.service;

import com.studentTest.bean.User;
import com.studentTest.dao.loginDao;
import com.studentTest.dao.loginDaoImpl;

import java.util.ArrayList;

public class loginServiceImpl implements loginService{

    @Override
    public User loginService(User u) {
        loginDao ld = new loginDaoImpl();
        return ld.logindao(u);
    }

}
