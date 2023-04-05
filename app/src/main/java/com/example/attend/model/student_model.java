package com.example.attend.model;

public class student_model {

    String stud_name , parent_no , stud_no , department , year , division ,stud_email , stud_enroll ;

    public student_model(String stud_name, String parent_no, String stud_no, String department, String year, String division, String stud_email, String stud_enroll) {
        this.stud_name = stud_name;
        this.parent_no = parent_no;
        this.stud_no = stud_no;
        this.department = department;
        this.year = year;
        this.division = division;
        this.stud_email = stud_email;
        this.stud_enroll = stud_enroll;
    }

    public student_model() {
    }

    public String getStud_name() {
        return stud_name;
    }

    public void setStud_name(String stud_name) {
        this.stud_name = stud_name;
    }

    public String getParent_no() {
        return parent_no;
    }

    public void setParent_no(String parent_no) {
        this.parent_no = parent_no;
    }

    public String getStud_no() {
        return stud_no;
    }

    public void setStud_no(String stud_no) {
        this.stud_no = stud_no;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getStud_email() {
        return stud_email;
    }

    public void setStud_email(String stud_email) {
        this.stud_email = stud_email;
    }

    public String getStud_enroll() {
        return stud_enroll;
    }

    public void setStud_enroll(String stud_enroll) {
        this.stud_enroll = stud_enroll;
    }
}

