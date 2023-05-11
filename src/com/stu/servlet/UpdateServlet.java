package com.stu.servlet;

import com.stu.model.Student;
import com.stu.util.DaoFactory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "UpdateServlet", value = "/UpdateServlet")
public class UpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sno = request.getParameter("sno");
        Student student = DaoFactory.getStudentDao().getStudent(sno);
        ArrayList<String> allDept = DaoFactory.getDeptDao().getAllDept();
        request.setAttribute("student",student);
        request.setAttribute("dept_list",allDept);
        request.getRequestDispatcher("update.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
