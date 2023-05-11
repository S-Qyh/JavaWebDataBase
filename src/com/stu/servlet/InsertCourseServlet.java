package com.stu.servlet;

import com.stu.model.Course;
import com.stu.util.DaoFactory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "InsertCourseServlet", value = "/InsertCourseServlet")
public class InsertCourseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cno = request.getParameter("cno");
        String cname = request.getParameter("cname");
        String credit = request.getParameter("ccredit");
        String type = request.getParameter("type");
        int ccredit = Integer.parseInt(credit);
        Course course = new Course(cno,cname,ccredit);
        if ("insert".equals(type)) {
            boolean flag = DaoFactory.getCourseDao().insertCourse(course);
            if (flag) {
                response.sendRedirect(request.getContextPath() + "/CourseManage");
            } else {
                request.setAttribute("message", "插入信息失败");
                request.getRequestDispatcher("insertCourse.jsp").forward(request, response);
            }
        } else {
            boolean flag = DaoFactory.getCourseDao().updateCourse(course);

            if (flag) {
                response.sendRedirect(request.getContextPath() + "/CourseManage");
            } else {
                request.setAttribute("message", "修改信息失败");
                request.setAttribute("course", course);
                request.getRequestDispatcher("updateCourse.jsp").forward(request, response);
            }
        }
    }
}
