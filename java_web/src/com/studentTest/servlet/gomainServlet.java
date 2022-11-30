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

@WebServlet("/gomainPage")
public class gomainServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int admid = Integer.parseInt(req.getParameter("admid"));
        fileService fs = new fileServiceImpl();
        User user = fs.getNameById(admid);
        ArrayList<User> arrUser = fs.getAllStudent();
        req.setAttribute("user",user);
        req.setAttribute("arrUser",arrUser);
        req.getRequestDispatcher("mainPage.jsp").forward(req,resp);
    }
}
