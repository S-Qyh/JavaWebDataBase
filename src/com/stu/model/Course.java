package com.stu.model;

public class Course {
    private String cno;
    private String cname;
    private int ccredit;

    public Course(String cno, String cname, int ccredit) {
        this.cno = cno;
        this.cname = cname;
        this.ccredit = ccredit;
    }

    public Course() {
    }

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public int getCcredit() {
        return ccredit;
    }

    public void setCcredit(int ccredit) {
        this.ccredit = ccredit;
    }
}
