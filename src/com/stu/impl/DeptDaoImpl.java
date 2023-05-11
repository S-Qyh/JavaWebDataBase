package com.stu.impl;

import com.stu.dao.IDeptDao;
import com.stu.util.DatabaseBean;

import java.sql.*;
import java.util.ArrayList;

public class DeptDaoImpl implements IDeptDao {

    Connection conn = null;
    Statement stmt = null;

    ResultSet rs = null;
    @Override
    public ArrayList<String> getAllDept() {
        ArrayList<String> dept = new ArrayList<>();
        try {
            conn = DatabaseBean.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from stuDept");
            while (rs.next()) {
                String sdept = rs.getString("dept");
                dept.add(sdept);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DatabaseBean.close(rs, stmt, conn);
        }
        return dept;
    }
}
