package com.stu.servlet;

import com.stu.util.DaoFactory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteCourseServlet", value = "/DeleteCourseServlet")
public class DeleteCourseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cno = request.getParameter("cno");
        boolean flag = DaoFactory.getCourseDao().deleteCourse(cno);
        if (flag){
            response.sendRedirect(request.getContextPath() + "/DisplayServlet");
        }else{
            request.setAttribute("Info","删除学生信息失败");
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
