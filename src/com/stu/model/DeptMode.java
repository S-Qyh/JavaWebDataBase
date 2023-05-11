package com.stu.model;

import com.stu.dao.IDeptDao;
import com.stu.dao.IStudentDao;
import com.stu.util.DaoFactory;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class DeptMode extends DefaultComboBoxModel<String> {

    DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
    public DeptMode(){
        IDeptDao deptDao = DaoFactory.getDeptDao();
        List<String> dept = new ArrayList<>();
        dept = deptDao.getAllDept();
        for (String s : dept) {
            model.addElement(s);
        }
    }

    public DefaultComboBoxModel<String> getModel() {
        return model;
    }

    public static void main(String[] args) {
        System.out.println(new DeptMode().model);
    }
}
