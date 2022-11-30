package com.studentTest.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/update")
public class updateServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int stuid = Integer.parseInt(req.getParameter("stuId"));
        int admid = Integer.parseInt(req.getParameter("id"));

        req.setAttribute("admid",admid);
        req.setAttribute("stuid",stuid);
        req.getRequestDispatcher("updatePage.jsp").forward(req,resp);
    }
}
