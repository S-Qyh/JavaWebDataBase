package com.stu.test;

import com.stu.util.DatabaseBean;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SavePic {
    public static void main(String[] args) throws SQLException, FileNotFoundException {
        Connection conn = null;
        PreparedStatement psmt = null;
        String filename = "src/com/stu/resource/HeadPic.JPG";
        conn = DatabaseBean.getConnection();
        psmt = conn.prepareStatement("update student set spicture= ? where sno = ?");
        psmt.setString(2,"100000");
        psmt.setBlob(1,new FileInputStream(filename));
        psmt.executeUpdate();
        psmt.close();
        conn.close();
        System.out.println("已更新");
    }
}
