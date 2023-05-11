package com.stu.test;

import com.stu.dao.IStudentDao;
import com.stu.model.Student;
import com.stu.util.DaoFactory;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Student> students = DaoFactory.getStudentDao().getAllStudents();
        IStudentDao sdao = DaoFactory.getStudentDao();
        for (Student i:students) {
            System.out.println(i);
        }
        System.out.println(DaoFactory.getStudentDao().findStudent("900427"));
        Student student = new Student("900427","qyh","男",22,"计算机系");
//        System.out.println(sdao.updateStudent(student));
        System.out.println(sdao.deleteStudent("900427"));
        sdao.insertStudent(student);
    }
}
