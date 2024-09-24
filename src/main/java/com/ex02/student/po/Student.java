package com.ex02.student.po;

public class Student {
    private String sno;
    private String sname;
    private String ssex;
    private String snative;
    private int mno;

    public String getSno() {
        return sno;
    }

    public String getSname() {
        return sname;
    }

    public String getSsex() {
        return ssex;
    }

    public String getSnative() {
        return snative;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public void setSsex(String ssex) {
        this.ssex = ssex;
    }

    public void setSnative(String snative) {
        this.snative = snative;
    }

    public int getMno() {
        return mno;
    }

    public void setMno(int mno) {
        this.mno = mno;
    }

// 省略了getter和setter方法

    @Override
    public String toString() {
        return "Student{" +
                "sno='" + sno + '\'' +
                ", sname='" + sname + '\'' +
                ", ssex='" + ssex + '\'' +
                ", snative='" + snative + '\'' +
                ", mno=" + mno +
                '}';
    }


}
