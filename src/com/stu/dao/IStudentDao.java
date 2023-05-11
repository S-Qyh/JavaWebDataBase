package com.stu.dao;

import com.stu.model.Student;
import com.stu.util.Pagination;

import java.util.List;

public interface IStudentDao {
    public List<Student> getAllStudents();

    public List<Student> getSomeStudents(String sno);
    public Student getStudent(String sno);
    public boolean findStudent(String sno);
    public boolean insertStudent(Student stu);
    public boolean updateStudent(Student stu);
    public boolean deleteStudent(String sno);

    public List<Student> getAllStudentByPagination(Pagination pagination);

    public List<Student> getStudentByPagination(Pagination pagination);



}
