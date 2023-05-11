package com.stu.servlet;

import com.stu.model.Course;
import com.stu.model.Student;
import com.stu.util.DaoFactory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "UpdateCourseServlet", value = "/UpdateCourseServlet")
public class UpdateCourseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cno = request.getParameter("cno");
        Course course = DaoFactory.getCourseDao().getCourse(cno);
        request.setAttribute("course", course);
        request.getRequestDispatcher("UpdateCourseManage.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
