package com.studentTest.servlet;

import com.studentTest.bean.Major;
import com.studentTest.bean.User;
import com.studentTest.service.fileService;
import com.studentTest.service.fileServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/show")
public class showServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //查看个人成绩
        int TeacherId = Integer.valueOf(req.getParameter("id"));
        int StudentId = Integer.valueOf(req.getParameter("v"));

        fileService fs = new fileServiceImpl();
        ArrayList<Major> studentuser = fs.getPersonInfo(StudentId);
        req.setAttribute("arr",studentuser);
        req.getRequestDispatcher("score.jsp").forward(req,resp);



    }
}
