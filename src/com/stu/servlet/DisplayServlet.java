package com.stu.servlet;

import com.stu.model.Student;
import com.stu.util.DaoFactory;
import com.stu.util.Pagination;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "DisplayServlet", value = "/DisplayServlet")
public class DisplayServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sno = request.getParameter("sno");
        String pageNo = request.getParameter("pageNo");
        Pagination pagination = new Pagination();
        pagination.setUrl("DisplayServlet");
        if (pageNo != null){
            pagination.setPageNo(Integer.parseInt(pageNo));
        }
        List<Student> allStudents;
        if ("".equals(sno) || sno == null){
            allStudents = DaoFactory.getStudentDao().getAllStudentByPagination(pagination);

        }else{
            allStudents = DaoFactory.getStudentDao().getSomeStudents(sno);
        }
        request.setAttribute("pagination",pagination);
        request.setAttribute("students",allStudents);
        request.getRequestDispatcher("index.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
