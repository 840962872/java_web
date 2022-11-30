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

@WebServlet("/mainServlet")
public class mainServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String v = req.getParameter("v");
        int userid = Integer.valueOf(req.getParameter("id"));
        //System.out.println(v);
        fileService fs = new fileServiceImpl();
        User user = fs.getFIleByNameOrId(v);
        ArrayList<User> arrUser = new ArrayList<>();
        arrUser.add(user);

        fileService fs2 = new fileServiceImpl();
        User adminUser = fs2.getNameById(userid);
        req.setAttribute("user",adminUser);
        if(user != null){

            req.setAttribute("arrUser",arrUser);
            req.getRequestDispatcher("mainPage.jsp").forward(req,resp);
        }else{
            ArrayList<User> arrUser2 = new ArrayList<>();
            fileService fs3 = new fileServiceImpl();
            arrUser2 = fs3.getAllStudent();
            req.setAttribute("arrUser",arrUser2);
            req.getRequestDispatcher("mainPage.jsp").forward(req,resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
