package com.stu.model;

import com.stu.util.DaoFactory;
import com.stu.util.Pagination;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class StudentTableModel extends AbstractTableModel {
    //表格中第一行所要显示的内容存放在字符串数组columnNames中
    final String[] columnNames = {"学号","姓名","性别","年龄","系部"};

    //表格中各行的内容保存在集合列表中
    List<Student> rowsData;

    // 表格模型默认构造方法
//    public StudentTableModel() {
//        rowsData = DaoFactory.getStudentDao().getAllStudents();
//    }

    // 表格模型带参数构造方法
    public StudentTableModel(String sno) {
        rowsData = new ArrayList<Student>();
        rowsData.add(DaoFactory.getStudentDao().getStudent(sno));
    }

    public StudentTableModel(Pagination pagination) {
        rowsData = DaoFactory.getStudentDao().getAllStudentByPagination(pagination);
    }

    // 获得行的数目
    @Override
    public int getRowCount() {
        return rowsData.size();
    }

    // 获得列的数目
    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    //获得某行某列的数据，而数据保存在集合列表rowsData中
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return rowsData.get(rowIndex).getSno();
            case 1:
                return rowsData.get(rowIndex).getSname();
            case 2:
                return rowsData.get(rowIndex).getSsex();
            case 3:
                return rowsData.get(rowIndex).getSage();
            case 4:
                return rowsData.get(rowIndex).getSdept();
            default:
                return null;
        }
    }

    //获得某列的名字，而目前各列的名字保存在字符串数组columnNames中
    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }


}
