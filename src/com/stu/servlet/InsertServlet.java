package com.stu.servlet;

import com.stu.model.Student;
import com.stu.util.DaoFactory;
import com.stu.util.DatabaseBean;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "InsertServlet", value = "/InsertServlet")
@MultipartConfig
public class InsertServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sno = new String(request.getParameter("sno").getBytes("iso-8859-1"), "utf-8");
        String sname = new String(request.getParameter("sname").getBytes("iso-8859-1"), "utf-8");
        String ssex = new String(request.getParameter("ssex").getBytes("iso-8859-1"), "utf-8");
        System.out.println(ssex);
        String sage = request.getParameter("sage");
        String sdept = new String(request.getParameter("sdept").getBytes("iso-8859-1"), "utf-8");
        String type = request.getParameter("type");
        Part part = request.getPart("photo");
        long size = part.getSize();
        if (size > 65000){
            request.setAttribute("message","学生照片尺寸应该小于65k");
            request.getRequestDispatcher("insert.jsp").forward(request,response);
            return;
        }

        Student stu = new Student();
        stu.setSno(sno);
        stu.setSage(Integer.parseInt(sage));
        stu.setSsex(ssex);
        stu.setSname(sname);
        stu.setSdept(sdept);


        if (size > 0 ) {
            String photoName = part.getSubmittedFileName();
            String fileName = sno + photoName.substring(photoName.lastIndexOf("."));

            String savePath = request.getServletContext().getRealPath("/photo");
            part.write(savePath + File.separator + fileName);
            stu.setPhoto_url(fileName);
        }else {
            if (type.equals("insert")) {
                stu.setPhoto_url("nopic.png");
            }else {
                String oldfilename = request.getParameter("oldfilename");
                stu.setPhoto_url(oldfilename);

            }
        }



        if ("insert".equals(type)) {
            boolean flag = DaoFactory.getStudentDao().insertStudent(stu);
            if (flag) {
                response.sendRedirect(request.getContextPath() + "/DisplayServlet");
            } else {
                request.setAttribute("message", "插入信息失败");
                request.getRequestDispatcher("insert.jsp").forward(request, response);
            }
        } else {
            boolean flag = DaoFactory.getStudentDao().updateStudent(stu);

            if (flag) {
                response.sendRedirect(request.getContextPath() + "/DisplayServlet");
            } else {
                request.setAttribute("message", "修改信息失败");
                request.setAttribute("student", stu);
                request.getRequestDispatcher("update.jsp").forward(request, response);
            }
        }

    }
}
