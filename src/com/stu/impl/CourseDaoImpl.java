package com.stu.impl;

import com.stu.dao.ICourseDao;
import com.stu.model.Course;
import com.stu.model.Student;
import com.stu.util.DatabaseBean;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseDaoImpl implements ICourseDao {

    Connection conn = null;
    Statement stmt = null;
    PreparedStatement psmt = null;
    ResultSet rs = null;

    @Override
    public List<Course> getAllCourse() {
        List<Course> courses = new ArrayList<Course>();
        try {
            conn = DatabaseBean.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select Cno,Cname,Ccredit from Course");
            while (rs.next()) {
                Course course = new Course();
                course.setCno(rs.getString("Cno"));
                course.setCname(rs.getString("Cname"));
                course.setCcredit(rs.getInt("Ccredit"));
                courses.add(course);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DatabaseBean.close(rs, stmt, conn);
        }
        return courses;
    }

    @Override
    public boolean deleteCourse(String cno) {

        return false;
    }

    @Override
    public Course getCourse(String cno) {
        Course course = new Course();
        try {
            conn = DatabaseBean.getConnection();
            psmt = conn.prepareStatement("select Cno,Cname,Ccredit from Course where cno=?");
            psmt.setString(1, cno);
            rs = psmt.executeQuery();
            while (rs.next()) {
                course.setCno(rs.getString("cno"));
                course.setCname(rs.getString("cname"));
                course.setCcredit(rs.getInt("ccredit"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DatabaseBean.close(rs, psmt, conn);
        }
        return course;
    }

    @Override
    public Boolean insertCourse(Course course) {
        try {
            String sql = "insert into Course(cno, cname, ccredit) values(?,?,?)";
            conn = DatabaseBean.getConnection();
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, course.getCno());
            psmt.setString(2, course.getCname());
            psmt.setInt(3, course.getCcredit());
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
    public Boolean updateCourse(Course course) {
        try {
            String sql = "update Course set cno=?,cname=?,Ccredit=? where cno=?";
            conn = DatabaseBean.getConnection();
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, course.getCno());
            psmt.setString(2, course.getCname());
            psmt.setInt(3, course.getCcredit());
            psmt.setString(4, course.getCno());
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
}
