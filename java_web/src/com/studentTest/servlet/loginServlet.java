package com.studentTest.servlet;

import com.studentTest.bean.User;
import com.studentTest.service.fileService;
import com.studentTest.service.fileServiceImpl;
import com.studentTest.service.loginService;
import com.studentTest.service.loginServiceImpl;
import jdk.nashorn.internal.ir.RuntimeNode;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.RequestWrapper;
import java.io.IOException;
import java.util.ArrayList;

/*
* 这个注解就是我们起的名字,servlset为前端网页需要访问的后端的名字
* */

@WebServlet("/login")
public class loginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String u_id = req.getParameter("u_id");
        String u_pwd = req.getParameter("u_pwd");
        User u = new User();
        u.setU_id(Integer.valueOf(u_id));
        u.setU_pwd(u_pwd);

        //实现登录服务层的业务逻辑层
        loginService l = new loginServiceImpl();
        User user = l.loginService(u);

        if(user != null){
            //说明匹配了数据库
            //获取登录用户
            req.setAttribute("user",user);

            //获取所有学生列表
            fileService fs = new fileServiceImpl();
            ArrayList<User> arrUser = fs.getAllStudent();

            req.setAttribute("arrUser", arrUser);
            req.getRequestDispatcher("mainPage.jsp").forward(req,resp);
        }else {
            req.setAttribute("error", "账户和密码不一致");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }

        //System.out.printf("账户"+u.getU_id()+"  , 密码："+u.getU_pwd());


        //super.service(req, resp);
    }

    public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{

    }
    public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{

    }
}
