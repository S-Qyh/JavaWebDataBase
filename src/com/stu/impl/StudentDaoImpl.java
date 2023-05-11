package com.stu.impl;

import com.stu.dao.IStudentDao;
import com.stu.model.Student;
import com.stu.util.DatabaseBean;
import com.stu.util.Pagination;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StudentDaoImpl implements IStudentDao {

    Connection conn = null;
    Statement stmt = null;
    PreparedStatement psmt = null;
    ResultSet rs = null;


    @Override
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<Student>();

        try {
            conn = DatabaseBean.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select sno,sname,ssex,sage,sdept,photo_url from student");
            while (rs.next()) {
                Student stu = new Student();
                stu.setSno(rs.getString("sno"));
                stu.setSname(rs.getString("sname"));
                stu.setSsex(rs.getString("ssex"));
                stu.setSage(rs.getInt("sage"));
                stu.setSdept(rs.getString("sdept"));
                stu.setPhoto_url(rs.getString("photo_url"));
                students.add(stu);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DatabaseBean.close(rs, stmt, conn);
        }
        return students;
    }

    @Override
    public List<Student> getSomeStudents(String sno) {
        List<Student> students = new ArrayList<Student>();

        try {
            conn = DatabaseBean.getConnection();
            String sql = "select sno,sname,ssex,sage,sdept,photo_url from student where sno like ?";
            psmt = conn.prepareStatement(sql);
            psmt.setString(1,"%"+sno+"%");
            rs = psmt.executeQuery();
            while (rs.next()) {
                Student stu = new Student();
                stu.setSno(rs.getString("sno"));
                stu.setSname(rs.getString("sname"));
                stu.setSsex(rs.getString("ssex"));
                stu.setSage(rs.getInt("sage"));
                stu.setSdept(rs.getString("sdept"));
                stu.setPhoto_url(rs.getString("photo_url"));
                students.add(stu);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DatabaseBean.close(rs, stmt, conn);
        }
        return students;
    }

    @Override
    public Student getStudent(String sno) {
        Student stu = new Student();
        try {
            conn = DatabaseBean.getConnection();
            psmt = conn.prepareStatement("select sno,sname,ssex,sage,sdept,photo_url from student where sno=?");
            psmt.setString(1, sno);
            rs = psmt.executeQuery();
            while (rs.next()) {
                stu.setSno(rs.getString("sno"));
                stu.setSname(rs.getString("sname"));
                stu.setSsex(rs.getString("ssex"));
                stu.setSage(rs.getInt("sage"));
                stu.setSdept(rs.getString("sdept"));
                stu.setPhoto_url(rs.getString("photo_url"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DatabaseBean.close(rs, psmt, conn);
        }
        return stu;
    }

    @Override
    public boolean findStudent(String sno) {
        // 查找学生找到返回true
        try {
            conn = DatabaseBean.getConnection();
            String sql = "select sno from student where sno = ?";
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, sno);
            rs = psmt.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DatabaseBean.close(rs, stmt, conn);
        }
        return false;
    }

    @Override
    public boolean insertStudent(Student stu) {
        try {
            String sql = "insert into student(sno,sname,ssex,sage,sdept,photo_url) values(?,?,?,?,?,?)";
            conn = DatabaseBean.getConnection();
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, stu.getSno());
            psmt.setString(2, stu.getSname());
            psmt.setString(3, stu.getSsex());
            psmt.setInt(4, stu.getSage());
            psmt.setString(5, stu.getSdept());
            psmt.setString(6,stu.getPhoto_url());
            psmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DatabaseBean.close(rs, stmt, conn);
        }
        return false;
    }

    @Override
    public boolean updateStudent(Student stu) {

        //【补充代码…】
        try {
            String sql = "update student set sno=?,sname=?,ssex=?,sage=?,sdept=?,photo_url=? where sno=?";
            conn = DatabaseBean.getConnection();
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, stu.getSno());
            psmt.setString(2, stu.getSname());
            psmt.setString(3, stu.getSsex());
            psmt.setInt(4, stu.getSage());
            psmt.setString(5, stu.getSdept());
            psmt.setString(6, stu.getPhoto_url());

            psmt.setString(7, stu.getSno());
            int count = psmt.executeUpdate();
            if (count == 1)
                return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DatabaseBean.close(rs, stmt, conn);
        }
        return false;

    }

    @Override
    public boolean deleteStudent(String sno) {
        //【补充代码…】
        try {
            String sql = "delete from student where sno=?";
            conn = DatabaseBean.getConnection();
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, sno);
            int count = psmt.executeUpdate();
            if (count == 1) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DatabaseBean.close(rs, stmt, conn);
        }
        return false;

    }

    @Override
    public List<Student> getAllStudentByPagination(Pagination pagination) {
        List<Student> students = new ArrayList<Student>();
        try { //统计总记录数
            conn = DatabaseBean.getConnection();
            String sql = "select count(*) as counts from student";
            psmt = conn.prepareStatement(sql);
            rs = psmt.executeQuery();
            rs.next();
            pagination.setCountSize(rs.getInt("counts"));
//求指定显示的记录数
            int m = (pagination.getPageNo() - 1) * pagination.getPageSize();//偏移量
            int n = pagination.getPageSize();//每页最大条目 //小于等于该页最大条数，大于等于该页最小条数
            sql = "select * from student order by sno asc limit ?,?";
            psmt = conn.prepareStatement(sql);
            psmt.setInt(1, m);
            psmt.setInt(2, n);
            rs = psmt.executeQuery();
            while (rs.next()) {
                Student stu = new Student();
                stu.setSno(rs.getString("sno"));
                stu.setSname(rs.getString("sname"));
                stu.setSsex(rs.getString("ssex"));
                stu.setSage(rs.getInt("sage"));
                stu.setSdept(rs.getString("sdept"));
                stu.setPhoto_url(rs.getString("photo_url"));
                students.add(stu);
            }
        } catch (SQLException e) {
            Logger.getLogger(StudentDaoImpl.class.getName()).log(Level.SEVERE, null,
                    e);
            return null;
        } finally {
            DatabaseBean.close(rs, psmt, conn);
        }
        return students;
    }

    @Override
    public List<Student> getStudentByPagination(Pagination pagination) {
        List<Student> students = new ArrayList<Student>();
        try{
            // 统计总记录数
            conn = DatabaseBean.getConnection();
            String sql = "select count(*) as counts from student";
            psmt = conn.prepareStatement(sql);
            rs = psmt.executeQuery();
            rs.next();
            pagination.setCountSize(rs.getInt("counts"));
            // 求指定显示的记录数
            int m = (pagination.getPageNo() - 1) * pagination.getCountSize();  // 偏移量
            int n = pagination.getPageSize(); // 每页最大条目
            // 小于等于该页的最大条数，大于等于该页的最小条目数
            sql = "select sno,sname,ssex,sage,sdept,photo_url from Student order by SNO asc limit ?,?";
            psmt.setInt(1,m);
            psmt.setInt(2,n);
            rs = psmt.executeQuery();
            while(rs.next()){
                Student stu = new Student();
                stu.setSno(rs.getString("sno"));
                stu.setSname(rs.getString("sname"));
                stu.setSsex(rs.getString("ssex"));
                stu.setSage(rs.getInt("sage"));
                stu.setSdept(rs.getString("sdept"));
                stu.setPhoto_url(rs.getString("photo_url"));
                students.add(stu);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return students;
    }


}
