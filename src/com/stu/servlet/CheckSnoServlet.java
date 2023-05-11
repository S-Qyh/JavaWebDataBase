package com.stu.servlet;

import com.stu.util.DaoFactory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CheckSnoServlet", urlPatterns = {"/CheckSnoServlet"})
public class CheckSnoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      processRequest(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }

    protected void processRequest(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        String sno = request.getParameter("sno");
        PrintWriter out = response.getWriter();
        if (DaoFactory.getStudentDao().findStudent(sno)){
            out.write("{\"getdata\":\"false\"}");
        }else {
            out.write("{\"getdata\":\"true\"}");
        }
    }
}
