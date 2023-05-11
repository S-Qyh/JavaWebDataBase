package com.stu.util;

import com.stu.dao.ICourseDao;
import com.stu.dao.IDeptDao;
import com.stu.dao.IStudentDao;
import com.stu.impl.CourseDaoImpl;
import com.stu.impl.DeptDaoImpl;
import com.stu.impl.StudentDaoImpl;

public class DaoFactory {
    public static IStudentDao getStudentDao() {
        return new StudentDaoImpl();
    }
    public static IDeptDao getDeptDao(){
        return new DeptDaoImpl();
    }

    public static ICourseDao getCourseDao(){
        return new CourseDaoImpl();
    }
}
