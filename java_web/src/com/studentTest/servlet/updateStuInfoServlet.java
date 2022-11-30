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

@WebServlet("/updateStuInfo")
public class updateStuInfoServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int admid = Integer.parseInt(req.getParameter("admid"));
        int stuid = Integer.parseInt(req.getParameter("stuid"));
        int a1 = Integer.parseInt(req.getParameter("a1"));
        int a2 = Integer.parseInt(req.getParameter("a2"));
        int a3 = Integer.parseInt(req.getParameter("a3"));
        //System.out.println(""+admid+","+stuid+","+a1+","+a2+","+a3);
        fileService fs = new fileServiceImpl();
        fs.updateScore(stuid,a1,a2,a3);

        User user = fs.getNameById(admid);
        ArrayList<User> arrUser = fs.getAllStudent();
        req.setAttribute("user",user);
        req.setAttribute("arrUser",arrUser);
        req.getRequestDispatcher("mainPage.jsp").forward(req,resp);


    }
}
