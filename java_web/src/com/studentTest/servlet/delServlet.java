package com.studentTest.servlet;

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

@WebServlet("/del")
public class delServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int adm = Integer.parseInt(req.getParameter("id"));
        int stu = Integer.parseInt(req.getParameter("v"));

        fileService fs = new fileServiceImpl();
        fs.del(stu);

        User admUser = fs.getNameById(adm);
        ArrayList<User> arrUser = fs.getAllStudent();

        req.setAttribute("user",admUser);
        req.setAttribute("arrUser",arrUser);
        req.getRequestDispatcher("mainPage.jsp").forward(req,resp);


    }
}
