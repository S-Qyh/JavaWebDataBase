package com.stu.test;

import com.stu.dao.IDeptDao;
import com.stu.util.DaoFactory;

public class TestDept {
    public static void main(String[] args) {
        IDeptDao iDeptDao = DaoFactory.getDeptDao();
        System.out.println(iDeptDao.getAllDept());
    }
}
