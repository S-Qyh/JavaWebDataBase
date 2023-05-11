package com.stu.dao;

import com.stu.model.Course;

import java.util.Currency;
import java.util.List;

public interface ICourseDao {
    public List<Course> getAllCourse();

    public boolean deleteCourse(String cno);

    public Course getCourse(String cno);

    public Boolean insertCourse(Course course);

    public Boolean updateCourse(Course course);
}
