package com.stu.servlet;

import com.stu.model.Course;
import com.stu.model.Student;
import com.stu.util.DaoFactory;
import com.stu.util.Pagination;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CourseManage", value = "/CourseManage")
public class CourseManagerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pageNo = request.getParameter("pageNo");
        Pagination pagination = new Pagination();
        pagination.setUrl("CourseManage");
        if (pageNo != null){
            pagination.setPageNo(Integer.parseInt(pageNo));
        }
        List<Course> allCourses;
        allCourses = DaoFactory.getCourseDao().getAllCourse();

        request.setAttribute("pagination",pagination);
        request.setAttribute("allCourses",allCourses);
        request.getRequestDispatcher("CourseManager.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
